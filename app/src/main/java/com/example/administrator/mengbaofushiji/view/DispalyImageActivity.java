package com.example.administrator.mengbaofushiji.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;

public class DispalyImageActivity extends ActionBarActivity {
    private Toolbar toolbar;
    private Intent intent;
    private ImageView dispaly_iv;
    private TextView dispaly_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispaly_image);
        initToolBar();
        initView();
    }

    private void initView() {
        intent=getIntent();
        int sId=intent.getIntExtra("img",0);
        String title=intent.getStringExtra("title");
        dispaly_iv=(ImageView)findViewById(R.id.dispaly_iv);
        dispaly_tv=(TextView)findViewById(R.id.dispaly_tv);
        dispaly_iv.setImageResource(sId);
        dispaly_tv.setText(title);
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("作品欣赏");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dispaly_image, menu);
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
