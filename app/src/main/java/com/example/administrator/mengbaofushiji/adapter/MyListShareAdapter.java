package com.example.administrator.mengbaofushiji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.mengbaofushiji.R;

/**
 * Created by Administrator on 2015/4/14.
 */
public class MyListShareAdapter extends BaseAdapter{
    LinearLayout liner;
    private Context context;
    public MyListShareAdapter(LinearLayout liner,Context context){
        this.context=context;
        this.liner=liner;
    }

    @Override
    public int getCount() {
        return 20;
    }
    @Override
    public View getView(final int position, View v, ViewGroup parent) {
        final ViewHolder holder;
        if (v == null) {
            holder=new ViewHolder();
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.share_list_all_item, null, false);
            holder.iv_pinglun =(ImageView)v.findViewById(R.id.share_pinglun_icon);
            v.setTag(holder);
        }else {
            holder=(ViewHolder)v.getTag();
        }
        holder.iv_pinglun.setTag(position);
        holder.iv_pinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "点击了", Toast.LENGTH_SHORT).show();
                liner.setVisibility(View.VISIBLE);
            }
        });

        return v;
    }
    class ViewHolder{
        public ImageView iv_pinglun;
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
