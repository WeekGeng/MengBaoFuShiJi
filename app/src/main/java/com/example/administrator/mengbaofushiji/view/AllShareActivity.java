package com.example.administrator.mengbaofushiji.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.consts.Const;

public class AllShareActivity extends ActionBarActivity {
    private ListView allshare_lv;
    private Toolbar toolbar;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_share);
        position=getIntent().getIntExtra("position",0);
        initView();
        initToolBar();
    }
    private void initToolBar() {
        allshare_lv=(ListView)findViewById(R.id.allshare_lv);
    }
    private void initView() {
        try {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(Const.SHARE_LIST[position]);
            toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
            getSupportActionBar().setHomeButtonEnabled(true);
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
