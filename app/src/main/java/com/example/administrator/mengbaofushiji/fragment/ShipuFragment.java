package com.example.administrator.mengbaofushiji.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    private List<Fragment> list;
    private PagerFuShiFirstFragment firstFragment;
    private PagerFuShiSecondFragment secondFragment;
    private PagerFuShiThirdFragment thirdFragment;
    private PagerFuShiForFragment forFragment;
    private PagerFuShiFiveFragment fiveFragment;
    private TextView tv_function;
    private int width;
    private LinearLayout right_functon;
    private ListView lv_function;
    private int moveX;

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
        tv_function=(TextView)view.findViewById(R.id.tv_function);
//        tv_function.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"哈哈哈哈",Toast.LENGTH_SHORT).show();
//            }
//        });
        initFunciton(view);
        return view;
    }

    private void initFunciton(View view) {
        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        Log.i("width",width+"");
        right_functon = (LinearLayout)view.findViewById(R.id.right_functon);
        tv_function = (TextView)view.findViewById(R.id.tv_function);
        lv_function=(ListView)view.findViewById(R.id.lv_function);
        ArrayAdapter adapter=new ArrayAdapter(getActivity(),R.layout.shipu_right_function_lv_item,R.id.shipu_right_function_lv_item_tv,Const.FUNCTION_LIST);
        lv_function.setAdapter(adapter);
        tv_function.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                moveX=(int)event.getRawX();
                int move = width - moveX;
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i("moveX",moveX+"");
                        moveViewWithFinger(width - moveX);
                        break;
                    case MotionEvent.ACTION_UP:
                        if (move >= 200) {
                            while (move <= 300) {
                                move++;
                                moveViewWithFinger(move);
                            }
                        } else {
                            while (move > 70) {
                                move--;
                                moveViewWithFinger(move);
                            }
                        }
                        break;
                }
                return true;
            }
        });
    }

    /**
     *  此方法是让功能选择菜单移动弹出
     * @param rawX Linelayout需要移动的距离
     */
    private void moveViewWithFinger(int rawX) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)right_functon
                .getLayoutParams();
        if (rawX < 70) {
            rawX = 70;
        }
        if (rawX > 300) {
            rawX = 300;
        }
        params.leftMargin = -rawX;
        right_functon.setLayoutParams(params);
    }
}
