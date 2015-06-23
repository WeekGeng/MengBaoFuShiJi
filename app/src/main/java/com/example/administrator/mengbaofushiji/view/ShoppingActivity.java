package com.example.administrator.mengbaofushiji.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.ShoppingAdapter;

public class ShoppingActivity extends ActionBarActivity {
    ListView gouwuche_lv;
    ShoppingAdapter adapter;
    private Toolbar toolbar;
    private TextView gouwuche_pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        initView();
        initToolBar();
        setListener();
    }
    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("购物车");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setListener() {
    }
    private void initView() {
        gouwuche_lv=(ListView)findViewById(R.id.gouwuche_lv);
        adapter=new ShoppingAdapter();
        View view= LayoutInflater.from(this).inflate(R.layout.gouwuche_footer,null);
        gouwuche_pay=(TextView)view.findViewById(R.id.gouwuche_pay);
        gouwuche_lv.addFooterView(view);
        gouwuche_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShoppingActivity.this,ShopPayActivity.class);
                startActivity(intent);
            }
        });
        gouwuche_lv.setAdapter(adapter);
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