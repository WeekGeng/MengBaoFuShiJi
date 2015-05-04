package com.example.administrator.mengbaofushiji.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/8.
 */

/**
 * 论坛中的fragment  adapter
 */
public class MyPagerSchoolAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    public MyPagerSchoolAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    public MyPagerSchoolAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
