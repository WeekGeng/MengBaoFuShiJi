package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;

/**
 * Created by Administrator on 2015/6/12.
 */
public class PopupListAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 2;
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
        if (convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_single_choice,null);
        }
        TextView textView=(TextView)convertView.findViewById(android.R.id.text1);
        textView.setText("上海杨浦区飞虹路568弄15号");
        textView.setTextColor(parent.getContext().getResources().getColor(R.color.gray));
        textView.setTextSize(14.0f);
        return convertView;
    }
}
