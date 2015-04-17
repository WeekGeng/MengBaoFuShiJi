package com.example.administrator.mengbaofushiji.fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.HomeFragAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment{
    private ViewPager viewPager;
    private ArrayList<View> pageViews;
    private ImageView imageView;
    private ImageView[] imageViews;
    // 包裹滑动图片LinearLayout
    private ViewGroup main;
    // 包裹小圆点的LinearLayout
    private ViewGroup group;
    private int indexItem=0;
    protected boolean flag=true;
    private int[] imgs;
    private MyHandle myHandle;
    private ListView lv_item;
    private String[] datas;
    HomeFragAdapter homeAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgs = new int[] { R.drawable.vpa, R.drawable.vpb, R.drawable.vpc,
                R.drawable.vpd, R.drawable.vpe };
        datas=new String[]{"萌宝早餐","今日之星","春日小食","辅食达人","分享达人"};
        myHandle=new MyHandle();
        homeAdapter=new HomeFragAdapter(datas);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container,false);
        initView(inflater,view);
        myHandle.sendEmptyMessage(0);
        setListener();
        return view;
    }

    private void setListener() {
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        flag = false;
                        break;
                    case MotionEvent.ACTION_UP:
                        flag = true;
                        break;
                }
                return false;
            }
        });
    }

    private void initView(LayoutInflater inflater,View view) {
        viewPager= (ViewPager)view.findViewById(R.id.home_frag_viewpager);
        pageViews = new ArrayList<View>();
        for (int i = 0; i < imgs.length; i++) {
            LinearLayout layout = new LinearLayout(getActivity());
            ViewGroup.LayoutParams ltp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setImageResource(imgs[i]);
            layout.addView(imageView, ltp);
            pageViews.add(layout);
        }
        GuidePageAdapter adapter=new GuidePageAdapter();
        viewPager.setAdapter(adapter);
        lv_item=(ListView)view.findViewById(R.id.home_frag_lv);
        setListViewHeightBasedOnChildren(lv_item);
        lv_item.setAdapter(homeAdapter);
        ImageView iv= (ImageView) view.findViewById(R.id.home_frag_iv);
        iv.setImageResource(R.drawable.guanggao);
    }
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter =listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (adapter.getCount() - 1));
        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
        listView.setLayoutParams(params);
    }
    class MyHandle extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            myHandle.sendMessageDelayed(myHandle.obtainMessage(), 2000);
            if (flag) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        }
    }
    // 指引页面数据适配器
    class GuidePageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public void destroyItem(View view, int position, Object arg2) {
            ((ViewPager) view).removeView(pageViews.get(position % pageViews.size()));
        }

        @Override
        public Object instantiateItem(View container,int position) {
            if (pageViews.get(position % pageViews.size()).getParent() != null) {
                ((ViewPager) pageViews.get(position % pageViews.size())
                        .getParent()).removeView(pageViews.get(position
                        % pageViews.size()));
            }
            ((ViewPager) container).addView(
                    pageViews.get(position % pageViews.size()), 0);
            return pageViews.get(position % pageViews.size());
        }
    }
}
