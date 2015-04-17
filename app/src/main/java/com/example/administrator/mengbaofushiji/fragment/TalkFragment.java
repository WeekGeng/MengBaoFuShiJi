package com.example.administrator.mengbaofushiji.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyPagerTalkAdapter;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerTalkFushi;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerTalkYueZi;
import com.example.administrator.mengbaofushiji.pagerfragment.PagerTalkYunYing;
import java.util.ArrayList;
import java.util.List;
public class TalkFragment extends Fragment {
    private ViewPager pager;
    private int position;
    private MyPagerTalkAdapter adapter;
    private List<Fragment> list;
    private Fragment fushi;
    private Fragment yunying;
    private Fragment yuezi;
    private int currentPosition;
    private RadioGroup talk_frag_rg;
    private ImageView talk_frag_iv_fushi;
    private ImageView talk_frag_iv_yunying;
    private ImageView talk_frag_iv_yuezi;
    private ImageView talk_frag_iv_wenda;
    private ImageView[] iv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        list = new ArrayList<Fragment>();
        fushi=new PagerTalkFushi();
        yunying=new PagerTalkYunYing();
        yuezi=new PagerTalkYueZi();
        list.add(fushi);
        list.add(yunying);
        list.add(yuezi);
        adapter=new MyPagerTalkAdapter(getChildFragmentManager(),list);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.talk_fragment,container,false);
        initView(view);
        setListeners(view);
        return view;
    }

    private void setListeners(final View view) {
        talk_frag_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.talk_frag_btn_fushi:
                        currentPosition=0;
                        setCurrentItem(currentPosition);
                        break;
                    case R.id.talk_frag_btn_yunying:
                        currentPosition=1;
                        setCurrentItem(currentPosition);
                        break;
                    case R.id.talk_frag_btn_yuezi:
                        currentPosition=2;
                        setCurrentItem(currentPosition);
                        break;
                }
            }
        });
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPosition=position;
                setCurrentItem(currentPosition);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView(View view) {
        talk_frag_rg=(RadioGroup)view.findViewById(R.id.talk_frag_rg);
        pager=(ViewPager)view.findViewById(R.id.talk_frag_pager);
        talk_frag_iv_fushi= (ImageView) view.findViewById(R.id.talk_frag_iv_fushi);
        talk_frag_iv_yunying= (ImageView) view.findViewById(R.id.talk_frag_iv_yunying);
        talk_frag_iv_yuezi= (ImageView) view.findViewById(R.id.talk_frag_iv_yuezi);
        talk_frag_iv_wenda=(ImageView)view.findViewById(R.id.talk_frag_iv_wenda);
        iv=new ImageView[3];
        iv[0]=talk_frag_iv_fushi;
        iv[1]=talk_frag_iv_yunying;
        iv[2]=talk_frag_iv_yuezi;
        pager.setAdapter(adapter);
        pager.setCurrentItem(currentPosition);
    }

    private void setCurrentItem(int currentPosition) {
        pager.setCurrentItem(currentPosition);
        switch (currentPosition){
            case 0:
                iv[currentPosition].setVisibility(View.VISIBLE);
                iv[currentPosition+1].setVisibility(View.INVISIBLE);
                iv[currentPosition+2].setVisibility(View.INVISIBLE);
                break;
            case 1:
                iv[currentPosition].setVisibility(View.VISIBLE);
                iv[currentPosition-1].setVisibility(View.INVISIBLE);
                iv[currentPosition+1].setVisibility(View.INVISIBLE);
                break;
            case 2:
                iv[currentPosition].setVisibility(View.VISIBLE);
                iv[currentPosition-1].setVisibility(View.INVISIBLE);
                iv[currentPosition-2].setVisibility(View.INVISIBLE);
                break;
        }
    }
}
