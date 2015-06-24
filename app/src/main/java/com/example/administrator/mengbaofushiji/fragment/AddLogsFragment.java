package com.example.administrator.mengbaofushiji.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.AddLogsListAdapter;
import com.example.administrator.mengbaofushiji.animation.AnimationAdapter;
import com.example.administrator.mengbaofushiji.animation.SwingBottomInAnimationAdapter;
import com.example.administrator.mengbaofushiji.extras.CircleImageView;
import com.example.administrator.mengbaofushiji.view.AddLogsShiPuActivity;
import com.example.administrator.mengbaofushiji.view.AddLogsSuiShouActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/23.
 */
public class AddLogsFragment extends Fragment {
    private List<Map<String,Object>> list;
    Map<String,Object> map;
    private Animation retateCircle;
    private Animation retateCircleIn;
    private RelativeLayout retate_iv;
    private TextView addlogs_top_fushi;
    private TextView addlogs_bottom_suishouji;
    private CircleImageView add_logs;
    private ListView listview;
    private AddLogsListAdapter adapter;
    private int x;
    private RotateAnimation retateOut;
    private RotateAnimation retateIn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
        retateCircle= AnimationUtils.loadAnimation(getActivity(), R.anim.retateout);
        retateCircleIn= AnimationUtils.loadAnimation(getActivity(), R.anim.retatein);
    }
    private void setData() {
        list=new ArrayList<>();
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",1);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",1);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",1);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",0);
        list.add(map);
        map=new HashMap<>();
        map.put("type",1);
        list.add(map);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.addlogs_fragment,container,false);
        if (list.size()==0) {
            LinearLayout liner=(LinearLayout)view.findViewById(R.id.addlogs_no_logs_liner);
            liner.setVisibility(View.VISIBLE);
            return view;
        }
        retate_iv=(RelativeLayout)view.findViewById(R.id.addlogs_retate_liner);
        addlogs_top_fushi=(TextView)view.findViewById(R.id.addlogs_top_fushi);
        addlogs_bottom_suishouji=(TextView)view.findViewById(R.id.addlogs_bottom_suishouji);
        add_logs=(CircleImageView)view.findViewById(R.id.add_logs_add);
        listview=(ListView)view.findViewById(R.id.addlogs_lv);
        adapter=new AddLogsListAdapter(list);
        listview.setAdapter(adapter);
        AnimationAdapter animAdapter = new SwingBottomInAnimationAdapter(adapter);
        animAdapter.setAbsListView(listview);
        listview.setAdapter(animAdapter);
        setListeners();
//        View view=inflater.inflate(R.layout.addlogs_fragment, container, false);
//        addlogs_lv=(ListView)view.findViewById(R.id.addlogs_lv);
//        AddLogsListAdapter adapter=new AddLogsListAdapter(list);
//        addlogs_lv.setAdapter(adapter);
        return view;
    }

    private void setListeners() {
        addlogs_top_fushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retate_iv.setVisibility(View.INVISIBLE);
                Intent intent=new Intent(getActivity(), AddLogsShiPuActivity.class);
                startActivity(intent);
            }
        });
        addlogs_bottom_suishouji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retate_iv.setVisibility(View.INVISIBLE);
                Intent intent=new Intent(getActivity(), AddLogsSuiShouActivity.class);
                startActivity(intent);
            }
        });
        add_logs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=retate_iv.getWidth();
                retateOut = new RotateAnimation(0f, 90f,x,x);
                retateIn = new RotateAnimation(90, 0,x,x);
                if (retate_iv.getVisibility()==View.INVISIBLE){
                    retateIn.setDuration(500);
                    retate_iv.startAnimation(retateIn);
                    retate_iv.setVisibility(View.VISIBLE);
                    add_logs.startAnimation(retateCircle);
                }else{
                    retateOut.setDuration(500);
                    retate_iv.startAnimation(retateOut);
                    retate_iv.setVisibility(View.INVISIBLE);
                    add_logs.startAnimation(retateCircleIn);
                }
            }
        });
        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (retate_iv.getVisibility()==View.VISIBLE){
                    retate_iv.startAnimation(retateOut);
                    retate_iv.setVisibility(View.INVISIBLE);
                    add_logs.startAnimation(retateCircle);
                }
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.get(position).put("isvisible", 1);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
