package com.example.administrator.mengbaofushiji.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.MainActivity;
import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.extras.DepthPageTransformer;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.ArrayList;
import java.util.List;

public class WelActivity extends ActionBarActivity {
    ViewPager vp;
    private int imgs[]={R.drawable.guide_one,R.drawable.guide_two,R.drawable.guide_three,R.drawable.guide_for};
    private List<ImageView> list=new ArrayList<>();
    private TextView next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);
        next=(TextView)findViewById(R.id.next);
        vp=(ViewPager)findViewById(R.id.vp);
        vp.setPageTransformer(true,new DepthPageTransformer());
        vp.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(WelActivity.this);
                String url= ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(imgs[position]));
                ImageLoader.getInstance().displayImage(url,imageView);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                container.addView(imageView);
                list.add(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                list.remove(list.get(position));
            }

            @Override
            public int getCount() {
                return imgs.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if (position==3){
                    next.setVisibility(View.VISIBLE);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(WelActivity.this, MainActivity.class);
                            startActivity(intent);
                            WelActivity.this.finish();
                        }
                    });
                }else{
                    next.setVisibility(View.GONE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
