package com.example.administrator.mengbaofushiji;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mengbaofushiji.fragment.AddLogs;
import com.example.administrator.mengbaofushiji.fragment.HomeFragment;
import com.example.administrator.mengbaofushiji.fragment.ShareFragment;
import com.example.administrator.mengbaofushiji.fragment.ShipuFragment;
import com.example.administrator.mengbaofushiji.fragment.TalkFragment;
import com.example.administrator.mengbaofushiji.view.YaoYiYaoActivity;

import org.w3c.dom.Text;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends ActionBarActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ShareActionProvider mShareActionProvider;
    private Toolbar mToolbar;
    private String title;
    private ListView lv_show;
    private String[] data;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private TextView tv_shouye;
    private TextView tv_fushi;
    private TextView tv_ketang;
    private TextView tv_share;
    private ImageView iv_addlogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        Fragment home = new HomeFragment();
        transaction.add(R.id.content, home);
        transaction.commit();
        initViews();
        setListeners();
    }

    /**
     * 设置RadioGroup的监听器
     */
    private void setListeners() {
        lv_show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (data[position].equals("好友分享")){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "试试看");          // 分享的主题
                    intent.putExtra(Intent.EXTRA_TEXT,"http://www.baidu.com");  // 分享的内容
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(Intent.createChooser(intent, "分享gif测试"));
                }
            }
        });
        tv_fushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                Fragment shipu = new ShipuFragment();
                transaction.replace(R.id.content, shipu);
                transaction.commit();
                setToolBarTitle(tv_fushi.getText().toString());
            }
        });
        tv_shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                Fragment home = new HomeFragment();
                transaction.replace(R.id.content, home);
                transaction.commit();
                setToolBarTitle(tv_shouye.getText().toString());
            }
        });
        tv_ketang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                Fragment talk = new TalkFragment();
                transaction.replace(R.id.content, talk);
                transaction.commit();
                setToolBarTitle(tv_ketang.getText().toString());
            }
        });
        tv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                Fragment share = new ShareFragment();
                transaction.replace(R.id.content, share);
                transaction.commit();
                setToolBarTitle(tv_share.getText().toString());
            }
        });
        iv_addlogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                Fragment addlogs = new AddLogs();
                transaction.replace(R.id.content, addlogs);
                transaction.commit();
                setToolBarTitle("日志");
            }
        });
    }

    /**
     * 设置toolbar的标题
     */
    private void setToolBarTitle(String text) {
        title=text;
        getSupportActionBar().setTitle(title);
    }
    /**
     * 初始化参数
     */
    private void initViews() {
        tv_fushi=(TextView)findViewById(R.id.shipu);
        tv_shouye=(TextView)findViewById(R.id.shouye);
        tv_ketang=(TextView)findViewById(R.id.ketang);
        tv_share=(TextView)findViewById(R.id.share);
        iv_addlogs=(ImageView)findViewById(R.id.add_logs);
        listViewSet();
        toolBarSet();
    }

    /**
     * 设置toolBar的其他参数
     */
    private void toolBarSet() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("主页");
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

	    /* 菜单的监听可以在toolbar里设置，也可以像ActionBar那样，通过下面的两个回调方法来处理 */
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this, "action_settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(MainActivity.this, "action_share", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /* findView */
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    /**
     * 初始化ListView中所需要的参数
     */
    private void listViewSet() {
        data=new String[]{"个人资料","摇一摇","辅食笔记","好友分享","我的关注","我的收藏","版本更新","意见反馈"};
        lv_show=(ListView)findViewById(R.id.lv_person_ziliao);
        MyListAdapter adapter=new MyListAdapter();
        lv_show.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
		/* ShareActionProvider */
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu
                .findItem(R.id.action_share));
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        mShareActionProvider.setShareIntent(intent);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 构建ListView的对象
     */
    class MyListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            v=LayoutInflater.from(parent.getContext()).inflate(R.layout.toolbar_list_item,null);
            final TextView tv=(TextView)v.findViewById(R.id.toolbar_tv_person);
            tv.setText(data[position]);
            tv.setTextSize(16);
            tv.setMaxHeight(20);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ("摇一摇".equals(tv.getText().toString())){
                        Intent intent=new Intent(MainActivity.this, YaoYiYaoActivity.class);
                        startActivity(intent);
                    }
                }
            });
            return v;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }
}
