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
    public Get get;
    public int SIZE=2;
    public PopupListAdapter(Get get){
        this.get=get;
    }
    @Override
    public int getCount() {
        return SIZE;
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
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_add_address,null);
        }
        final TextView shopping_address=(TextView)convertView.findViewById(R.id.shopping_address);
        shopping_address.setText("上海杨浦区飞虹路568弄15号");
        TextView shopping_address_del=(TextView)convertView.findViewById(R.id.shopping_address_del);
        shopping_address_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SIZE--;
                notifyDataSetChanged();
            }
        });
        shopping_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get.getData(shopping_address.getText().toString());
            }
        });
        return convertView;
    }
    public interface Get{
        void getData(String text);
    }
}
