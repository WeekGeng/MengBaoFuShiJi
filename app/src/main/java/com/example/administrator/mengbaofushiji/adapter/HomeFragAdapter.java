package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.github.siyamed.shapeimageview.RoundedImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

/**
 * Created by Administrator on 2015/4/7.
 */

/**
 * 主页里面的Listview adapter
 */
public class HomeFragAdapter extends BaseAdapter{
    private String[] data;
    private int height;
    private int[] resId={R.drawable.mengbaozaocan,R.drawable.jinrizhixing,R.drawable.chunrixiaoshi,R.drawable.fushidaren,R.drawable.fenxiangdaren};
    public HomeFragAdapter(String[] data) {
        this.data=data;
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v==null){
            v= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listview_item_list,null);
            height=v.getHeight();
        }
        TextView tv=(TextView)v.findViewById(R.id.home_frag_tv_list_biaoti);
        tv.setText(data[position]);
        RoundedImageView iv=(RoundedImageView)v.findViewById(R.id.home_frag_iv_list_left);
//        iv.setImageResource(resId[position]);
        String url = ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(resId[position]));
        ImageLoader.getInstance().displayImage(url,iv);
        return v;
    }
}
