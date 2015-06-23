package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.github.siyamed.shapeimageview.RoundedImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/23.
 */
public class SchoolToolsAdapter extends BaseAdapter {
    List<Map<String,Object>> list;
    public SchoolToolsAdapter( List<Map<String,Object>> list){
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
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_child_item, parent, false);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(position).get("url").toString(), childViewHolder.school_explv_child_iv);
        childViewHolder.school_explv_child_title.setText(list.get(position).get("title").toString());
        childViewHolder.school_explv_child_content.setText(list.get(position).get("description").toString());
        childViewHolder.school_explv_child_tv_liulan.setText(list.get(position).get("seecount").toString());
        childViewHolder.school_explv_child_tv_shoucang.setText(list.get(position).get("collectionCount").toString());
        childViewHolder.school_explv_child_tv_goumai.setText(list.get(position).get("buyCount").toString());
        return convertView;
    }
    class ChildViewHolder {
        RoundedImageView school_explv_child_iv;
        TextView school_explv_child_title;
        TextView school_explv_child_content;
        TextView school_explv_child_tv_liulan;
        TextView school_explv_child_tv_shoucang;
        TextView school_explv_child_tv_goumai;

        public ChildViewHolder(View view) {
            this.school_explv_child_iv = (RoundedImageView) view.findViewById(R.id.school_explv_child_iv);
            this.school_explv_child_title = (TextView) view.findViewById(R.id.school_explv_child_title);
            this.school_explv_child_content = (TextView) view.findViewById(R.id.school_explv_child_content);
            this.school_explv_child_tv_liulan = (TextView) view.findViewById(R.id.school_explv_child_tv_liulan);
            this.school_explv_child_tv_shoucang = (TextView) view.findViewById(R.id.school_explv_child_tv_shoucang);
            this.school_explv_child_tv_goumai = (TextView) view.findViewById(R.id.school_explv_child_tv_goumai);
        }
    }
}
