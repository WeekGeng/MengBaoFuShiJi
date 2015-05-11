package com.example.administrator.mengbaofushiji.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.administrator.mengbaofushiji.R;

import java.util.ArrayList;

public class AddLogsShiPuActivity extends ActionBarActivity {
    private LinearLayout add_logs_add_shicai_liner;
    private ArrayList<View> list;
    private View v;
    private int i=0;
    private Toolbar toolbar;
    private Spinner add_logs_sp_nandu;
    private Spinner add_logs_sp_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_logs_shi_pu);
        initView();
        initToolBar();
    }

    private void initToolBar() {
        try {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("食谱笔记");
            toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {

        }
    }

    private void initView() {
        add_logs_add_shicai_liner=(LinearLayout) findViewById(R.id.add_logs_add_shicai_liner);
        list=new ArrayList<View>();
        v= LayoutInflater.from(this).inflate(R.layout.add_logs_add_shicai_item_bottom, add_logs_add_shicai_liner,false);
        list.add(0, v);
        add_logs_add_shicai_liner.addView(v);
        LinearLayout liner=(LinearLayout)v.findViewById(R.id.add_logs_add_shicai_bottom_liner);
        liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addViews(i);
                add_logs_add_shicai_liner.removeAllViews();
                i++;
                for (View views : list) {
                    add_logs_add_shicai_liner.addView(views);
                }
            }
        });
        String[] nanDuSpinner=getResources().getStringArray(R.array.nanduspinnername);
        String[] timeSpinner=getResources().getStringArray(R.array.timespinnername);
        add_logs_sp_nandu=(Spinner)findViewById(R.id.add_logs_sp_nandu);
        add_logs_sp_time=(Spinner)findViewById(R.id.add_logs_sp_time);
        ArrayAdapter<String> nanDuAdapter=new ArrayAdapter<String>(this,R.layout.add_logs_biji_spiner_item_top,nanDuSpinner);
        ArrayAdapter<String> timeAdapter=new ArrayAdapter<String>(this,R.layout.add_logs_biji_spiner_item_top,timeSpinner);
        nanDuAdapter.setDropDownViewResource(R.layout.add_logs_biji_spiner_item_bottom);
        timeAdapter.setDropDownViewResource(R.layout.add_logs_biji_spiner_item_bottom);
        add_logs_sp_nandu.setAdapter(nanDuAdapter);
        add_logs_sp_time.setAdapter(timeAdapter);
    }
    public void addViews(int i) {
        View view=LayoutInflater.from(this).inflate(R.layout.add_logs_add_shicai_item_top, add_logs_add_shicai_liner,false);
        list.add(i, view);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_logs_shi_pu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }if (id==R.id.commit){
            Intent intent=new Intent(AddLogsShiPuActivity.this,AddLogsStepActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
