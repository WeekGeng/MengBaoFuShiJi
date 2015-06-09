package com.example.administrator.mengbaofushiji.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.ShareMasterAdapter;
import com.example.administrator.mengbaofushiji.animation.AnimationAdapter;
import com.example.administrator.mengbaofushiji.animation.SwingBottomInAnimationAdapter;
import com.example.administrator.mengbaofushiji.consts.Const;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeShareMasterActivity extends ActionBarActivity {
    private ListView home_share_master_lv;
    private int position;
    private Toolbar toolbar;
    List<Map<String,String>> list;
    Map<String,String> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_share_master);
        position=getIntent().getIntExtra("position",0);
        getData();
        initView();
        setListeners();
    }
    /**
     * 设置监听器事件
     */
    private void setListeners() {
        home_share_master_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //此处将用户信息传递过去。头像，作品，食谱3个需要传递的对象
                Intent intent=new Intent(HomeShareMasterActivity.this,MasterRecommendActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 初始化控件
     */
    private void initView() {
        home_share_master_lv=(ListView)findViewById(R.id.home_share_master_lv);
        ShareMasterAdapter adapter=new ShareMasterAdapter(list);
        home_share_master_lv.setAdapter(adapter);
        AnimationAdapter animAdapter = new SwingBottomInAnimationAdapter(adapter);
        animAdapter.setAbsListView(home_share_master_lv);
        home_share_master_lv.setAdapter(animAdapter);
        initToolBar();
    }

    /**
     * 初始化toolbar
     */
    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Const.HOMEITEMS[position]);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 获取数据源信息
     */
    public void getData() {
        String drawableUrla = ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.mastera));
        String drawableUrlb = ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.masterb));
        String drawableUrlc = ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.masterc));
        String drawableUrld = ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.masterd));
        String drawableUrle = ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.mastere));
        String drawableUrlf = ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.masterf));
        String drawableUrlg = ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.masterg));
        String drawableUrlh = ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.masterh));
        String drawableUrli = ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.masteri));
        String drawableUrlj = ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.masterj));
        list=new ArrayList<>();
        map=new HashMap<>();
        map.put("touxiang",drawableUrla);
        map.put("name","淼淼妈");
        map.put("share","10");
        map.put("qianming","我的宝宝最可爱");
        map.put("attention","no");
        list.add(map);
        map=new HashMap<>();
        map.put("touxiang",drawableUrlb);
        map.put("name","姗姗妈");
        map.put("share","9");
        map.put("qianming","我的宝宝最高了");
        map.put("attention","no");
        list.add(map);
        map=new HashMap<>();
        map.put("touxiang",drawableUrlc);
        map.put("name","巧巧妈");
        map.put("share","8");
        map.put("qianming","我的宝宝最可爱");
        map.put("attention","no");
        list.add(map);
        map=new HashMap<>();
        map.put("touxiang",drawableUrld);
        map.put("name","猪猪妈");
        map.put("share","7");
        map.put("qianming","我的宝宝最可爱");
        map.put("attention","no");
        list.add(map);
        map=new HashMap<>();
        map.put("touxiang",drawableUrle);
        map.put("name","苗苗妈");
        map.put("share","6");
        map.put("qianming","我的宝宝最可爱");
        map.put("attention","no");
        list.add(map);
        map=new HashMap<>();
        map.put("touxiang",drawableUrlf);
        map.put("name","程程妈");
        map.put("share","5");
        map.put("qianming","我的宝宝最可爱");
        map.put("attention","no");
        list.add(map);
        map=new HashMap<>();
        map.put("touxiang",drawableUrlg);
        map.put("name","可爱妈");
        map.put("share","4");
        map.put("qianming","我的宝宝最可爱");
        map.put("attention","no");
        list.add(map);
        map=new HashMap<>();
        map.put("touxiang",drawableUrlh);
        map.put("name","欣欣妈");
        map.put("share","3");
        map.put("qianming","我的宝宝最可爱");
        map.put("attention","no");
        list.add(map);
        map=new HashMap<>();
        map.put("touxiang",drawableUrli);
        map.put("name","章欣怡");
        map.put("share","2");
        map.put("qianming","我的宝宝最可爱");
        map.put("attention","no");
        list.add(map);
        map=new HashMap<>();
        map.put("touxiang",drawableUrlj);
        map.put("name","囡囡妈");
        map.put("share","1");
        map.put("qianming","我的宝宝最可爱");
        map.put("attention","no");
        list.add(map);
    }
}
