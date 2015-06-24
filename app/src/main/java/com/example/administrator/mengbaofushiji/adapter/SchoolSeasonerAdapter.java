package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.github.siyamed.shapeimageview.RoundedImageView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/24.
 */
public class SchoolSeasonerAdapter extends BaseAdapter {
    private List<Map<String,Object>> list;
    private View view;
    public SchoolSeasonerAdapter(List<Map<String,Object>> list){
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
    public int getItemViewType(int position) {
        return Integer.valueOf(list.get(position).get("type").toString());
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_seasoner_fragment_lv_item_contain_img, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        if (getItemViewType(position) == 0) {
            viewHolder.seasoner_iv.setVisibility(View.GONE);
            viewHolder.tv_title.setText(list.get(position).get("title").toString());
            viewHolder.tv_content.setText(list.get(position).get("content").toString());
        } else if (getItemViewType(position) == 1) {
            viewHolder.seasoner_iv.setVisibility(View.VISIBLE);
            viewHolder.tv_title.setText(list.get(position).get("title").toString());
            viewHolder.tv_content.setText(list.get(position).get("content").toString());
            viewHolder.seasoner_iv.setImageResource(Integer.valueOf(list.get(position).get("img").toString()));
        }
        return convertView;
    }
    class ViewHolder{
        private TextView tv_title;
        private TextView tv_content;
        private ImageView seasoner_iv;
        public ViewHolder(View v){
            tv_title=(TextView)v.findViewById(R.id.tv_title);
            tv_content=(TextView)v.findViewById(R.id.tv_content);
            seasoner_iv=(RoundedImageView)v.findViewById(R.id.seasoner_iv);
        }
    }
//    class ImgViewHolder{
//        private TextView tv_title;
//        private TextView tv_content;
//        private ImageView seasoner_iv;
//        public ImgViewHolder(View v){
//            tv_title=(TextView)v.findViewById(R.id.tv_title);
//            tv_content=(TextView)v.findViewById(R.id.tv_content);
//            seasoner_iv=(RoundedImageView)v.findViewById(R.id.seasoner_iv);
//        }
//    }
}
