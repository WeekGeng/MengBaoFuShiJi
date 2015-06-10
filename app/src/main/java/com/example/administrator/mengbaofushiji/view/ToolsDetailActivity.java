package com.example.administrator.mengbaofushiji.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.extras.FoodDetailScrollView;

public class ToolsDetailActivity extends ActionBarActivity implements FoodDetailScrollView.OnScrollListener{
    private Toolbar toolbar;
    private FoodDetailScrollView tools_detail_sv;
    private TextView buy_now;
    private TextView add_to_gouwuche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools_detail);
        initView();
        initToolBar();
        setListener();
    }

    private void setListener() {
        tools_detail_sv.setOnScrollListener(this);
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
    }
    private void initView() {
        tools_detail_sv=(FoodDetailScrollView)findViewById(R.id.tools_detail_sv);
        buy_now=(TextView)findViewById(R.id.buy_now);
        add_to_gouwuche=(TextView)findViewById(R.id.add_to_gouwuche);
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_tools_details);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("工具详情");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getBackground().setAlpha(0);
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

    @Override
    public void onScroll(int scrollY) {
        Log.i("scrollY",""+scrollY);
        if (scrollY<=300&&scrollY>=0) {
                toolbar.getBackground().setAlpha(255 * scrollY / 300);
        }else if (scrollY==0){
            toolbar.getBackground().setAlpha(0);
        }
    }
}
