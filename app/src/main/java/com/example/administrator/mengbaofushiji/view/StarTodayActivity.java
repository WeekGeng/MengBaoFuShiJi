package com.example.administrator.mengbaofushiji.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.HomeStarTodayListAdapter;
import com.example.administrator.mengbaofushiji.consts.Const;
import com.example.administrator.mengbaofushiji.extras.CircleImageView;
import com.example.administrator.mengbaofushiji.extras.ParallaxScollListView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class StarTodayActivity extends ActionBarActivity {
    private ParallaxScollListView mListView;
    private ImageView mImageView;
    private Toolbar toolbar;
    private int position;
    private TextView home_star_today_tv_dianzan;
    private CircleImageView home_star_today_para_iv;
    private String filePath;
    private ImageView layout_header_image;
    private ImageView home_star_today_star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_today);
        Intent intent=getIntent();
        position=intent.getIntExtra("position",0);
        initView();
        initToolBar();
        setListeners();
    }

    private void setListeners() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(StarTodayActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initToolBar() {
        try {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(Const.HOMEITEMS[position]);
            toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {

        }
    }

    private void initView() {
        mListView = (ParallaxScollListView) findViewById(R.id.home_star_today_para_lv);
        View header = LayoutInflater.from(this).inflate(R.layout.home_star_today_lv_header, null);
        mImageView = (ImageView) header.findViewById(R.id.layout_header_image);
        mListView.setParallaxImageView(mImageView);
        mListView.addHeaderView(header);
        home_star_today_tv_dianzan=(TextView)findViewById(R.id.home_star_today_tv_dianzan);
        home_star_today_tv_dianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StarTodayActivity.this,"点赞了",Toast.LENGTH_SHORT).show();
            }
        });
        home_star_today_para_iv=(CircleImageView)findViewById(R.id.home_star_today_para_iv);
        home_star_today_para_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSys(StarTodayActivity.this,200);
            }
        });
        layout_header_image=(ImageView)findViewById(R.id.layout_header_image);
        layout_header_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        home_star_today_star=(ImageView)findViewById(R.id.home_star_today_star);
        home_star_today_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        HomeStarTodayListAdapter starTodayListAdapter=new HomeStarTodayListAdapter();
        mListView.setAdapter(starTodayListAdapter);
    }
    /**
     * PopupMenu打开本地相册.
     */
    private static boolean launchSys(Activity activity, int actResultCode) {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        try {
            activity.startActivityForResult(intent, actResultCode);

        } catch (android.content.ActivityNotFoundException e) {

            return true;
        }
        return false;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Toast.makeText(StarTodayActivity.this, "相册", Toast.LENGTH_SHORT).show();
            if (requestCode == 200) {
                if (data != null) {//相册
                    filePath = getPhotoPathByLocalUri(this, data);
                    Log.e("StarTodayActivity", filePath);
                    DisplayImageOptions options = new DisplayImageOptions.Builder()
                            .cacheInMemory(true)
                            .cacheOnDisk(true)
                            .bitmapConfig(Bitmap.Config.RGB_565)
                            .build();
                    ImageLoader.getInstance().displayImage("file:///" + filePath, home_star_today_para_iv, options);
                }
            } else if (requestCode == 200 + 4) {
                if (data != null) {//文件
                    filePath = getPhotoPathByLocalUri(this, data);
                }
            }
        }
    }
    /**
     * 获取从本地图库返回来的时候的URI解析出来的文件路径
     *
     * @return
     */
    public static String getPhotoPathByLocalUri(Context context, Intent data) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();
        return picturePath;
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_star_today, menu);
//        return true;
//    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            mListView.setViewsBounds(ParallaxScollListView.ZOOM_X2);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_star_today, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
