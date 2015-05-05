package com.example.administrator.mengbaofushiji.adapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;

import java.util.List;
import java.util.Map;

public class TimelineAdapter extends BaseAdapter {
	private List<Map<String, Object>> list;
	private LayoutInflater inflater;
	private int[] imgs;
	private boolean ONESIZE;
	private OnClickListener listener;
	public TimelineAdapter(Context context, List<Map<String, Object>> list) {
		super();
		this.list = list;
		listener=MyListener.getInstance();
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		imgs= (int[]) list.get(position).get("img");
		if (imgs!=null) {
			if (imgs.length>1) {
				ONESIZE=false;
			}else {
				ONESIZE=true;
			}
		}
		if (convertView == null) {
			viewHolder = new ViewHolder();
			inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.activity_list_time_item,null);
			viewHolder.view_2=(View)convertView.findViewById(R.id.view_2);
			viewHolder.year = (TextView) convertView.findViewById(R.id.tv_show_year);
			viewHolder.month_one_img = (TextView) convertView.findViewById(R.id.tv_show_month_one);
			viewHolder.month_two_img = (TextView) convertView.findViewById(R.id.tv_show_month);
			viewHolder.title_one_img = (TextView) convertView.findViewById(R.id.title_one_img);
			viewHolder.title_two_img = (TextView) convertView.findViewById(R.id.title_two_img);
			viewHolder.iv_one=(ImageView)convertView.findViewById(R.id.iv_1);
			viewHolder.iv_two_first=(ImageView)convertView.findViewById(R.id.iv2_1);
			viewHolder.iv_two_second=(ImageView)convertView.findViewById(R.id.iv2_2);
			viewHolder.content_one_img=(TextView)convertView.findViewById(R.id.content_one_img);
			viewHolder.content_bottom = (TextView) convertView.findViewById(R.id.content_bottom);
			viewHolder.content_top = (TextView) convertView.findViewById(R.id.content_top);
            viewHolder.relative_one_img=(RelativeLayout)convertView.findViewById(R.id.relative_one_img);
            viewHolder.relative_two_img=(RelativeLayout)convertView.findViewById(R.id.relative_two);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		String yearStr = list.get(position).get("year").toString();
		String monthStr = list.get(position).get("month").toString();
		String titleStr = list.get(position).get("title").toString();
		int height = viewHolder.year.getHeight();
		System.out.println(height);
		if (position==0||yearStr.equals(list.get(position-1).get("year").toString())) {
			viewHolder.year.setText(" ");
			viewHolder.year.setVisibility(View.GONE);
			convertView.findViewById(R.id.shuxian).setVisibility(View.VISIBLE);
			if (position==0) {
				viewHolder.year.setText(yearStr);
				viewHolder.year.setVisibility(View.VISIBLE);
				convertView.findViewById(R.id.shuxian).setVisibility(View.GONE);
			}
		}else {
			viewHolder.year.setText(yearStr);
			viewHolder.year.setVisibility(View.VISIBLE);
			convertView.findViewById(R.id.shuxian).setVisibility(View.GONE);
		}
		if (imgs==null) {
			RelativeLayout relative_one_img=(RelativeLayout)convertView.findViewById(R.id.relative_one_img);
			relative_one_img.setVisibility(View.VISIBLE);
			viewHolder.title_one_img.setText(titleStr);
			viewHolder.iv_one.setVisibility(View.GONE);
			viewHolder.month_one_img.setText(monthStr);
			RelativeLayout relative_two_img=(RelativeLayout)convertView.findViewById(R.id.relative_two);
			relative_two_img.setVisibility(View.GONE);
			viewHolder.relative_one_img.setOnClickListener(listener);
		}else {
			if (ONESIZE) {
				RelativeLayout relative_two_img=(RelativeLayout)convertView.findViewById(R.id.relative_two);
				relative_two_img.setVisibility(View.GONE);
				RelativeLayout relative_one_img=(RelativeLayout)convertView.findViewById(R.id.relative_one_img);
				relative_one_img.setVisibility(View.VISIBLE);
				viewHolder.iv_one.setVisibility(View.VISIBLE);
				viewHolder.title_one_img.setText(titleStr);
				viewHolder.month_one_img.setText(monthStr);
				Bitmap bitmap = BitmapFactory.decodeResource(parent.getContext().getResources(), imgs[0]);
				viewHolder.iv_one.setImageBitmap(bitmap);
				viewHolder.iv_one.setOnClickListener(listener);
				viewHolder.relative_one_img.setOnClickListener(listener);
			}else {
				RelativeLayout relative_two_img=(RelativeLayout)convertView.findViewById(R.id.relative_two);
				relative_two_img.setVisibility(View.VISIBLE);
				RelativeLayout relative_one_img=(RelativeLayout)convertView.findViewById(R.id.relative_one_img);
				relative_one_img.setVisibility(View.GONE);
				viewHolder.title_two_img.setText(titleStr);
				viewHolder.month_two_img.setText(monthStr);
				viewHolder.iv_two_first.setImageResource(imgs[0]);
				viewHolder.iv_two_first.setOnClickListener(listener);
				viewHolder.iv_two_second.setImageResource(imgs[1]);
				viewHolder.iv_two_second.setOnClickListener(listener);
				viewHolder.relative_two_img.setOnClickListener(listener);
			}
		}
		if (position==list.size()-1) {
			viewHolder.view_2.setVisibility(View.GONE);
		}else {
			viewHolder.view_2.setVisibility(View.VISIBLE);
		}
		return convertView;
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
	static class ViewHolder {
		public TextView year;
		public TextView month_one_img;
		public TextView month_two_img;
		public TextView title_one_img;
		public TextView title_two_img;
		public TextView content_one_img;
		public TextView content_top;
		public TextView content_bottom;
		public ImageView iv_one;
		public ImageView iv_two_first;
		public ImageView iv_two_second;
		public View view_2;
		public RelativeLayout relative_one_img;
		public RelativeLayout relative_two_img;
	}
}
