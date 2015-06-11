package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/11.
 */
public class AddLogStepAdapter extends BaseAdapter {
    List<Map<String,Object>> list;
    public AddLogStepAdapter(List<Map<String,Object>> list){
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
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.add_log_step_list_item,null);
        }
        ImageView add_log_step_item_iv=(ImageView)convertView.findViewById(R.id.add_log_step_item_iv);
        TextView  add_log_step_item_tv=(TextView)convertView.findViewById(R.id.add_log_step_item_tv);
        ImageLoader.getInstance().displayImage(String.valueOf(list.get(position).get("img")),add_log_step_item_iv);
        add_log_step_item_tv.setText(String.valueOf(list.get(position).get("title")));
        return convertView;
    }
}
