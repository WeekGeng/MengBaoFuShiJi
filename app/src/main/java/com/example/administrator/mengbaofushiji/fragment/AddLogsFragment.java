package com.example.administrator.mengbaofushiji.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.AddLogsListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/23.
 */
public class AddLogsFragment extends Fragment {
    private ListView addlogs_lv;
    private List<Map<String,Object>> list;
    Map<String,Object> map;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        View view=inflater.inflate(R.layout.addlogs_fragment, container, false);
        addlogs_lv=(ListView)view.findViewById(R.id.addlogs_lv);
        AddLogsListAdapter adapter=new AddLogsListAdapter(list);
        addlogs_lv.setAdapter(adapter);
        return view;
    }
}
