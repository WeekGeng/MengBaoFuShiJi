package com.example.administrator.mengbaofushiji.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.administrator.mengbaofushiji.shipupagerfragment.SuperAwesomeCardFragment;

/**
 * Created by Administrator on 2015/4/8.
 */

/**
 * 食谱中的fragment adapter
 */
public class MyPagerShiPuAdapter extends FragmentStatePagerAdapter {
    private String titles[];
    public MyPagerShiPuAdapter(FragmentManager fm,String titles[]) {
        super(fm);
        this.titles=titles;
    }
    public MyPagerShiPuAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
    @Override
    public Fragment getItem(int position) {
        return SuperAwesomeCardFragment.newInstance(position);
    }
    @Override
    public int getCount() {
        return titles.length;
    }
}
