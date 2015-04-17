package com.example.administrator.mengbaofushiji.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyListShareAdapter;

public class ShareFragment extends Fragment {
    private ListView lv;
    private MyListShareAdapter adapter;
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
    }
    private void initView(View view) {
        lv=(ListView)view.findViewById(R.id.share_showalldata_lv);
        lv.setAdapter(adapter);
//        setListViewHeightBasedOnChildren(lv);
    }

//    public void setListViewHeightBasedOnChildren(ListView listView) {
//        ListAdapter adapter =listView.getAdapter();
//        if (adapter == null) {
//            return;
//        }
//        int totalHeight = 0;
//        for (int i = 0; i < adapter.getCount(); i++) {
//            View listItem = adapter.getView(i, null, listView);
//            listItem.measure(0, 0);
//            totalHeight += listItem.getMeasuredHeight();
//        }
//        ViewGroup.LayoutParams params = listView.getLayoutParams();
//        params.height = totalHeight
//                + (listView.getDividerHeight() * (adapter.getCount() - 1));
//        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
//        listView.setLayoutParams(params);
//    }
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        adapter=new MyListShareAdapter();
	}
}
