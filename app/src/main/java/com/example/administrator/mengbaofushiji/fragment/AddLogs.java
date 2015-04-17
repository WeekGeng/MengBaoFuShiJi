package com.example.administrator.mengbaofushiji.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.TimelineAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/16.
 */
public class AddLogs extends Fragment {
    private ListView listView;
    private TimelineAdapter timelineAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_listview,container,false);
        listView = (ListView) view.findViewById(R.id.listview);
        timelineAdapter = new TimelineAdapter(getActivity(),getData());
        listView.setAdapter(timelineAdapter);
        return view;
    }
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("year", "2014");
        map.put("month", "03/15 09:29");
        map.put("title", "这是第1行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        map.put("img", new int[]{ R.drawable.h,R.drawable.d});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "2014");
        map.put("month", "12/1 09:29");
        map.put("title", "这是第2行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        map.put("img", new int[]{R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "2013");
        map.put("month", "11/15 09:29");
        map.put("title", "这是第3行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        map.put("img", new int[]{ R.drawable.a, R.drawable.h, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        map.put("img", new int[]{ R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        map.put("img", new int[]{ R.drawable.g, R.drawable.e, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        map.put("img", new int[]{ R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        map.put("img", new int[]{ R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        map.put("img", new int[]{ R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        map.put("img", new int[]{ R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "这是第4行测试数据你说的手动挡死哦死屌丝大is迪欧是滴哦iOS都是");
        map.put("img", new int[]{ R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);
        return list;
    }
}
