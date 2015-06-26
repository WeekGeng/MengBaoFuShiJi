package com.example.administrator.mengbaofushiji.fragment;

import android.content.Intent;
import android.graphics.Paint;
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
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.HomeFragAdapter;
import com.example.administrator.mengbaofushiji.consts.Const;
import com.example.administrator.mengbaofushiji.extras.CircleImageView;
import com.example.administrator.mengbaofushiji.view.MasterRecommendActivity;
import com.example.administrator.mengbaofushiji.view.ToolsDetailActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{
    private ViewPager viewPager;
    private ArrayList<View> pageViews;
    private ImageView imageView;
    private ImageView[] imageViews;
    // 包裹滑动图片LinearLayout
    private ViewGroup main;
    // 包裹小圆点的LinearLayout
    private LinearLayout group;
    private int indexItem=0;
    protected boolean flag=true;
    private int[] imgs;
    private MyHandle myHandle;
    private ListView lv_item;
    private String[][] datas;
    private HomeFragAdapter homeAdapter;
    private CircleImageView home_tuijian_iv_first;
    private CircleImageView home_tuijian_iv_second;
    private CircleImageView home_tuijian_iv_third;
    private CircleImageView home_tuijian_iv_force;
    private CircleImageView home_tuijian_iv_five;
    private LinearLayout liner_middle;
    private List<View> list;
    private int[] tool_imgs;
    private String[] tool_name;
//    private LinearLayout liner_top;
    private LinearLayout liner_bottom;
    private int[] fushi_imgs;
    private String[] fushi_name;
    private LinearLayout home_liner;
    private TextView tv_old_price;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgs = new int[] { R.drawable.vpa, R.drawable.vpb, R.drawable.vpc,
                R.drawable.vpd, R.drawable.vpe };
        datas= Const.HOMEITEMS;
        myHandle=new MyHandle();
        homeAdapter=new HomeFragAdapter(datas);
        list=new ArrayList<>();
        tool_imgs=new int[]{R.drawable.t_a,R.drawable.t_b,R.drawable.t_l,R.drawable.t_m,R.drawable.t_o,R.drawable.t_t};
        tool_name=new String[]{"Munchkin彩色软头勺","Sassy弯柄学习勺","Vital Baby吸盘碗","Mother'corn baby 玉米餐具","Baby Bjorn防打翻餐盒","Boon防落食吸盘碗"};
        fushi_imgs=new int[]{R.drawable.fushituijian_a,R.drawable.fushituijian_b,R.drawable.fushituijian_c,R.drawable.fushituijian_d,R.drawable.fushituijian_e,R.drawable.fushituijian_f};
        fushi_name=new String[]{"老虎爬山","猴子摘桃","乌龟赛跑","镜中望月","海底捞月","江花水月"};
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
        home_tuijian_iv_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MasterRecommendActivity.class);
                intent.putExtra("position",0);
                startActivity(intent);
            }
        });
        home_tuijian_iv_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MasterRecommendActivity.class);
                intent.putExtra("position",1);
                startActivity(intent);
            }
        });
        home_tuijian_iv_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MasterRecommendActivity.class);
                intent.putExtra("position",2);
                startActivity(intent);
            }
        });
        home_tuijian_iv_force.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MasterRecommendActivity.class);
                intent.putExtra("position",3);
                startActivity(intent);
            }
        });
        home_tuijian_iv_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MasterRecommendActivity.class);
                intent.putExtra("position",4);
                startActivity(intent);
            }
        });
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
//        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position){
//                    case 1:
//                        Intent intentBreakfirst=new Intent(getActivity(),HomeBreakfirstActivity.class);
//                        intentBreakfirst.putExtra("position",0);
//                        startActivity(intentBreakfirst);
//                        break;
//                    case 2:
//                        Intent intentStar=new Intent(getActivity(),HomeStarTodayActivity.class);
//                        intentStar.putExtra("position",1);
//                        startActivity(intentStar);
//                        break;
//                    case 3:
//                        Intent intentSpring=new Intent(getActivity(),HomeSpringActivity.class);
//                        intentSpring.putExtra("position",2);
//                        startActivity(intentSpring);
//                        break;
//                    case 4:
//                        Intent intentFood=new Intent(getActivity(),HomeFoodMasterActivity.class);
//                        intentFood.putExtra("position",3);
//                        startActivity(intentFood);
//                        break;
//                    case 5:
//                        Intent intentshare=new Intent(getActivity(),HomeShareMasterActivity.class);
//                        intentshare.putExtra("position",4);
//                        startActivity(intentshare);
//                        break;
//                }
//            }
//        });
    }

    private void initView(LayoutInflater inflater,View view) {
        home_liner=(LinearLayout)view.findViewById(R.id.home_liner);
        View child=inflater.inflate(R.layout.home_everyday_push, home_liner, false);
        tv_old_price=(TextView)child.findViewById(R.id.tv_old_price);
        tv_old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        home_liner.addView(child);
        group=(LinearLayout)view.findViewById(R.id.home_fragment_viewGroup);
        viewPager= (ViewPager)view.findViewById(R.id.home_frag_viewpager);
        pageViews = new ArrayList<View>();
        for (int i = 0; i < imgs.length; i++) {
            LinearLayout layout = new LinearLayout(getActivity());
            ViewGroup.LayoutParams ltp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ScaleType.CENTER_CROP);
            String url= ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(imgs[i]));
            ImageLoader.getInstance().displayImage(url,imageView);
            layout.addView(imageView, ltp);
            pageViews.add(layout);
        }
        GuidePageAdapter adapter=new GuidePageAdapter();
        viewPager.setAdapter(adapter);
