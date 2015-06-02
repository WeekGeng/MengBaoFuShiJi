package com.example.administrator.mengbaofushiji.pagerfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyPagerFushiListAdapter;
import com.example.administrator.mengbaofushiji.animation.AnimationAdapter;
import com.example.administrator.mengbaofushiji.animation.SwingBottomInAnimationAdapter;
import com.example.administrator.mengbaofushiji.view.DispalyFoodDetailActivity;

/**
 * Created by Administrator on 2015/4/20.
 */
public class PagerFuShiFirstFragment extends Fragment{
    private ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.pager_fushi_one_fragment,container,false);
        lv=(ListView)v.findViewById(R.id.pager_fushi_one_lv);
        MyPagerFushiListAdapter adapter=new MyPagerFushiListAdapter();
        lv.setAdapter(adapter);
        AnimationAdapter animAdapter = new SwingBottomInAnimationAdapter(adapter);
        animAdapter.setAbsListView(lv);
        lv.setAdapter(animAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), DispalyFoodDetailActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
