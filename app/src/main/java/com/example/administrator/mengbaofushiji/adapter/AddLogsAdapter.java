package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mengbaofushiji.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.List;
import java.util.Map;

public class AddLogsAdapter extends BaseAdapter {
	private List<Map<String, Object>> list;
	private LayoutInflater inflater;
	private Object[] imgs;
	String url1;
	String url2;
	public AddLogsAdapter(List<Map<String, Object>> list) {
		super();
		this.list = list;
	}
	@Override
	public View getView(final int position, View v, final ViewGroup parent) {
		ViewHolder viewHolder = null;
		imgs= (Object[]) list.get(position).get("img");
		if (v == null) {
			viewHolder = new ViewHolder();
			inflater = LayoutInflater.from(parent.getContext());
			v = inflater.inflate(R.layout.activity_addlogs_list_item, null);
			viewHolder.addlogs_tv_show_year=(TextView) v.findViewById(R.id.addlogs_tv_show_year);
			viewHolder.addlogs_tv_show_month=(TextView) v.findViewById(R.id.addlogs_tv_show_month);
			viewHolder.addlogs_title_tv=(TextView) v.findViewById(R.id.addlogs_title_tv);
			viewHolder.addlogs_tv_show_content=(TextView) v.findViewById(R.id.addlogs_tv_show_content);
			viewHolder.andlogs_iv_tools=(ImageView) v.findViewById(R.id.andlogs_iv_tools);
			viewHolder.andlogs_iv_tiaoweiliao=(ImageView) v.findViewById(R.id.andlogs_iv_tiaoweiliao);
			viewHolder.view_2=v.findViewById(R.id.view_2);
			viewHolder.add_log_iv_del=(ImageView)v.findViewById(R.id.add_log_iv_del);
			v.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) v.getTag();
		}
		viewHolder.andlogs_iv_tools.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(parent.getContext(),"点击了工具",Toast.LENGTH_SHORT).show();
			}
		});
		viewHolder.andlogs_iv_tiaoweiliao.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(parent.getContext(),"点击了调味料",Toast.LENGTH_SHORT).show();
			}
		});
		String yearStr = list.get(position).get("year").toString();
		String monthStr = list.get(position).get("month").toString();
		String titleStr = list.get(position).get("title").toString();
		String contentStr = list.get(position).get("content").toString();
		int isVisible= (int) list.get(position).get("isvisible");
		if (String.valueOf(isVisible).equals("0")){
			viewHolder.add_log_iv_del.setVisibility(View.GONE);
		}else if(String.valueOf(isVisible).equals("1")){
			viewHolder.add_log_iv_del.setVisibility(View.VISIBLE);
			viewHolder.add_log_iv_del.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					list.remove(position);
					AddLogsAdapter.this.notifyDataSetChanged();
				}
			});
		}
		viewHolder.addlogs_tv_show_year.setText(yearStr);
		viewHolder.addlogs_tv_show_month.setText(monthStr);
		viewHolder.addlogs_title_tv.setText(titleStr);
		viewHolder.addlogs_tv_show_content.setText(contentStr);
		if (imgs[0].toString().contains("file:///")){
			url1=String.valueOf(imgs[0]);
			url2=String.valueOf(imgs[1]);
		}else{
			url1= ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(imgs[0]));
			url2= ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(imgs[1]));
		}
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
		public ImageView add_log_iv_del;
	}
}