//        lv_item=(ListView)view.findViewById(R.id.home_frag_lv);
//        setListViewHeightBasedOnChildren(lv_item);
        View v=LayoutInflater.from(getActivity()).inflate(R.layout.home_list_header,null);
//        lv_item.addHeaderView(v);
//        lv_item.setAdapter(homeAdapter);
        ImageView iv= (ImageView) view.findViewById(R.id.home_frag_iv);
        iv.setImageResource(R.drawable.guanggao);
        addCircleView();
        home_tuijian_iv_first=(CircleImageView)view.findViewById(R.id.home_tuijian_iv_first);
        home_tuijian_iv_second=(CircleImageView)view.findViewById(R.id.home_tuijian_iv_second);
        home_tuijian_iv_third=(CircleImageView)view.findViewById(R.id.home_tuijian_iv_third);
        home_tuijian_iv_force=(CircleImageView)view.findViewById(R.id.home_tuijian_iv_force);
        home_tuijian_iv_five=(CircleImageView)view.findViewById(R.id.home_tuijian_iv_five);
        liner_middle=(LinearLayout)view.findViewById(R.id.liner_middle);
//        liner_top=(LinearLayout)view.findViewById(R.id.liner_top);
        liner_bottom=(LinearLayout)view.findViewById(R.id.liner_bottom);

        //这个地方是死数据，以后要从服务器获取
        for (int i=0;i<tool_imgs.length;i++){
            View liner=LayoutInflater.from(getActivity()).inflate(R.layout.home_liner_middle_item,liner_middle,false);
            ImageView imageView= (ImageView) liner.findViewById(R.id.home_liner_middle_iv);
            TextView   textView= (TextView) liner.findViewById(R.id.home_liner_middle_tv_name);
            String url= ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(tool_imgs[i]));
            ImageLoader.getInstance().displayImage(url, imageView);
            textView.setText(tool_name[i]);
            liner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getActivity(), ToolsDetailActivity.class);
                    startActivity(intent);
                }
            });
            liner_middle.addView(liner);
        }
//        //这个地方是死数据，以后要从服务器获取热门辅食里面的
//        for (int i=0;i<fushi_imgs.length;i++){
//            View liner=LayoutInflater.from(getActivity()).inflate(R.layout.home_liner_middle_item,liner_top,false);
//            ImageView imageView= (ImageView) liner.findViewById(R.id.home_liner_middle_iv);
//            TextView   textView= (TextView) liner.findViewById(R.id.home_liner_middle_tv_name);
//            String url= ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(fushi_imgs[i]));
//            ImageLoader.getInstance().displayImage(url, imageView);
//            textView.setText(fushi_name[i]);
//            liner.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), ToolsDetailActivity.class);
//                    startActivity(intent);
//                }
//            });
//            liner_top.addView(liner);
//        }

        //这个地方是死数据，以后要从服务器获取热门辅食里面的
        for (int i=0;i<fushi_imgs.length;i++){
            View liner=LayoutInflater.from(getActivity()).inflate(R.layout.home_liner_middle_item,liner_bottom,false);
            ImageView imageView= (ImageView) liner.findViewById(R.id.home_liner_middle_iv);
            TextView   textView= (TextView) liner.findViewById(R.id.home_liner_middle_tv_name);
            String url= ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(fushi_imgs[i]));
            ImageLoader.getInstance().displayImage(url, imageView);
            textView.setText(fushi_name[i]);
            liner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getActivity(), ToolsDetailActivity.class);
                    startActivity(intent);
                }
            });
            liner_bottom.addView(liner);
        }
    }

    private void addCircleView() {
        imageViews=new ImageView[pageViews.size()];
        for (int i = 0; i < pageViews.size(); i++) {
            LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            //设置每个小圆点距离左边的间距
            margin.setMargins(10, 0, 0, 0);
            imageView = new ImageView(getActivity());
            //设置每个小圆点的宽高
            imageView.setLayoutParams(new LinearLayout.LayoutParams(15, 15));
            imageViews[i] = imageView;
            if (i == 0) {
                // 默认选中第一张图片
                imageViews[i]
                        .setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                //其他图片都设置未选中状态
                imageViews[i]
                        .setBackgroundResource(R.drawable.page_indicator_unfocused);
            }
            group.addView(imageViews[i], margin);
        }
        viewPager.setOnPageChangeListener(new GuidePageChangeListener());
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
    // 指引页面更改事件监听器
    class GuidePageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {
            indexItem=position;
            //遍历数组让当前选中图片下的小圆点设置颜色
            for (int i = 0; i <imageViews.length; i++) {
                imageViews[position % imageViews.length]
                        .setBackgroundResource(R.drawable.page_indicator_focused);

                if (position % imageViews.length != i) {
                    imageViews[i]
                            .setBackgroundResource(R.drawable.page_indicator_unfocused);
                }
            }
        }
    }
}
