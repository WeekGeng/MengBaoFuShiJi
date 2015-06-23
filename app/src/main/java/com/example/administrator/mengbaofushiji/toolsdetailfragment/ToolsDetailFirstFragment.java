package com.example.administrator.mengbaofushiji.toolsdetailfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.extras.FoodDetailScrollView;

/**
 * Created by Administrator on 2015/6/23.
 */
public class ToolsDetailFirstFragment extends Fragment{
    private FoodDetailScrollView tools_detail_scrollview;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tools_detail_vp_first,container,false);
        tools_detail_scrollview=(FoodDetailScrollView)view.findViewById(R.id.tools_detail_scrollview);
        return view;
    }
}
