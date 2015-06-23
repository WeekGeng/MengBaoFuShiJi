package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.mengbaofushiji.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/23.
 */
public class AddLogsListAdapter extends BaseAdapter {
    private List<Map<String,Object>> list;
    public AddLogsListAdapter(List<Map<String,Object>> list) {
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.valueOf(list.get(position).get("type").toString());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position)==0){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.addlogs_recyclerview_item_suishou,null);
        }else if (getItemViewType(position)==1){
            convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.addlogs_recyclerview_item_fushi,null);
        }
        return convertView;
    }
}
