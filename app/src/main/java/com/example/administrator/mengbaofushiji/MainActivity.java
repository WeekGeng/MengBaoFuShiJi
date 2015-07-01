package com.example.administrator.mengbaofushiji;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mengbaofushiji.fragment.AddLogs;
import com.example.administrator.mengbaofushiji.fragment.HomeFragment;
import com.example.administrator.mengbaofushiji.fragment.SchoolFragment;
import com.example.administrator.mengbaofushiji.fragment.ShareFragment;
import com.example.administrator.mengbaofushiji.fragment.ShipuFragment;
import com.example.administrator.mengbaofushiji.view.SearchShiPuActivity;
import com.example.administrator.mengbaofushiji.view.SettingActivity;
import com.example.administrator.mengbaofushiji.view.YaoYiYaoActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends ActionBarActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ShareActionProvider mShareActionProvider;
    public Toolbar mToolbar;
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
    private String[] tv_title;

    public static MainActivity instance;
    private TextView tv_mysetting;
    private final int FROM_GALLERY=200;
    private String filePath;
    private ImageView iv_setImg;
    private LinearLayout home_liner_share;
    private LinearLayout home_liner_nick;
    private TextView cebian_person_tv_name;
    List<Fragment> list;
    public int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance=this;
        Fragment home = new HomeFragment();
        fragmentManager=getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content,home);
        transaction.commit();
        initViews();
        setListeners();
    }
    /**
     * 设置RadioGroup的监听器
     */
    private void setListeners() {
        cebian_person_tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reviseNick();
            }
        });
        home_liner_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "试试看");          // 分享的主题
                intent.putExtra(Intent.EXTRA_TEXT, "http://www.baidu.com");  // 分享的内容
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent, "分享gif测试"));
            }
        });
        iv_setImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSys(MainActivity.this, FROM_GALLERY);
            }
        });
        tv_mysetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        tv_shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment home=new HomeFragment();
                position=0;
                setFragmentChose(home);
                tv_shouye.setSelected(true);
                tv_fushi.setSelected(false);
                tv_ketang.setSelected(false);
                tv_share.setSelected(false);
            }
        });
        tv_fushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fushi=new ShipuFragment();
                position=1;
                setFragmentChose(fushi);
                tv_fushi.setSelected(true);
                tv_shouye.setSelected(false);
                tv_ketang.setSelected(false);
                tv_share.setSelected(false);
            }
        });
        iv_addlogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment addlogs = new AddLogs();
                position=2;
                setFragmentChose(addlogs);
                tv_fushi.setSelected(false);
                tv_shouye.setSelected(false);
                tv_ketang.setSelected(false);
                tv_share.setSelected(false);
            }
        });
        tv_ketang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment ketang=new SchoolFragment();
                position=3;
                setFragmentChose(ketang);
                tv_fushi.setSelected(false);
                tv_shouye.setSelected(false);
                tv_ketang.setSelected(true);
                tv_share.setSelected(false);
            }
        });
        tv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment share=new ShareFragment();
                position=4;
                setFragmentChose(share);
                tv_fushi.setSelected(false);
                tv_shouye.setSelected(false);
                tv_ketang.setSelected(false);
                tv_share.setSelected(true);
            }
        });

    }

    private void setFragmentChose(Fragment fragment) {
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content,fragment);
        transaction.commit();
        setToolBarTitle(tv_title[position]);
