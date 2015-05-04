package com.example.administrator.mengbaofushiji.view;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.secondorderfragment.SettingBaseFragment;

public class SettingDirectionActivity extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_direction);
		Intent intent = getIntent();
		int position = intent.getIntExtra("position", 0);
		SettingBaseFragment fragment=new SettingBaseFragment(position);
		FragmentManager manager=getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.content, fragment);
		transaction.commit();
	}
}
