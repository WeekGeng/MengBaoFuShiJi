package com.example.administrator.mengbaofushiji.view;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.DialogAdapter;
import com.example.administrator.mengbaofushiji.extras.FoodDetailScrollView;

public class ToolsDetailActivity extends ActionBarActivity implements FoodDetailScrollView.OnScrollListener{
    private Toolbar toolbar;
    private FoodDetailScrollView tools_detail_sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools_detail);
        initView();
        initToolBar();
        setListener();
    }

    private void setListener() {

    }
    private void initView() {
        tools_detail_sv=(FoodDetailScrollView)findViewById(R.id.tools_detail_sv);
        tools_detail_sv.setOnScrollListener(this);
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
                View view= LayoutInflater.from(this).inflate(R.layout.gouwuche_dialog,null);
                ListView lv=(ListView)view.findViewById(R.id.gouwuche_lv);
                DialogAdapter adapter=new DialogAdapter();
                lv.setAdapter(adapter);
                Dialog dialog=new Dialog(this);
                dialog.addContentView(view,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                dialog.show();
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
