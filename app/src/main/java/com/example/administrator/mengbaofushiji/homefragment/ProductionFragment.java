package com.example.administrator.mengbaofushiji.homefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.HomeProductionAdapter;
import com.example.administrator.mengbaofushiji.view.DispalyImageActivity;
import com.example.administrator.mengbaofushiji.view.MasterRecommendActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import github.chenupt.dragtoplayout.AttachUtil;

/**
 * Created by Administrator on 2015/5/20.
 */
public class ProductionFragment extends Fragment{
    private GridView home_production_gv;
    private List<Map<String,Object>> list;
    Map<String,Object> map;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        map=new HashMap<>();
        map.put("title","白勺虾");
        map.put("img", R.drawable.baishaoxia);
        list.add(map);
        map=new HashMap<>();
        map.put("title", "回锅肉");
        map.put("img",R.drawable.huiguorou);
        list.add(map);
        map=new HashMap<>();
        map.put("title", "烤鸭");
        map.put("img",R.drawable.kaoya);
        list.add(map);
        map=new HashMap<>();
        map.put("title", "糖醋排骨");
        map.put("img",R.drawable.tangcupaigu);
        list.add(map);
        map=new HashMap<>();
        map.put("title", "剁椒鱼头");
        map.put("img",R.drawable.duojiaoyutou);
        list.add(map);
        map=new HashMap<>();
        map.put("title", "三黄鸡");
        map.put("img",R.drawable.sanhuangji);
        list.add(map);
        map=new HashMap<>();
        map.put("title", "水煮鱼");
        map.put("img",R.drawable.shuizhuyu);
        list.add(map);
        map=new HashMap<>();
        map.put("title","龙井虾仁");
        map.put("img",R.drawable.longjingxiaren);
        list.add(map);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_production,container,false);
        home_production_gv=(GridView)view.findViewById(R.id.home_production_gv);
        HomeProductionAdapter adapter=new HomeProductionAdapter(list);
        home_production_gv.setAdapter(adapter);
        setListener();
        return view;
    }

    private void setListener() {
        home_production_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), DispalyImageActivity.class);
                intent.putExtra("img",(int)(list.get(position).get("img")));
                intent.putExtra("title",(String)(list.get(position).get("title")));
                getActivity().startActivity(intent);
            }
        });
        home_production_gv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                ((MasterRecommendActivity)getActivity()).setDrog(AttachUtil.isAdapterViewAttach(view));
            }
        });
    }
}
