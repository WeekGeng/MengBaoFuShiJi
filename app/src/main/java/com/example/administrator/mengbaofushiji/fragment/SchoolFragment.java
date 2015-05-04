package com.example.administrator.mengbaofushiji.fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyPagerSchoolAdapter;
import com.example.administrator.mengbaofushiji.extras.SlidingTabLayout;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerSchoolNutrientFragment;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerSchoolSeasonerFragment;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerSchoolToolsFragment;

import java.util.ArrayList;
import java.util.List;

public class SchoolFragment extends Fragment {
    private ViewPager vp;
    private PagerSchoolToolsFragment toolsFragment;//工具
    private PagerSchoolSeasonerFragment seasonerFragment;//调味料
    private PagerSchoolNutrientFragment nutrientFragment;//营养素
    List<Fragment> list;
    private TextView tools_tv;
    private ImageView tools_iv;
    private TextView seasoner_tv;
    private ImageView seasoner_iv;
    private TextView nutrient_tv;
    private ImageView nutrient_iv;
    private int index;
    private TextView[] tv;
    private ImageView[] iv;
    private SlidingTabLayout school_slidingtabLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

    }
    private void initView() {
        tv=new TextView[3];
        iv=new ImageView[3];
        list=new ArrayList<Fragment>();
        toolsFragment=new PagerSchoolToolsFragment();
        seasonerFragment=new PagerSchoolSeasonerFragment();
        nutrientFragment=new PagerSchoolNutrientFragment();
        list.add(toolsFragment);
        list.add(seasonerFragment);
        list.add(nutrientFragment);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.school_fragment,container,false);
        vp=(ViewPager)view.findViewById(R.id.school_vp);
        PagerAdapter adapter=new MyPagerSchoolAdapter(getChildFragmentManager(),list);
        vp.setAdapter(adapter);
        setTvAndIv(view);
        setListeners();
        return view;
    }

    private void setTvAndIv(View view) {
        tools_tv =(TextView)view.findViewById(R.id.tools_tv);
        tools_iv =(ImageView)view.findViewById(R.id.tools_iv);
        seasoner_tv=(TextView)view.findViewById(R.id.seasoner_tv);
        seasoner_iv=(ImageView)view.findViewById(R.id.seasoner_iv);
        nutrient_tv=(TextView)view.findViewById(R.id.nutrient_tv);
        nutrient_iv=(ImageView)view.findViewById(R.id.nutrient_iv);
        tv[0]=tools_tv;
        tv[1]=seasoner_tv;
        tv[2]=nutrient_tv;
        iv[0]=tools_iv;
        iv[1]=seasoner_iv;
        iv[2]=nutrient_iv;
    }

    private void setListeners() {
        tools_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index=0;
                setBackGroundColor(index);
                vp.setCurrentItem(index);
            }
        });
        seasoner_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index=1;
                setBackGroundColor(index);
                vp.setCurrentItem(index);
            }
        });
        nutrient_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index=2;
                setBackGroundColor(index);
                vp.setCurrentItem(index);
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                index=position;
                setBackGroundColor(index);
            }
            @Override
            public void onPageSelected(int position) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setBackGroundColor(int position) {
        if (position==0){
            tools_tv.setTextColor(Color.RED);
            tools_iv.setBackgroundColor(Color.RED);

            seasoner_tv.setTextColor(Color.BLACK);
            seasoner_iv.setBackgroundColor(Color.WHITE);
        }else if (position==1){
            tools_tv.setTextColor(Color.BLACK);
            tools_iv.setBackgroundColor(Color.WHITE);

            seasoner_tv.setTextColor(Color.RED);
            seasoner_iv.setBackgroundColor(Color.RED);

            nutrient_tv.setTextColor(Color.BLACK);
            nutrient_iv.setBackgroundColor(Color.WHITE);
        }else if (position==2){
            seasoner_tv.setTextColor(Color.BLACK);
            seasoner_iv.setBackgroundColor(Color.WHITE);
            nutrient_tv.setTextColor(Color.RED);
            nutrient_iv.setBackgroundColor(Color.RED);
        }
    }
}
