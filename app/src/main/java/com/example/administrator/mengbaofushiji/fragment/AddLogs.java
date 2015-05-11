package com.example.administrator.mengbaofushiji.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.AddLogsAdapter;
import com.example.administrator.mengbaofushiji.animation.AnimationAdapter;
import com.example.administrator.mengbaofushiji.animation.SwingBottomInAnimationAdapter;
import com.example.administrator.mengbaofushiji.view.AddLogsShiPuActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/17.
 */
public class AddLogs extends Fragment {
    private ListView listview;
    private Animation retateOut;
    AddLogsAdapter adapter;
    ImageView add_logs;
    public static List<Map<String, Object>> list;
    public static AddLogs instance;
    private int visiblePosition=-1;
    private TextView fushibiji;
    private TextView suishoubiji;
    private int state=0;
    private LinearLayout biji_liner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance=this;
        retateOut= AnimationUtils.loadAnimation(getActivity(), R.anim.retateout);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_listview,container,false);
        fushibiji=(TextView)view.findViewById(R.id.fushibiji);
        suishoubiji=(TextView)view.findViewById(R.id.suishoubiji);
        biji_liner=(LinearLayout)view.findViewById(R.id.biji_liner);
        add_logs=(ImageView)view.findViewById(R.id.add_logs);
        listview=(ListView)view.findViewById(R.id.listview);
        listview.setDividerHeight(0);
//        adapter=new TimelineAdapter(getActivity(),getData());
        adapter=new AddLogsAdapter(getAllData());
        listview.setAdapter(adapter);
        AnimationAdapter animAdapter = new SwingBottomInAnimationAdapter(adapter);
        animAdapter.setAbsListView(listview);
        listview.setAdapter(animAdapter);
        setListeners();

        return view;
    }

    private void setListeners() {
        fushibiji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AddLogsShiPuActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        suishoubiji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        add_logs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animationIn=new AlphaAnimation(0f,1.0f);
                animationIn.setDuration(1000);

                Animation animationOut=new AlphaAnimation(1.0f,0f);
                animationOut.setDuration(1000);

                Animation retateIn= AnimationUtils.loadAnimation(getActivity(), R.anim.retatein);
                if (state==0){
                    biji_liner.setVisibility(View.VISIBLE);
                    biji_liner.startAnimation(animationIn);
                    add_logs.startAnimation(retateIn);
                    state=1;
                }else if(state==1){
                    biji_liner.startAnimation(animationOut);
                    biji_liner.setVisibility(View.GONE);
                    add_logs.startAnimation(retateOut);
                    state=0;
                }
//                Intent intent=new Intent(getActivity(), AddLogsShiPuActivity.class);
//                startActivityForResult(intent, 0);
            }
        });
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                list.get(position).put("isvisible", 0);
//                adapter.notifyDataSetChanged();
//            }
//        });
        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (visiblePosition!=-1){
                    list.get(visiblePosition).put("isvisible", 0);
                    adapter.notifyDataSetChanged();
                    visiblePosition=-1;
                }
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.get(position).put("isvisible", 1);
                adapter.notifyDataSetChanged();
                visiblePosition=position;
                return false;
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0&&resultCode==0){
            adapter.notifyDataSetChanged();
        }
    }

    private List<Map<String, Object>> getAllData() {
        list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("year", "2014");
        map.put("month", "03/15 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "三、本吧规从发布起生效，适用于所有发布之后的主题和回帖。原来的一些公告和说明如果有冲突的地方以本版为准。");
        map.put("img", new Object[]{R.drawable.a, R.drawable.b});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "2014");
        map.put("month", "12/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "本帖接受删帖封号询问，举报、投诉、申精、反馈、有问题的时候请@几位吧务 加快处理速度。但是禁止在外单独开帖，若有发现第一次删，第二次封.");
        map.put("img", new Object[]{R.drawable.d, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "2013");
        map.put("month", "11/15 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "总有人被删帖，总有人被封，但还是总有人连吧规都懒得看一下.可是如果你连吧里最基本的要求都不知道，我想你很难在本吧生存下去。为了你可以更愉快的玩耍，请仔细阅读下吧规。");
        map.put("img", new Object[]{R.drawable.e, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "吧规永远不可能十全十美，如果对于吧规有意见，请结合本吧实际情况，欢迎提出更好的建议。如果有疑问或者未写明的条款，可在本帖咨询吧务组6：本版吧规开始严厉打击各类无意义水贴。各类无意义水可能面临删帖+封禁的危险");
        map.put("img", new Object[]{R.drawable.g, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "单个ID每日发帖量限制3贴.吧务有权利删除任何水贴以保护贴吧整个版面的清洁。对低俗水贴者可以直接封号.晒XX猜XX爆XX之类话题都可以直接删甚至封禁。请吧友尽量发表一些有意义的内容");
        map.put("img", new Object[]{R.drawable.h, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "预言类帖子、一句话水贴、晒各类截图、晒运存占用、跟风贴，各类无意义转帖直播开箱一般只删除。发重复新闻、刷屏帖、发布直播会之类只删贴，保留第一个帖子严重封禁。新闻类帖子请尽量在一楼内发完.对于明显带有黑粉性质的新闻可以直接删除.");
        map.put("img", new Object[]{R.drawable.content, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我们都知道通过指定android:android:singleLine=可以让TextView自动截断超出部分并且添加省略号。但是如何判断一个TextView是否被截断了呢？");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible", 0);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("year", "1998");
        map.put("month", "01/1 09:29");
        map.put("title", "宝宝买了一个研磨碗");
        map.put("content", "我就给宝宝买了一个研磨碗，另外就是用家里的电锅。我给宝宝蒸点红萝卜或者南瓜，然后用研磨碗研碎，喂宝宝她挺喜欢的。另外就是稀饭，小米稀粥了什么的，宝宝都很喜欢吃");
        map.put("img", new Object[]{R.drawable.b, R.drawable.c});
        map.put("isvisible",0);
        list.add(map);
        return list;
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

