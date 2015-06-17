package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.mengbaofushiji.R;

/**
 * Created by Administrator on 2015/6/12.
 */
public class ShopingPayAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.shoping_detail_lv_item, null);
        }
        return convertView;
    }
}
