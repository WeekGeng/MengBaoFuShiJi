package com.example.administrator.mengbaofushiji.homefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyPagerFushiListAdapter;
import com.example.administrator.mengbaofushiji.view.MasterRecommendActivity;

import github.chenupt.dragtoplayout.AttachUtil;

/**
 * Created by Administrator on 2015/6/2.
 */
public class HomeMasterShiPuFragment extends Fragment {
    ListView home_master_shipu_lv;
    int downY = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.homemastershipufragment, null);
        home_master_shipu_lv=(ListView)view.findViewById(R.id.home_master_shipu_lv);
        MyPagerFushiListAdapter adapter=new MyPagerFushiListAdapter();
        home_master_shipu_lv.setAdapter(adapter);
        setListeners();
        return view;
    }

    private void setListeners() {
        home_master_shipu_lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                ((MasterRecommendActivity)(getActivity())).setDrog(AttachUtil.isAdapterViewAttach(view));
            }
        });
        home_master_shipu_lv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        downY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        int upY = (int) event.getY();
                        int distance = upY - downY;
                        if (distance > 50) {
                            if (home_master_shipu_lv.getFirstVisiblePosition() == 0) {
                                ((MasterRecommendActivity) getActivity()).setDrog(true);
                            }
                        }
                        break;
                }
                return false;
            }
        });
    }
}
