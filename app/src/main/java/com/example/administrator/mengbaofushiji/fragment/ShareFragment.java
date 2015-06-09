package com.example.administrator.mengbaofushiji.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyListShareAdapter;
import com.example.administrator.mengbaofushiji.view.AllShareActivity;
import com.example.administrator.mengbaofushiji.view.TalkDetailActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import github.chenupt.dragtoplayout.AttachUtil;
import github.chenupt.dragtoplayout.DragTopLayout;

public class ShareFragment extends Fragment{
    private ListView lv;
    private MyListShareAdapter adapter;
    TextView share_fried_tv;
    TextView share_my_tv;
    private List<Map<String,Object>> list;
    private Map<String,Object> map;
    private List<Map<String,Object>> chats;
    private Map<String,Object> chatMap;
    private DragTopLayout share_dragtoplayout;
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.share_fragment,container,false);
        initView(view);
        setListener();
		return view;
	}

    private void setListener() {
        lv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                }
                return false;
            }
        });
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                share_dragtoplayout.setTouchMode(AttachUtil.isAdapterViewAttach(view));
            }
        });

//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        share_fried_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AllShareActivity.class);
                intent.putExtra("position", 0);
                startActivity(intent);
            }
        });
        share_my_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AllShareActivity.class);
                intent.putExtra("position", 1);
                startActivity(intent);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),TalkDetailActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }
    private void initView(View view) {
        share_my_tv=(TextView)view.findViewById(R.id.share_my_tv);
        share_fried_tv=(TextView)view.findViewById(R.id.share_fried_tv);
        lv=(ListView)view.findViewById(R.id.share_showalldata_lv);
        adapter=new MyListShareAdapter(getActivity(),list);
        lv.setAdapter(adapter);
//        AnimationAdapter animAdapter = new SwingBottomInAnimationAdapter(adapter);
//        animAdapter.setAbsListView(lv);
//        lv.setAdapter(animAdapter);
        share_dragtoplayout=(DragTopLayout)view.findViewById(R.id.share_dragtoplayout);
        share_dragtoplayout.setOverDrag(false);
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
	}

    private void getData() {
        list=new ArrayList<Map<String, Object>>();

        chats=new ArrayList<>();
        chatMap=new HashMap<>();
        map=new HashMap<String,Object>();
        map.put("nickName","萨瓦尼卡");
        map.put("time","2015-4-13 05:50 am");
        map.put("photo",R.drawable.baby);
        map.put("content","偶爱v号店v拉回到v省道v圣地哦你不是v奇偶的v号屎尿多v怕v索赔v建瓯盘数据哦哈哈哈哈哈哈哈哈哈哈哈哈姐姐姐姐姐姐姐姐姐姐姐看看结构和广告法方法姐姐快来了官方反对党 健康快乐乐乐");
        map.put("iszan",0);
        chatMap.put("0","环境手动挡车搜到");
        chatMap.put("1","鼻手术的和i哦啊山顶");
        chatMap.put("2","isviOS的v欧赔加上产品");
        chats.add(chatMap);
        map.put("chat",chats);
        list.add(map);

        chats=new ArrayList<>();
        chatMap=new HashMap<>();
        map=new HashMap<String,Object>();
        map.put("nickName","嘿嘿你吗");
        map.put("time","2015-4-13 05:50 am");
        map.put("photo",R.drawable.baby);
        map.put("content","偶爱v号店v拉回到v省道v圣地哦你不是v奇偶的v号屎尿多v怕v索赔v建瓯盘数据哦哈哈哈哈哈哈哈哈哈哈哈哈姐姐姐姐姐姐姐姐姐姐姐看看结构和广告法方法姐姐快来了官方反对党 健康快乐乐乐");
        map.put("iszan",1);
        chatMap.put("0","环境手动挡车搜到");
        chatMap.put("1","鼻手术的和i哦啊山顶");
        chatMap.put("2","isviOS的v欧赔加上产品");
        chats.add(chatMap);
        map.put("chat",chats);
        list.add(map);

        chats=new ArrayList<>();
        chatMap=new HashMap<>();
        map=new HashMap<String,Object>();
        map.put("nickName","达赖喇嘛");
        map.put("time","2015-4-13 05:50 am");
        map.put("photo",R.drawable.baby);
        map.put("content","偶爱v号店v拉回到v省道v圣地哦你不是v奇偶的v号屎尿多v怕v索赔v建瓯盘数据哦哈哈哈哈哈哈哈哈哈哈哈哈姐姐姐姐姐姐姐姐姐姐姐看看结构和广告法方法姐姐快来了官方反对党 健康快乐乐乐");
        map.put("iszan",0);
        chatMap.put("0","环境手动挡车搜到");
        chatMap.put("1","鼻手术的和i哦啊山顶");
        chatMap.put("2","isviOS的v欧赔加上产品");
        chats.add(chatMap);
        map.put("chat",chats);
        list.add(map);

        chats=new ArrayList<>();
        chatMap=new HashMap<>();
        map=new HashMap<String,Object>();
        map.put("nickName","很爱很爱");
        map.put("time","2015-4-13 05:50 am");
        map.put("photo",R.drawable.baby);
        map.put("content","偶爱v号店v拉回到v省道v圣地哦你不是v奇偶的v号屎尿多v怕v索赔v建瓯盘数据哦哈哈哈哈哈哈哈哈哈哈哈哈姐姐姐姐姐姐姐姐姐姐姐看看结构和广告法方法姐姐快来了官方反对党 健康快乐乐乐");
        map.put("iszan",0);
        chatMap.put("0","环境手动挡车搜到");
        chatMap.put("1","鼻手术的和i哦啊山顶");
        chatMap.put("2","isviOS的v欧赔加上产品");
        chats.add(chatMap);
        map.put("chat",chats);
        list.add(map);

        chats=new ArrayList<>();
        chatMap=new HashMap<>();
        map=new HashMap<String,Object>();
        map.put("nickName","你们所感动");
        map.put("time","2015-4-13 05:50 am");
        map.put("photo",R.drawable.baby);
        map.put("content","偶爱v号店v拉回到v省道v圣地哦你不是v奇偶的v号屎尿多v怕v索赔v建瓯盘数据哦哈哈哈哈哈哈哈哈哈哈哈哈姐姐姐姐姐姐姐姐姐姐姐看看结构和广告法方法姐姐快来了官方反对党 健康快乐乐乐");
        map.put("iszan",0);
        chatMap.put("0","环境手动挡车搜到");
        chatMap.put("1","鼻手术的和i哦啊山顶");
        chatMap.put("2","isviOS的v欧赔加上产品");
        chats.add(chatMap);
        map.put("chat",chats);
        list.add(map);
    }
}


