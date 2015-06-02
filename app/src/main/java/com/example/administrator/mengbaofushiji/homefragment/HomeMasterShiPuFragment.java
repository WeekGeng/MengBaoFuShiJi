package com.example.administrator.mengbaofushiji.homefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.HomeStarTodayListAdapter;
import com.example.administrator.mengbaofushiji.view.MasterRecommendActivity;

import github.chenupt.dragtoplayout.AttachUtil;

/**
 * Created by Administrator on 2015/6/2.
 */
public class HomeMasterShiPuFragment extends Fragment {
    ListView home_master_shipu_lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.homemastershipufragment, null);
        home_master_shipu_lv=(ListView)view.findViewById(R.id.home_master_shipu_lv);
        HomeStarTodayListAdapter adapter=new HomeStarTodayListAdapter();
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
    }
}
