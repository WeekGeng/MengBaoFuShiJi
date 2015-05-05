package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.List;
import java.util.Map;

public class AddLogsAdapter extends BaseAdapter {
	private List<Map<String, Object>> list;
	private LayoutInflater inflater;
	private int[] imgs;
	public AddLogsAdapter(List<Map<String, Object>> list) {
		super();
		this.list = list;
	}
	@Override
	public View getView(int position, View v, ViewGroup parent) {
		ViewHolder viewHolder = null;
		imgs= (int[]) list.get(position).get("img");
		if (v == null) {
			viewHolder = new ViewHolder();
			inflater = LayoutInflater.from(parent.getContext());
			v = inflater.inflate(R.layout.activity_addlogs_list_item,null);
			viewHolder.addlogs_tv_show_year=(TextView) v.findViewById(R.id.addlogs_tv_show_year);
			viewHolder.addlogs_tv_show_month=(TextView) v.findViewById(R.id.addlogs_tv_show_month);
			viewHolder.addlogs_title_tv=(TextView) v.findViewById(R.id.addlogs_title_tv);
			viewHolder.addlogs_tv_show_content=(TextView) v.findViewById(R.id.addlogs_tv_show_content);
			viewHolder.andlogs_iv_tools=(ImageView) v.findViewById(R.id.andlogs_iv_tools);
			viewHolder.andlogs_iv_tiaoweiliao=(ImageView) v.findViewById(R.id.andlogs_iv_tiaoweiliao);
			viewHolder.view_2=v.findViewById(R.id.view_2);
			
			v.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) v.getTag();
		}
		String yearStr = list.get(position).get("year").toString();
		String monthStr = list.get(position).get("month").toString();
		String titleStr = list.get(position).get("title").toString();
		String contentStr = list.get(position).get("content").toString();
		viewHolder.addlogs_tv_show_year.setText(yearStr);
		viewHolder.addlogs_tv_show_month.setText(monthStr);
		viewHolder.addlogs_title_tv.setText(titleStr);
		viewHolder.addlogs_tv_show_content.setText(contentStr);
		String url1= ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(imgs[0]));
		String url2= ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(imgs[1]));
		ImageLoader.getInstance().displayImage(url1,viewHolder.andlogs_iv_tools);
		ImageLoader.getInstance().displayImage(url2,viewHolder.andlogs_iv_tiaoweiliao);

		if (position==0||yearStr.equals(list.get(position-1).get("year").toString())) {
			viewHolder.addlogs_tv_show_year.setText(" ");
			viewHolder.addlogs_tv_show_year.setVisibility(View.GONE);
			v.findViewById(R.id.shuxian).setVisibility(View.VISIBLE);
			if (position==0) {
				viewHolder.addlogs_tv_show_year.setText(yearStr);
				viewHolder.addlogs_tv_show_year.setVisibility(View.VISIBLE);
				v.findViewById(R.id.shuxian).setVisibility(View.GONE);
			}
		}else {
			viewHolder.addlogs_tv_show_year.setText(yearStr);
			viewHolder.addlogs_tv_show_year.setVisibility(View.VISIBLE);
			v.findViewById(R.id.shuxian).setVisibility(View.GONE);
		}
		if (position==list.size()-1) {
			viewHolder.view_2.setVisibility(View.GONE);
		}else {
			viewHolder.view_2.setVisibility(View.VISIBLE);
		}
		return v;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	class ViewHolder {
		public TextView addlogs_tv_show_year;
		public TextView addlogs_tv_show_month;
		public TextView addlogs_title_tv;
		public TextView addlogs_tv_show_content;
		public ImageView andlogs_iv_tools;
		public ImageView andlogs_iv_tiaoweiliao;
		public View view_2;
	}
}

