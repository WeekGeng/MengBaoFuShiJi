package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;

/**
 * Created by Administrator on 2015/6/10.
 */
public class ShoppingAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return 3;
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
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder=null;
        if (view==null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gouwuche_dialog_list_item, null);
            holder=new ViewHolder();
            holder.gouwuche_dialog_list_item_ed_money=(TextView)view.findViewById(R.id.gouwuche_dialog_list_item_ed_money);
            holder.gouwuche_minus=(ImageView)view.findViewById(R.id.gouwuche_minus);
            holder.gouwuche_plus=(ImageView)view.findViewById(R.id.gouwuche_plus);
            holder.gouwuche_dialog_list_item_ed_count=(TextView)view.findViewById(R.id.gouwuche_dialog_list_item_ed_count);
            holder.gouwuche_del=(ImageView)view.findViewById(R.id.gouwuche_del);
            view.setTag(holder);
        }else {
            holder=(ViewHolder)view.getTag();
        }
        holder.gouwuche_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.gouwuche_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.gouwuche_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
    class ViewHolder{
        ImageView gouwuche_minus;
        ImageView gouwuche_del;
        ImageView gouwuche_plus;
        TextView gouwuche_dialog_list_item_ed_count;
        TextView gouwuche_dialog_list_item_ed_money;
    }
}
