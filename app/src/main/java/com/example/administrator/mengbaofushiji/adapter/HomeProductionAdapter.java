package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/20.
 */
public class HomeProductionAdapter extends BaseAdapter {
    private List<Map<String,Object>> list;
    public HomeProductionAdapter(List<Map<String,Object>> list){
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
            convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.home_production_gv_item,null);
        }
        ImageView imageView= (ImageView) convertView.findViewById(R.id.home_production_gv_item_iv);
        TextView textView=(TextView)convertView.findViewById(R.id.home_production_gv_item_tv);
        String url= ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(list.get(position).get("img")));
        ImageLoader.getInstance().displayImage(url,imageView);
        textView.setText(String.valueOf(list.get(position).get("title")));
        return convertView;
    }
}
