package com.example.administrator.mengbaofushiji.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyPagerShiPuAdapter;
import com.example.administrator.mengbaofushiji.consts.Const;
import com.example.administrator.mengbaofushiji.extras.PagerSlidingTabStrip;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerFuShiFirstFragment;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerFuShiFiveFragment;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerFuShiForFragment;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerFuShiSecondFragment;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerFuShiThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class ShipuFragment extends Fragment {
    private PagerSlidingTabStrip pst;
    private ViewPager vp;
    private Spinner spinner;
    private List<Fragment> list;
    private PagerFuShiFirstFragment firstFragment;
    private PagerFuShiSecondFragment secondFragment;
    private PagerFuShiThirdFragment thirdFragment;
    private PagerFuShiForFragment forFragment;
    private PagerFuShiFiveFragment fiveFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<Fragment>();
        firstFragment=new PagerFuShiFirstFragment();
        secondFragment=new PagerFuShiSecondFragment();
        thirdFragment=new PagerFuShiThirdFragment();
        forFragment=new PagerFuShiForFragment();
        fiveFragment=new PagerFuShiFiveFragment();
        list.add(firstFragment);
        list.add(secondFragment);
        list.add(thirdFragment);
        list.add(forFragment);
        list.add(fiveFragment);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shipu_fragment, container,false);
        pst=(PagerSlidingTabStrip)view.findViewById(R.id.shipu_tabs);
        vp=(ViewPager)view.findViewById(R.id.shipu_pager);
        vp.setAdapter(new MyPagerShiPuAdapter(getChildFragmentManager(), Const.TITLES_FUSHI,list));
        pst.setViewPager(vp);
        String[] spinners=getActivity().getResources().getStringArray(R.array.spinnername);
        spinner=(Spinner)view.findViewById(R.id.shipu_spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),R.layout.spinner_top_select,spinners);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return view;
    }
}
