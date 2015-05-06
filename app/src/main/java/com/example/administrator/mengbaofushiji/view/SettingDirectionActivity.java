package com.example.administrator.mengbaofushiji.view;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.consts.Const;
import com.example.administrator.mengbaofushiji.secondorderfragment.SettingBaseFragment;

public class SettingDirectionActivity extends ActionBarActivity {
	private Toolbar toolbar;
	private int position;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_direction);
		Intent intent = getIntent();
		position = intent.getIntExtra("position", 0);
		SettingBaseFragment fragment=new SettingBaseFragment(position);
		initToolBar();
		FragmentManager manager=getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.content, fragment);
		transaction.commit();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case android.R.id.home:
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void initToolBar() {
		try {
			toolbar = (Toolbar) findViewById(R.id.toolbar);
			setSupportActionBar(toolbar);
			getSupportActionBar().setTitle(Const.SETTINGS[position]);
			toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
			getSupportActionBar().setHomeButtonEnabled(true);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		} catch (NullPointerException e) {

		}
	}
}
