package com.example.administrator.mengbaofushiji.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.administrator.mengbaofushiji.R;

public class YaoYiYaoActivity extends ActionBarActivity {

    private ImageView image_top;
    private ImageView image_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yao_yi_yao);
        initView();
    }

    private void initView() {
        image_top=(ImageView)findViewById(R.id.yaoyiyao_top);
        image_bottom=(ImageView)findViewById(R.id.yaoyiyao_bottom);
        startAnim();
    }

    public void startAnim() { // 定义摇一摇动画动画
        AnimationSet animup = new AnimationSet(true);
        TranslateAnimation mup0 = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
                -0.5f);
        mup0.setDuration(1000);
        TranslateAnimation mup1 = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
                +0.5f);
        mup1.setDuration(1000);
        //延迟执行1秒
        mup1.setStartOffset(1000);
        animup.addAnimation( mup0);
        animup.addAnimation( mup1);
        //上图片的动画效果的添加
        image_top.startAnimation(animup);
        AnimationSet animdn = new AnimationSet(true);
        TranslateAnimation mdn0 = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
                +0.5f);
        mdn0.setDuration(1000);
        TranslateAnimation mdn1 = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
                -0.5f);
        mdn1.setDuration(1000);
        //延迟执行1秒
        mdn1.setStartOffset(1000);
        animdn.addAnimation( mdn0);
        animdn.addAnimation( mdn1);
        //下图片动画效果的添加
        image_bottom.startAnimation(animdn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yao_yi_yao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
