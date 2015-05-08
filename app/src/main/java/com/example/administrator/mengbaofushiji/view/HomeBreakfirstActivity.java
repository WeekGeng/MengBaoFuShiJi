package com.example.administrator.mengbaofushiji.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.consts.Const;
import com.example.administrator.mengbaofushiji.homefragment.MengBaoBreakFirstFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeBreakfirstActivity extends ActionBarActivity {
    private Toolbar toolbar;
    private Intent intent;
    private int position;
    List<Fragment> list;
    FragmentManager manager;
    FragmentTransaction transaction;
    MengBaoBreakFirstFragment breakFirstFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_breakfist);
        intent=getIntent();
        position=intent.getIntExtra("position", 0);
        list=new ArrayList<Fragment>();
        initToolBar();
        initFragment();
    }

    private void initFragment() {
        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        breakFirstFragment=new MengBaoBreakFirstFragment();
        list.add(breakFirstFragment);
        transaction.add(R.id.home_breakfirst_content,list.get(position));
        transaction.commit();
    }

    private void initToolBar() {
        try {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
            setSupportActionBar(toolbar);
            switch (position){
                case 0:
                    getSupportActionBar().setTitle(Const.HOMEITEMS[position]);
                    break;
            }
            getSupportActionBar().setHomeButtonEnabled(true); //���÷��ؼ�����

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {

        }
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
