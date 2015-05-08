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
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.mengbaofushiji.MainActivity;
import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.fragment.AddLogs;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.HashMap;
import java.util.Map;

public class AddLogsLayoutActivity extends ActionBarActivity {
    private EditText addlogs_layout_ed_title;
    private EditText addlogs_layout_ed_content;
    private ImageView addlogs_layout_iv_tools;
    private ImageView addlogs_layout_iv_tiaoweiliao;
    private Button btn_ok;
    private Object[] filePath=new String[2];
    private static int i=0;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_logs_layout);
        initView();
        setListeners();
        initToolBar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolBar() {
        try {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("添加笔记");
            toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {

        }
    }

    private void setListeners() {
        addlogs_layout_iv_tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSys(AddLogsLayoutActivity.this, 200);
            }
        });
        addlogs_layout_iv_tiaoweiliao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSys(AddLogsLayoutActivity.this, 201);
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> map=new HashMap<String, Object>();
                map.put("title",addlogs_layout_ed_title.getText().toString());
                map.put("content",addlogs_layout_ed_content.getText().toString());
                map.put("img",new String[]{"file:///"+filePath[0],"file:///"+filePath[1]});
                map.put("year","2015");
                map.put("month","04/15");
                AddLogs.instance.list.add(map);
                Intent intent = new Intent();
                intent.setClass(AddLogsLayoutActivity.this, MainActivity.class);
                intent.putExtra("position",4);
                setResult(0, intent);
                AddLogsLayoutActivity.this.finish();
            }
        });
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
            if (requestCode == 200) {
                if (data != null) {//相册
                    filePath[i] = getPhotoPathByLocalUri(this, data);
                    Log.e("MainActivity", ""+filePath[i]);
                    DisplayImageOptions options = new DisplayImageOptions.Builder()
                            .cacheInMemory(true)
                            .cacheOnDisk(true)
                            .bitmapConfig(Bitmap.Config.RGB_565)
                            .build();
                    ImageLoader.getInstance().displayImage("file:///" + filePath[i], addlogs_layout_iv_tools, options);
                }
            }else if (requestCode==201){
                if (data != null) {//相册
                    filePath[i] = getPhotoPathByLocalUri(this, data);
                    Log.e("MainActivity", ""+filePath[i]);
                    DisplayImageOptions options = new DisplayImageOptions.Builder()
                            .cacheInMemory(true)
                            .cacheOnDisk(true)
                            .bitmapConfig(Bitmap.Config.RGB_565)
                            .build();
                    ImageLoader.getInstance().displayImage("file:///" + filePath[i], addlogs_layout_iv_tiaoweiliao, options);
                }
            }else if (requestCode == 200 + 4) {
                if (data != null) {//文件
                    filePath[i] = getPhotoPathByLocalUri(this, data);
                }
            }
        }
        i++;
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
    private void initView() {
        addlogs_layout_ed_title=(EditText)findViewById(R.id.addlogs_layout_ed_title);
        addlogs_layout_ed_content=(EditText)findViewById(R.id.addlogs_layout_ed_content);
        addlogs_layout_iv_tools=(ImageView)findViewById(R.id.addlogs_layout_iv_tools);
        addlogs_layout_iv_tiaoweiliao=(ImageView)findViewById(R.id.addlogs_layout_iv_tiaoweiliao);
        btn_ok=(Button)findViewById(R.id.btn_ok);
    }
}
