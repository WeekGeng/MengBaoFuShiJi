package com.example.administrator.mengbaofushiji.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyPagerShiPuAdapter;
import com.example.administrator.mengbaofushiji.consts.Const;
import com.example.administrator.mengbaofushiji.extras.CircleImageView;
import com.example.administrator.mengbaofushiji.extras.PagerSlidingTabStrip;
import com.example.administrator.mengbaofushiji.homefragment.ProductionFragment;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerFuShiSecondFragment;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.dragtoplayout.DragTopLayout;

public class MasterRecommendActivity extends ActionBarActivity {
    private DragTopLayout master_dragtoplayout;
    private TextView master_recommend_tv;
    boolean isAttention;
    private Toolbar toolbar;
    private int position;
    private CircleImageView master_circle_iv;
    private RelativeLayout liner_top;
    private PagerSlidingTabStrip pst;
    private ViewPager vp;
    private List<Fragment> list;
    private ProductionFragment firstFragment;
    private PagerFuShiSecondFragment secondFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_recommend);
        position=getIntent().getIntExtra("position",0);
        list=new ArrayList<>();
        firstFragment=new ProductionFragment();
        secondFragment=new PagerFuShiSecondFragment();
        list.add(firstFragment);
        list.add(secondFragment);
        initTooBar();
        initView();
        setListeners();
    }

    private void initTooBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("达人推荐");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setListeners() {
        master_recommend_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAttention){
                    master_recommend_tv.setBackgroundResource(R.drawable.master_not_attention);
                    isAttention=false;
                }else{
                    master_recommend_tv.setBackgroundResource(R.drawable.master_attention);
                    isAttention=true;
                }
            }
        });
    }
    private void initView() {
        master_circle_iv=(CircleImageView)findViewById(R.id.master_circle_iv);
        master_circle_iv.setImageResource(Const.RESOURSE[position]);
        master_dragtoplayout=(DragTopLayout)findViewById(R.id.master_dragtoplayout);
        master_dragtoplayout.setOverDrag(false);
        master_recommend_tv=(TextView)findViewById(R.id.master_recommend_tv);
        pst=(PagerSlidingTabStrip)findViewById(R.id.master_tabs);
        vp=(ViewPager)findViewById(R.id.master_pager);
        vp.setAdapter(new MyPagerShiPuAdapter(getSupportFragmentManager(), Const.MASTER_TITLE,list));
        pst.setViewPager(vp);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_master_recommend, menu);
        return true;
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
}
