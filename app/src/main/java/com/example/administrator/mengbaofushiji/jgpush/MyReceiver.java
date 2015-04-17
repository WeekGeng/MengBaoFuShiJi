package com.example.administrator.mengbaofushiji.jgpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.administrator.mengbaofushiji.view.NotifityActivity;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2015/4/9.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())){
            Intent in=new Intent(context, NotifityActivity.class);
            in.putExtras(bundle);
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(in);
        }
    }
}


