package com.example.administrator.mengbaofushiji.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.TimelineAdapter;
import com.example.administrator.mengbaofushiji.animation.AnimationAdapter;
import com.example.administrator.mengbaofushiji.animation.SwingBottomInAnimationAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/17.
 */
public class AddLogs extends Fragment {
    private ListView listview;
    TimelineAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_listview,container,false);
        listview=(ListView)view.findViewById(R.id.listview);
        listview.setDividerHeight(0);
        adapter=new TimelineAdapter(getActivity(),getData());
        listview.setAdapter(adapter);
        AnimationAdapter animAdapter = new SwingBottomInAnimationAdapter(adapter);
        animAdapter.setAbsListView(listview);
        listview.setAdapter(animAdapter);
        setListeners();

        return view;
    }

    private void setListeners() {

        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case 0:
//                        MainActivity.instance.mToolbar.setVisibility(View.VISIBLE);
                        break;
                    case 1:
//                        MainActivity.instance.mToolbar.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.i("info","==============================="+firstVisibleItem);

            }
        });
    }
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("year", "2014");
        map.put("month", "03/15 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new int[]{R.drawable.h, R.drawable.d});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "2014");
        map.put("month", "12/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new int[]{R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "2013");
        map.put("month", "11/15 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new int[]{R.drawable.a, R.drawable.h, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new int[]{R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new int[]{R.drawable.g, R.drawable.e, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new int[]{R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new int[]{ R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new int[]{ R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new int[]{ R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new int[]{ R.drawable.a, R.drawable.b, R.drawable.c});
        list.add(map);
        return list;
    }

}

