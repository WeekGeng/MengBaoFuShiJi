package com.example.administrator.mengbaofushiji.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyPagerShiPuAdapter;
import com.example.administrator.mengbaofushiji.consts.Const;
import com.example.administrator.mengbaofushiji.extras.FoodDetailScrollView;
import com.example.administrator.mengbaofushiji.extras.PagerSlidingTabStrip;
import com.example.administrator.mengbaofushiji.toolsdetailfragment.ToolsDetailFirstFragment;
import com.example.administrator.mengbaofushiji.toolsdetailfragment.ToolsDetailSecondFragment;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.dragtoplayout.DragTopLayout;

public class ToolsDetailActivity extends ActionBarActivity{
    private Toolbar toolbar;
    private FoodDetailScrollView tools_detail_sv;
    private TextView buy_now;
    private TextView add_to_gouwuche;
    private ViewPager tools_detail_pager;
    private PagerSlidingTabStrip tools_detail_tabs;
    private List<Fragment> list;
    ToolsDetailFirstFragment toolsDetailFirstFragment;
    ToolsDetailSecondFragment toolsDetailSecondFragment;
    PagerAdapter adapter;
    private DragTopLayout tools_detail_dragtoplayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools_detail);
        initView();
        initToolBar();
        setListener();
    }
    public void setDrog(Boolean b){
        tools_detail_dragtoplayout.setTouchMode(b);
    }
    private void setListener() {
//        tools_detail_sv.setOnScrollListener(this);
        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToolsDetailActivity.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });
        add_to_gouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToolsDetailActivity.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });
//        tools_detail_dragtoplayout.setOnDragListener(new View.OnDragListener() {
//            @Override
//            public boolean onDrag(View v, DragEvent event) {
//                switch (event.getAction()){
//                    case DragEvent.ACTION_DRAG_ENDED:
//                        Log.i("info","ACTION_DRAG_ENDED");
//                        break;
//                    case DragEvent.ACTION_DRAG_ENTERED:
//                        Log.i("info","ACTION_DRAG_ENTERED");
//                        break;
//                    case DragEvent.ACTION_DROP:
//                        Log.i("info","ACTION_DROP");
//                }
//                return false;
//            }
//        });
    }
    private void initView() {
        list=new ArrayList<>();
        toolsDetailFirstFragment=new ToolsDetailFirstFragment();
        toolsDetailSecondFragment=new ToolsDetailSecondFragment();
        list.add(toolsDetailFirstFragment);
        list.add(toolsDetailSecondFragment);
//        tools_detail_sv=(FoodDetailScrollView)findViewById(R.id.tools_detail_sv);
        tools_detail_dragtoplayout=(DragTopLayout)findViewById(R.id.tools_detail_dragtoplayout);
        tools_detail_dragtoplayout.setOverDrag(false);
        buy_now=(TextView)findViewById(R.id.buy_now);
        add_to_gouwuche=(TextView)findViewById(R.id.add_to_gouwuche);
        tools_detail_pager=(ViewPager)findViewById(R.id.tools_detail_pager);
        adapter=new MyPagerShiPuAdapter(getSupportFragmentManager(), Const.TOOLS_DETAIL_TITLE,list);
        tools_detail_pager.setAdapter(adapter);
        tools_detail_tabs=(PagerSlidingTabStrip)findViewById(R.id.tools_detail_tabs);
        tools_detail_tabs.setViewPager(tools_detail_pager);
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("工具详情");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tools_detail, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.gouwuche:
                Intent intent=new Intent(ToolsDetailActivity.this,ShoppingActivity.class);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onScroll(int scrollY) {
//        Log.i("scrollY",""+scrollY);
//        if (scrollY<=300&&scrollY>=0) {
//                toolbar.getBackground().setAlpha(255 * scrollY / 300);
//        }else if (scrollY==0){
//            toolbar.getBackground().setAlpha(0);
//        }
//    }
}
