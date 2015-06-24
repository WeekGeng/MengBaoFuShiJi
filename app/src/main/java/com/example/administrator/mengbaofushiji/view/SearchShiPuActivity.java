package com.example.administrator.mengbaofushiji.view;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.extras.Tag;
import com.example.administrator.mengbaofushiji.extras.TagCloudView;

import java.util.ArrayList;
import java.util.List;

public class SearchShiPuActivity extends ActionBarActivity {
    private TagCloudView mTagCloudView;
    private LinearLayout liner;
    private TextView del;
    private EditText ed_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_shi_pu);
        initView();
    }

    private void initView() {
        liner=(LinearLayout)findViewById(R.id.liner);
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        //Step2: 创建所需的标记列表:
        //注意: 所有标签必须有独特的文本字段
        //如果没有,只有第一次出现将被添加,其余的将被忽略
        List<Tag> myTagList= createTags();
        //Step3: 创建TagCloudview MainActivity并将它设置为内容
        mTagCloudView = new TagCloudView(this, width, height, myTagList ); //通过当前上下文
        liner.addView(mTagCloudView,1);
        mTagCloudView.requestFocus();
        mTagCloudView.setFocusableInTouchMode(true);
        del=(TextView)findViewById(R.id.del);
        ed_search=(EditText)findViewById(R.id.ed_search);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_search.setText(" ");
            }
        });
    }

    private List<Tag> createTags(){
        //创建的列表标记人气值和相关的url
        List<Tag> tempList = new ArrayList<Tag>();
        tempList.add(new Tag("个人资料", 7, "个人资料"));  //1,4,7,... 假定受欢迎的值
        tempList.add(new Tag("摇一摇", 3, "摇一摇"));
        tempList.add(new Tag("辅食笔记", 4, "辅食笔记"));
        tempList.add(new Tag("好友分享", 5, "好友分享"));
        tempList.add(new Tag("我的关注", 5, "我的关注"));
        tempList.add(new Tag("我的收藏", 7, "我的收藏"));
        tempList.add(new Tag("Youtube", 3, "Youtube"));
        tempList.add(new Tag("版本更新", 5, "版本更新"));
        tempList.add(new Tag("Bing", 3, "Bing"));
        tempList.add(new Tag("Wikipedia", 8, "Wikipedia"));
        tempList.add(new Tag("Twitter", 5, "Twitter"));
        tempList.add(new Tag("Msn", 1, "Msn"));
        tempList.add(new Tag("意见反馈", 3, "意见反馈"));
        tempList.add(new Tag("Ebay", 7, "Ebay"));
        tempList.add(new Tag("LinkedIn", 5, "LinkedIn"));
        tempList.add(new Tag("Live", 7, "Live"));
        tempList.add(new Tag("Microsoft", 3, "Microsoft"));
        tempList.add(new Tag("Flicker", 1, "Flicker"));
        tempList.add(new Tag("Apple", 5, "Apple"));
        tempList.add(new Tag("Paypal", 5, "Paypal"));
        tempList.add(new Tag("Craigslist", 7, "Craigslist"));
        tempList.add(new Tag("Imdb", 2, "Imdb"));
        tempList.add(new Tag("Ask", 4, "Ask"));
        tempList.add(new Tag("Weibo", 1, "Weibo"));
        tempList.add(new Tag("Tagin!", 8, "Tagin"));
        tempList.add(new Tag("Shiftehfar", 8, "Shiftehfar"));
        tempList.add(new Tag("Soso", 5, "Soso"));
        tempList.add(new Tag("XVideos", 3, "XVideos"));
        tempList.add(new Tag("BBC", 5, "BBC"));
        return tempList;
    }

}
