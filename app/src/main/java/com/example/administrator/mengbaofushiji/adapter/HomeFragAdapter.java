package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.administrator.mengbaofushiji.R;

/**
 * Created by Administrator on 2015/4/7.
 */

/**
 * 主页里面的Listview adapter
 */
public class HomeFragAdapter extends BaseAdapter{
    private String[] data;
    private int height;
    public HomeFragAdapter(String[] data) {
        this.data=data;
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v==null){
            v= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listview_item_list,null);
            height=v.getHeight();
        }
        TextView tv=(TextView)v.findViewById(R.id.home_frag_tv_list_biaoti);
        tv.setText(data[position]);
        return v;
    }
}
