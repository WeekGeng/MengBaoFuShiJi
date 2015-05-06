package com.example.administrator.mengbaofushiji.homefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyPagerFushiListAdapter;
import com.example.administrator.mengbaofushiji.animation.AnimationAdapter;
import com.example.administrator.mengbaofushiji.animation.SwingBottomInAnimationAdapter;
import com.example.administrator.mengbaofushiji.consts.Const;

/**
 * Created by Administrator on 2015/5/6.
 */
public class MengBaoBreakFirstFragment extends Fragment{
    private Spinner sp_age;
    private Spinner sp_function;
    private ListView lv_item;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_home_breakfirst,container,false);
        lv_item=(ListView)view.findViewById(R.id.home_breakfirst_lv);
        MyPagerFushiListAdapter adapter=new MyPagerFushiListAdapter();
        lv_item.setAdapter(adapter);
        AnimationAdapter animAdapter = new SwingBottomInAnimationAdapter(adapter);
        animAdapter.setAbsListView(lv_item);
        lv_item.setAdapter(animAdapter);
        sp_age=(Spinner)view.findViewById(R.id.home_breakfirst_sp_agesel);
        sp_function=(Spinner)view.findViewById(R.id.home_breakfirst_sp_functionsel);
        ArrayAdapter<String> spAgeAdapter=new ArrayAdapter<String>(getActivity(),R.layout.spinner_top_select, Const.TITLES_FUSHI);
        ArrayAdapter<String> spFunAdapter=new ArrayAdapter<String>(getActivity(),R.layout.spinner_top_select, Const.FUNCTIONS);
        sp_age.setAdapter(spAgeAdapter);
        sp_function.setAdapter(spFunAdapter);
        spAgeAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spFunAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        return view;
    }
}
