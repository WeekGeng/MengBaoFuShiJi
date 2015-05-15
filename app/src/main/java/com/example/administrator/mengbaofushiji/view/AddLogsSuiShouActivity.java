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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.overrideview.MyGridView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.ArrayList;
import java.util.List;

public class AddLogsSuiShouActivity extends ActionBarActivity {
    private MyGridView ad_logs_add_shuishouji_gv;
    private Toolbar toolbar;
    private List<String> list;
    private int i=0;
    private LayoutInflater inflater;
    private String filePath;
    private MyAdapter adapter;
    private String path;
    private DisplayImageOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_logs_sui_shou);
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)  //内存缓存
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        initToolBar();
        initView();
    }

    private void initView() {
        list=new ArrayList<>();
        path=ImageDownloader.Scheme.DRAWABLE.wrap("R.drawable.add_logs_add_iv");
        list.add(0,path);

        inflater=LayoutInflater.from(this);
        ad_logs_add_shuishouji_gv=(MyGridView)findViewById(R.id.ad_logs_add_shuishouji_gv);
        adapter=new MyAdapter();
        ad_logs_add_shuishouji_gv.setAdapter(adapter);

        ad_logs_add_shuishouji_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == list.size() - 1) {
                    Log.i("meizu", (String) view.getTag());


                    if (list.size() == 11) {


                        Toast.makeText(AddLogsSuiShouActivity.this,"只能添加10张图片",Toast.LENGTH_SHORT).show();
                        return;


                    }
                    launchSys(AddLogsSuiShouActivity.this, 200);


                }
            }
        });
    }
    class MyAdapter extends BaseAdapter{

        public MyAdapter(){
        }
        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

                convertView = inflater.inflate(R.layout.add_logs_add_suishouji_gv_bottom,parent, false);

            ImageView addIv= (ImageView) convertView.findViewById(R.id.add_logs_add_suishouji_bottom_iv);
            convertView.setTag(list.get(position));
            ImageLoader.getInstance().displayImage((String) convertView.getTag(),addIv,options);
            return convertView;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 200) {
                if (data != null) {//相册
                    filePath = getPhotoPathByLocalUri(this, data);
                    list.add(i,"file:///"+filePath);
                    for (int j=0;j<list.size();j++){
                        Log.i("filepath",list.get(j).toString());
                    }
                    i++;
                    this.adapter.notifyDataSetChanged();
                }
            }
        }
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
    private void initToolBar() {
        try {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("随手记");
            toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_logs_sui_shou, menu);
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
