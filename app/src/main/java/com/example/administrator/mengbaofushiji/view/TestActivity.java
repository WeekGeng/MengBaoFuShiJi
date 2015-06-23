package com.example.administrator.mengbaofushiji.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyPagerShiPuAdapter;
import com.example.administrator.mengbaofushiji.consts.Const;
import com.example.administrator.mengbaofushiji.extras.PagerSlidingTabStrip;
import com.example.administrator.mengbaofushiji.toolsdetailfragment.ToolsDetailFirstFragment;
import com.example.administrator.mengbaofushiji.toolsdetailfragment.ToolsDetailSecondFragment;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends ActionBarActivity {
    private ViewPager tools_detail_pager;
    private PagerSlidingTabStrip tools_detail_tabs;
    private List<Fragment> list;
    ToolsDetailFirstFragment toolsDetailFirstFragment;
    ToolsDetailSecondFragment toolsDetailSecondFragment;
    private MyPagerShiPuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        list=new ArrayList<>();
        toolsDetailFirstFragment=new ToolsDetailFirstFragment();
        toolsDetailSecondFragment=new ToolsDetailSecondFragment();
        list.add(toolsDetailFirstFragment);
        list.add(toolsDetailSecondFragment);
        tools_detail_pager=(ViewPager)findViewById(R.id.tools_detail_pager);
        adapter=new MyPagerShiPuAdapter(getSupportFragmentManager(), Const.TOOLS_DETAIL_TITLE,list);
        tools_detail_pager.setAdapter(adapter);
        tools_detail_tabs=(PagerSlidingTabStrip)findViewById(R.id.tools_detail_tabs);
        tools_detail_tabs.setViewPager(tools_detail_pager);
    }
}