//        Drawable[] drawable=tv_fushi.getCompoundDrawables();
//        getSupportActionBar().setLogo(drawable[1]);
    }

    private void reviseNick() {
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Window window = dialog.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        window.setContentView(R.layout.revise_nick_record_dialog);
        final EditText ed = (EditText) window.findViewById(R.id.revise_nick_record_dialog_ed);
        window.findViewById(R.id.revise_nick_record_dialog_bt_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = ed.getText().toString();
                if (s != null && s.length() != 0) {
                    cebian_person_tv_name.setText(s);
                    dialog.cancel();
                } else {
                    Toast.makeText(MainActivity.this, "昵称不能为空！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        window.findViewById(R.id.revise_nick_record_dialog_bt_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
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
        home_liner_share=(LinearLayout)findViewById(R.id.home_liner_share);
        cebian_person_tv_name=(TextView)findViewById(R.id.cebian_person_tv_name);
        tv_title=new String[5];
        tv_fushi=(TextView)findViewById(R.id.shipu);
        tv_shouye=(TextView)findViewById(R.id.shouye);
        tv_ketang=(TextView)findViewById(R.id.ketang);
        tv_share=(TextView)findViewById(R.id.share);
        iv_addlogs=(ImageView)findViewById(R.id.add_logs);

        tv_title[0]=tv_shouye.getText().toString();
        tv_title[1]=tv_fushi.getText().toString();
        tv_title[2]="日志";
        tv_title[3]=tv_ketang.getText().toString();
        tv_title[4]=tv_share.getText().toString();

        tv_mysetting=(TextView)findViewById(R.id.my_setting_main);
        iv_setImg=(ImageView)findViewById(R.id.cebian_person_img);
//        listViewSet();
        toolBarSet();
        tv_shouye.setSelected(true);
        tv_fushi.setSelected(false);
    }

    /**
     * 设置toolBar的其他参数
     */
    private void toolBarSet() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("主页");
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff"));
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

	    /* 菜单的监听可以在toolbar里设置，也可以像ActionBar那样，通过下面的两个回调方法来处理 */
//        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.ab_search:
//
//                        break;
//                    case R.id.action_share:
////                        Toast.makeText(MainActivity.this, "action_share", Toast.LENGTH_SHORT).show();
//                        break;
//                    default:
//                        break;
//                }
//                return false;
//            }
//        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /* findView */
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mToolbar.setTitle("用户中心");
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (title==null){
                    setToolBarTitle("首页");
                    return;
                }
                setToolBarTitle(title);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    /**
     * 初始化ListView中所需要的参数
     */
//    private void listViewSet() {
//        data=new String[]{"个人资料","摇一摇","辅食笔记","好友分享","我的关注","我的收藏","版本更新","意见反馈"};
//        lv_show=(ListView)findViewById(R.id.lv_person_ziliao);
//        MyListAdapter adapter=new MyListAdapter();
//        lv_show.setAdapter(adapter);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
		/* ShareActionProvider */
//        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu
//                .findItem(R.id.action_share));
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/*");
//        mShareActionProvider.setShareIntent(intent);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.ab_search) {
            Intent intent=new Intent(MainActivity.this, SearchShiPuActivity.class);
            startActivity(intent);
            return true;
        }else if (id==R.id.action_share){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/*");
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Toast.makeText(MainActivity.this, "相册", Toast.LENGTH_SHORT).show();
            if (requestCode == FROM_GALLERY) {
                if (data != null) {//相册
                    filePath = getPhotoPathByLocalUri(this, data);
                    Log.e("MainActivity", filePath);
                    DisplayImageOptions options = new DisplayImageOptions.Builder()
                            .cacheInMemory(true)
                            .cacheOnDisk(true)
                            .bitmapConfig(Bitmap.Config.RGB_565)
                            .build();
                    ImageLoader.getInstance().displayImage("file:///" + filePath, iv_setImg, options);
                }
            } else if (requestCode == FROM_GALLERY + 4) {
                if (data != null) {//文件
                    filePath = getPhotoPathByLocalUri(this, data);
                }
            }
        }
    }

    /**
     * 打开相册
     * @param activity
     * @param requestCode
     */
    public static void launchGallery(Activity activity, int requestCode) {
        if (launchSys(activity, requestCode) && launch3partyBroswer(activity, requestCode) && launchFinally(activity));
    }


    /**
     * PopupMenu打开本地相册.
     */
    private static boolean launchSys(Activity activity, int actResultCode) {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        try {
            activity.startActivityForResult(intent, actResultCode);

        } catch (android.content.ActivityNotFoundException e) {

            return true;
        }
        return false;
    }


    /**
     * 打开其他的一文件浏览器,如果没有本地相册的话
     */
    private static boolean launch3partyBroswer(Activity activity, int requestCode) {
        Toast.makeText(activity, "没有相册软件，运行文件浏览器", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT); // "android.intent.action.GET_CONTENT"
        intent.setType("image/*"); // 查看类型 String IMAGE_UNSPECIFIED =
        // "image/*";
        Intent wrapperIntent = Intent.createChooser(intent, null);
        try {
            activity.startActivityForResult(wrapperIntent, requestCode);
        } catch (android.content.ActivityNotFoundException e1) {
            return true;
        }
        return false;
    }

    /**
     * 这个是找不到相关的图片浏览器,或者相册
     */
    private static boolean launchFinally(Activity activity) {
        Toast.makeText(activity, "您的系统没有文件浏览器或则相册支持,请安装！", Toast.LENGTH_LONG).show();
        return false;
    }


    /**
     * 获取从本地图库返回来的时候的URI解析出来的文件路径
     *
     * @return
     */
    public static String getPhotoPathByLocalUri(Context context, Intent data) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();
        return picturePath;
    }

}
