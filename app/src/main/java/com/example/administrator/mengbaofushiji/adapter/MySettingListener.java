package com.example.administrator.mengbaofushiji.adapter;
import android.view.View;
import android.view.View.OnClickListener;
public class MySettingListener implements OnClickListener {
	private static MySettingListener listen=null;
	private MySettingListener(){}
	public static synchronized MySettingListener getInstance(){
		if(listen==null){
			listen = new MySettingListener();
		}
		return listen;
	}
	@Override
	public void onClick(View v) {
		
	}
}