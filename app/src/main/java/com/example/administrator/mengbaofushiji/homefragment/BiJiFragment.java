package com.example.administrator.mengbaofushiji.homefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mengbaofushiji.R;

/**
 * Created by Administrator on 2015/6/9.
 */
public class BiJiFragment extends Fragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_master_recommend_biji_fragment,container,false);
        return view;
    }
}
