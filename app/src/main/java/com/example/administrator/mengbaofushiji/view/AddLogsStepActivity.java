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
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mengbaofushiji.R;

public class AddLogsStepActivity extends ActionBarActivity {
    private ListView add_logs_add_fushi_step_lv;
    private ImageView add_logs_add_fushi_step_iv;
    private RelativeLayout retate_iv;
    private TextView  top_fushi;
    private TextView  bottom_suishouji;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_logs_step);
        retate_iv=(RelativeLayout)findViewById(R.id.retate_iv);
//        MyAnimation.startAnimationsOut(retate_iv,1,0);
        Intent intent=getIntent();
        initView();
        initToolBar();
        setListeners();
    }

    private void initToolBar() {
        try {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("添加步骤");
            toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {

        }
    }

    private void setListeners() {
        top_fushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddLogsStepActivity.this,"点击了上面",Toast.LENGTH_SHORT).show();
            }
        });
        bottom_suishouji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddLogsStepActivity.this,"点击了下面",Toast.LENGTH_SHORT).show();
            }
        });

        add_logs_add_fushi_step_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (retate_iv.getVisibility()==View.INVISIBLE){
                    int x=retate_iv.getWidth();
                    Log.i("info", "x===================" + x);
                    Animation rotateAnimation = new RotateAnimation(90, 0,x,x);
                    rotateAnimation.setDuration(300);
                    retate_iv.startAnimation(rotateAnimation);
                    retate_iv.setVisibility(View.VISIBLE);

                }else{
                    int x=retate_iv.getWidth();
                    Log.i("info", "x===================" + x);
                    Animation rotateAnimation = new RotateAnimation(0f, 90f,x,x);
                    rotateAnimation.setDuration(300);
                    retate_iv.startAnimation(rotateAnimation);
                    retate_iv.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
    private void initView() {
        top_fushi=(TextView)findViewById(R.id.top_fushi);
        bottom_suishouji=(TextView)findViewById(R.id.bottom_suishouji);
        add_logs_add_fushi_step_lv = (ListView) findViewById(R.id.add_logs_add_fushi_step_lv);
        add_logs_add_fushi_step_iv=(ImageView)findViewById(R.id.add_logs_add_fushi_step_iv);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_logs_step, menu);
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
