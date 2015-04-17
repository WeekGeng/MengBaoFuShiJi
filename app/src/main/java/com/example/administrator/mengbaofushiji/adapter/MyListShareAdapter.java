package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.mengbaofushiji.R;

/**
 * Created by Administrator on 2015/4/14.
 */
public class MyListShareAdapter extends BaseAdapter{
    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v==null){
            v= LayoutInflater.from(parent.getContext()).inflate(R.layout.share_list_all_item,null,false);
        }
        return v;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
