package com.example.administrator.mengbaofushiji.application;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2015/4/9.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        JPushInterface.init(this);
//        JPushInterface.setDebugMode(true);
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this);

        ImageLoader.getInstance().init(configuration);
    }
}

