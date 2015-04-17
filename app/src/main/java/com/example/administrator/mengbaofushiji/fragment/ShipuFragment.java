package com.example.administrator.mengbaofushiji.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyPagerShiPuAdapter;
import com.example.administrator.mengbaofushiji.consts.Const;
import com.example.administrator.mengbaofushiji.extras.PagerSlidingTabStrip;
public class ShipuFragment extends Fragment {
    private PagerSlidingTabStrip pst;
    private ViewPager vp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shipu_fragment, container,false);
        pst=(PagerSlidingTabStrip)view.findViewById(R.id.shipu_tabs);
        vp=(ViewPager)view.findViewById(R.id.shipu_pager);
        vp.setAdapter(new MyPagerShiPuAdapter(getChildFragmentManager(), Const.TITLES_FUSHI));
        pst.setViewPager(vp);
        pst.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }
}
