package com.example.administrator.mengbaofushiji.view;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.mengbaofushiji.R;

public class DispalyFoodDetailActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispaly_food_detail);
        initView();
        initToolBar();
    }

    private void initView() {
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("制作辅食");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dispaly_food_detail, menu);
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
