package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.mengbaofushiji.R;

import java.util.List;
import java.util.Map;

public class AddLogsAdapter extends BaseAdapter {
	public AddLogsAdapter(List<Map<String, Object>> list) {
		super();
	}
	@Override
	public View getView(final int position, View v, final ViewGroup parent) {
		if (v==null){
			v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_addlogs_list_item,null);
		}
		return v;
	}
	@Override
	public int getCount() {
		return 20;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
}

