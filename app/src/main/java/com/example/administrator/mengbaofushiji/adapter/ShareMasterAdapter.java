package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.extras.CircleImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/19.
 */
public class ShareMasterAdapter extends BaseAdapter{
    List<Map<String,String>> list;
    public ShareMasterAdapter(List<Map<String,String>> list){
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_share_master_lv_item, null);
            holder=new ViewHolder();
            holder.iv= (CircleImageView) convertView.findViewById(R.id.home_share_master_lv_item_iv);
            holder.tv_name=(TextView)convertView.findViewById(R.id.home_share_master_lv_item_tv_name);
            holder.tv_share=(TextView)convertView.findViewById(R.id.home_share_master_lv_item_tv_share);
            holder.tv_qianMing=(TextView)convertView.findViewById(R.id.home_share_master_lv_item_tv_qianming);
            holder.tv_attention=(TextView)convertView.findViewById(R.id.home_share_master_lv_item_tv_attention);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(position).get("touxiang"), holder.iv);
        holder.tv_name.setText(list.get(position).get("name"));
        holder.tv_share.setText(list.get(position).get("share"));
        holder.tv_qianMing.setText(list.get(position).get("qianming"));
        if (list.get(position).get("attention").equals("yes")){
            holder.tv_attention.setBackgroundResource(R.drawable.master_attention);
        }else if (list.get(position).get("attention").equals("no")){
            holder.tv_attention.setBackgroundResource(R.drawable.master_not_attention);
        }
        holder.tv_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).get("attention").equals("yes")){
                    list.get(position).put("attention","no");
                }else if (list.get(position).get("attention").equals("no")){
                    list.get(position).put("attention","yes");
                }
                ShareMasterAdapter.this.notifyDataSetChanged();
            }
        });
        return convertView;
    }
    static class ViewHolder{
        CircleImageView iv;
        TextView tv_name;
        TextView tv_share;
        TextView tv_qianMing;
        TextView tv_attention;
    }
}
