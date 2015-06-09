package com.example.administrator.mengbaofushiji.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.view.MasterRecommendActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/14.
 */
public class MyListShareAdapter extends BaseAdapter{
    private Context context;
    private ImageView share_dianzan_icon;
    private List<Map<String,Object>> list;
    public MyListShareAdapter(Context context,List<Map<String,Object>> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public View getView(final int position, View v, final ViewGroup parent) {
        final LayoutInflater inflat=LayoutInflater.from(parent.getContext());
        final ViewHolder holder;
        if (v == null) {
            holder=new ViewHolder();
            v = inflat.inflate(R.layout.share_list_all_item, null, false);
            holder.share_alldata_tv_name=(TextView)v.findViewById(R.id.share_alldata_tv_name);
            holder.share_alldata_tv_data=(TextView)v.findViewById(R.id.share_alldata_tv_data);
            holder.all_share_tv_content=(TextView)v.findViewById(R.id.all_share_tv_content);
            holder.iv_pinglun =(ImageView)v.findViewById(R.id.share_pinglun_icon);
            holder.share_dianzan_icon=(ImageView)v.findViewById(R.id.share_dianzan_icon);
            holder.share_alldata_iv=(ImageView)v.findViewById(R.id.share_alldata_iv);
            v.setTag(holder);
        }else {
            holder=(ViewHolder)v.getTag();
        }
        holder.share_alldata_tv_name.setText(String.valueOf(list.get(position).get("nickName")));
        holder.share_alldata_tv_data.setText(String.valueOf(list.get(position).get("time")));
        holder.all_share_tv_content.setText(String.valueOf(list.get(position).get("content")));
        String url= ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(list.get(position).get("photo")));
        ImageLoader.getInstance().displayImage(url, holder.share_alldata_iv);
        int iszan=(Integer) list.get(position).get("iszan");
        if (iszan==0){
            holder.share_dianzan_icon.setImageResource(R.drawable.dianzan_before);
        }else if (iszan==1){
            holder.share_dianzan_icon.setImageResource(R.drawable.dianzan_after);
        }
        holder.share_dianzan_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = inflat.inflate(R.layout.share_toast_item, null);
                TextView toast_tv = (TextView) view.findViewById(R.id.toast_tv);
                Toast toast = new Toast(parent.getContext());
                if (String.valueOf(list.get(position).get("iszan")).equals("0")) {
                    list.get(position).put("iszan", 1);
                    MyListShareAdapter.this.notifyDataSetChanged();
//                    Toast.makeText(parent.getContext(),"已点赞",Toast.LENGTH_SHORT).show();
                    toast_tv.setText("已点赞");
                    toast.setView(view);
                } else if (String.valueOf(list.get(position).get("iszan")).equals("1")) {
                    list.get(position).put("iszan", 0);
                    MyListShareAdapter.this.notifyDataSetChanged();
                    toast_tv.setText("取消点赞");
                    toast.setView(view);
                }
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        holder.iv_pinglun.setTag(position);
        holder.iv_pinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "点击了", Toast.LENGTH_SHORT).show();
            }
        });
        holder.share_alldata_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), MasterRecommendActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        return v;
    }
    class ViewHolder{
        private TextView share_alldata_tv_name;
        private TextView share_alldata_tv_data;
        private TextView all_share_tv_content;
        public ImageView iv_pinglun;
        public ImageView share_dianzan_icon;
        public ImageView share_alldata_iv;
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
