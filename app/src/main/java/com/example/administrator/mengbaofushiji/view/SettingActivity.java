package com.example.administrator.mengbaofushiji.view;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.consts.Const;

public class SettingActivity extends ActionBarActivity {
	private ListView lv_show_settings;
	private String[] lists;
	private LinearLayout liner_clear;
	private TextView tv_cancle;
	private MyFinalListener listener;
	private Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting_main);
		getData();
		initToolBar();
		initView();
		setListeners();
	}

	private void initToolBar() {
		try {
			toolbar = (Toolbar) findViewById(R.id.toolbar);
//            toolbar.setTitleTextColor(Color.parseColor("#440000ff"));
			setSupportActionBar(toolbar);
					toolbar.setTitle("设置中心");
			toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
			getSupportActionBar().setHomeButtonEnabled(true);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		} catch (NullPointerException e) {

		}
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

	private void setListeners() {
		liner_clear.setOnClickListener(listener);
		tv_cancle.setOnClickListener(listener);
		lv_show_settings.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				if (lists[position].equals("使用说明")) {
					Intent intent = new Intent(SettingActivity.this, SettingDirectionActivity.class);
					intent.putExtra("position", position);
					startActivity(intent);
				} else if (lists[position].equals("关于萌宝辅食")) {
					Intent intent = new Intent(SettingActivity.this, SettingDirectionActivity.class);
					intent.putExtra("position", position);
					startActivity(intent);
				} else if (lists[position].equals("免责声明")) {
					Intent intent = new Intent(SettingActivity.this, SettingDirectionActivity.class);
					intent.putExtra("position", position);
					startActivity(intent);
				} else if (lists[position].equals("意见反馈")) {
					Intent intent = new Intent(SettingActivity.this, SettingDirectionActivity.class);
					intent.putExtra("position", position);
					startActivity(intent);
				}
			}
		});
	}
	private void getData() {
		lists= Const.SETTINGS;
	}
	private void initView() {
		listener=MyFinalListener.getInstance();
		lv_show_settings=(ListView)findViewById(R.id.lv_show_list);
		MyAdapter adapter=new MyAdapter();
		setListViewHeightBasedOnChildren(lv_show_settings);
		lv_show_settings.setAdapter(adapter);
		liner_clear=(LinearLayout)findViewById(R.id.clear_catch);
		tv_cancle=(TextView)findViewById(R.id.tv_cancle);
	}

	public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter =listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (adapter.getCount() - 1));
        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
        listView.setLayoutParams(params);
    }
	class MyAdapter extends BaseAdapter{

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView==null) {
				convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.setting_list_item, null);
			}
			TextView tv_settings = (TextView) convertView.findViewById(R.id.setting_item);
			tv_settings.setText(lists[position]);
			return convertView;
		}
		@Override
		public int getCount() {
			return lists.length;
		}
		@Override
		public Object getItem(int position) {
			return lists[position];
		}
		@Override
		public long getItemId(int position) {
			return position;
		}
	}
}
class MyFinalListener implements OnClickListener {
	private static MyFinalListener listen=null;
	private MyFinalListener(){}
	public static synchronized MyFinalListener getInstance(){
		if(listen==null){
			listen = new MyFinalListener();
		}
		return listen;
	}
	@Override
	public void onClick(final View v) {
		switch (v.getId()) {
		case R.id.clear_catch:
			AlertDialog.Builder db=new AlertDialog.Builder(v.getContext());
			db.setTitle("确定清除缓存么？");
			db.setMessage("清除后您的相册，用户头像以及缓存下来的照片都将重新下载");
			db.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(v.getContext(), "点击了确定",Toast.LENGTH_SHORT).show();
				}
			});
			db.setNegativeButton("取消", null);
			db.show();
			break;
		case R.id.tv_cancle:
			AlertDialog.Builder db_cancle=new AlertDialog.Builder(v.getContext());
			db_cancle.setTitle("你确定要退出当前账号么？");
			db_cancle.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(v.getContext(), "点击了确定", Toast.LENGTH_SHORT).show();
				}
			});
			db_cancle.setNegativeButton("取消", null);
			db_cancle.show();
			break;
		}
	}
}
