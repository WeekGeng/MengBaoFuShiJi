package com.example.administrator.mengbaofushiji.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyPagerShiPuAdapter;
import com.example.administrator.mengbaofushiji.consts.Const;
import com.example.administrator.mengbaofushiji.extras.PagerSlidingTabStrip;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerSchoolNutrientFragment;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerSchoolSeasonerFragment;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerSchoolToolsFragment;

import java.util.ArrayList;
import java.util.List;

public class SchoolFragment extends Fragment {
    private ViewPager school_pager;
    private PagerSchoolToolsFragment toolsFragment;//工具
    private PagerSchoolSeasonerFragment seasonerFragment;//调味料
    private PagerSchoolNutrientFragment nutrientFragment;//营养素
    private List<Fragment> list;
    private PagerSlidingTabStrip pst;
//    private TextView tools_tv;
//    private ImageView tools_iv;
//    private TextView seasoner_tv;
//    private TextView nutrient_tv;
//    private int index;
//    private TextView[] tv;
//    private SlidingTabLayout school_slidingtabLayout;
//    private int offset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }
    private void initView() {
//        tv=new TextView[3];
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
        school_pager=(ViewPager)view.findViewById(R.id.school_pager);
        PagerAdapter adapter=new MyPagerShiPuAdapter(getChildFragmentManager(), Const.SCHOOL_TITLE,list);
        school_pager.setAdapter(adapter);
//        setTvAndIv(view);
        pst=(PagerSlidingTabStrip)view.findViewById(R.id.school_tabs);
        pst.setViewPager(school_pager);
        setListeners();

//        DisplayMetrics dm = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int screenW = dm.widthPixels;// 获取分辨率宽度
//        offset =screenW / 3 ;// 计算偏移量
//        LinearLayout.LayoutParams para= (LinearLayout.LayoutParams) tools_iv.getLayoutParams();
//        para.width = offset;
//        tools_iv.setLayoutParams(para);
//        Matrix matrix = new Matrix();
//        matrix.postTranslate(offset, 0);
//        tools_iv.setImageMatrix(matrix);

        return view;
    }

//    private void setTvAndIv(View view) {
//        tools_tv =(TextView)view.findViewById(R.id.tools_tv);
//        tools_iv =(ImageView)view.findViewById(R.id.tools_iv);
//        seasoner_tv=(TextView)view.findViewById(R.id.seasoner_tv);
//        nutrient_tv=(TextView)view.findViewById(R.id.nutrient_tv);
//        tv[0]=tools_tv;
//        tv[1]=seasoner_tv;
//        tv[2]=nutrient_tv;
//    }

    private void setListeners() {
//        tools_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                index=0;
//                setBackGroundColor(index);
//                vp.setCurrentItem(index);
//            }
//        });
//        seasoner_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                index=1;
//                setBackGroundColor(index);
//                vp.setCurrentItem(index);
//            }
//        });
//        nutrient_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                index=2;
//                setBackGroundColor(index);
//                vp.setCurrentItem(index);
//            }
//        });
//        school_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//            @Override
//            public void onPageSelected(int position) {
////                Animation animation = new TranslateAnimation(offset*index, offset*position, 0, 0);//显然这个比较简洁，只有一行代码。
////                index = position;
////                animation.setFillAfter(true);// True:图片停在动画结束位置
////                animation.setDuration(300);
////                tools_iv.startAnimation(animation);
////                setBackGroundColor(index);
//            }
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }

//    private void setBackGroundColor(int position) {
//        if (position == 0) {
//            tools_tv.setTextColor(Color.RED);
//            seasoner_tv.setTextColor(Color.GRAY);
//            nutrient_tv.setTextColor(Color.GRAY);
//        }else if (position==1){
//            tools_tv.setTextColor(Color.GRAY);
//            seasoner_tv.setTextColor(Color.RED);
//            nutrient_tv.setTextColor(Color.GRAY);
//        }else if (position==2){
//            seasoner_tv.setTextColor(Color.GRAY);
//            tools_tv.setTextColor(Color.GRAY);
//            nutrient_tv.setTextColor(Color.RED);
//        }
//    }
}
