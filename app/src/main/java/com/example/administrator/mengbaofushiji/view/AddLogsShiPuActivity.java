package com.example.administrator.mengbaofushiji.view;

import android.app.Activity;
import android.app.AlertDialog;
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
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.AddLogStepAdapter;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddLogsShiPuActivity extends ActionBarActivity {
    private LinearLayout add_logs_add_shicai_liner;
    private ArrayList<View> list;
    private View v;
    private int i=0;
    private Toolbar toolbar;
    private Spinner add_logs_sp_nandu;
    private Spinner add_logs_sp_time;
    private ArrayAdapter<String> adapter;
    private AutoCompleteTextView edCaiLiao;
    private AutoCompleteTextView edLiangDu;
    private String[] books;
    ListView add_logs_add_step_lv;
    List<Map<String,Object>> lists;
    private String filePath;
    AddLogStepAdapter addLogStepAdapter;
    private ImageView add_log_step_dialog_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_logs_shi_pu);
        books=new String[] { "Kg", "g", "L", "ml" ,"个","杯","勺","碗"};
        initView();
        initToolBar();
    }

    private void initToolBar() {
        try {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("食谱笔记");
            toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {

        }
    }
    private void initView() {
        lists=new ArrayList<>();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("img", ImageDownloader.Scheme.DRAWABLE.wrap(String.valueOf(R.drawable.tools_a)));
        map.put("title","哈哈");
        lists.add(map);




        add_logs_add_shicai_liner=(LinearLayout) findViewById(R.id.add_logs_add_shicai_liner);
        list=new ArrayList<View>();
        v= LayoutInflater.from(this).inflate(R.layout.add_logs_add_shicai_item_bottom, add_logs_add_shicai_liner,false);
        list.add(0, v);
        add_logs_add_shicai_liner.addView(v);
        LinearLayout liner=(LinearLayout)v.findViewById(R.id.add_logs_add_shicai_bottom_liner);
        liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog dialog = new AlertDialog.Builder(AddLogsShiPuActivity.this).create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                Window window = dialog.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
                window.setContentView(R.layout.add_fushi_shicai_dialog);
                edCaiLiao = (AutoCompleteTextView) window.findViewById(R.id.add_shicai_dialog_ed);
                edLiangDu = (AutoCompleteTextView) window.findViewById(R.id.add_shicai_liang_dialog_ed);

                adapter=new ArrayAdapter<String>(AddLogsShiPuActivity.this, R.layout.add_logs_biji_spiner_item_top,books);
                edLiangDu.setAdapter(adapter);
                edLiangDu.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        System.out.println("1");
                        for (int i = 0; i < books.length; i++) {
                            books[i]=edLiangDu.getText().toString()+books[i];
                        }
                        adapter=null;
                        adapter=new ArrayAdapter<String>(AddLogsShiPuActivity.this,R.layout.add_logs_biji_spiner_item_top,books);
                        edLiangDu.setAdapter(adapter);
                    }
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count,
                                                  int after) {
                        books=null;
                        System.gc();
                        books=new String[] { "Kg", "g", "L", "ml" ,"个","杯","勺","碗"};
                    }
                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                window.findViewById(R.id.revise_nick_record_dialog_bt_ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String caiLiao = edCaiLiao.getText().toString();
                        String liangdu = edLiangDu.getText().toString();
                        if (caiLiao!=null) {
                            addViews(i,caiLiao,liangdu);
                            add_logs_add_shicai_liner.removeAllViews();
                            i++;
                            for (View views : list) {
                                add_logs_add_shicai_liner.addView(views);
                            }
                        }
                        dialog.cancel();

                    }
                });
                window.findViewById(R.id.revise_nick_record_dialog_bt_cancle).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
            }
        });
        String[] nanDuSpinner=getResources().getStringArray(R.array.nanduspinnername);
        String[] timeSpinner=getResources().getStringArray(R.array.timespinnername);
        add_logs_sp_nandu=(Spinner)findViewById(R.id.add_logs_sp_nandu);
        add_logs_sp_time=(Spinner)findViewById(R.id.add_logs_sp_time);
        ArrayAdapter<String> nanDuAdapter=new ArrayAdapter<String>(this,R.layout.add_logs_biji_spiner_item_top,nanDuSpinner);
        ArrayAdapter<String> timeAdapter=new ArrayAdapter<String>(this,R.layout.add_logs_biji_spiner_item_top,timeSpinner);
        nanDuAdapter.setDropDownViewResource(R.layout.add_logs_biji_spiner_item_bottom);
        timeAdapter.setDropDownViewResource(R.layout.add_logs_biji_spiner_item_bottom);
        add_logs_sp_nandu.setAdapter(nanDuAdapter);
        add_logs_sp_time.setAdapter(timeAdapter);
        add_logs_add_step_lv=(ListView)findViewById(R.id.add_logs_add_step_lv);
        setListViewHeightBasedOnChildren(add_logs_add_step_lv);
        v= LayoutInflater.from(this).inflate(R.layout.add_logs_add_shicai_item_bottom,null);
        ((TextView)v.findViewById(R.id.add_logs_add_shicai_item_tv)).setText("添加步骤");
        add_logs_add_step_lv.addFooterView(v);
        addLogStepAdapter=new AddLogStepAdapter(lists);
        add_logs_add_step_lv.setAdapter(addLogStepAdapter);
        add_logs_add_step_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AlertDialog dialog = new AlertDialog.Builder(AddLogsShiPuActivity.this).create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                final Window window = dialog.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
                window.setContentView(R.layout.add_log_step_dialog);
                add_log_step_dialog_iv=(ImageView)window.findViewById(R.id.add_log_step_dialog_iv);
                add_log_step_dialog_iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchSys(AddLogsShiPuActivity.this, 200);
                    }
                });
                window.findViewById(R.id.add_log_step_dialog_bt_ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map=new HashMap<String, Object>();
                        map.put("img","file:///"+filePath);
                        map.put("title",((EditText)window.findViewById(R.id.add_log_step_item_ed)).getText());
                        setData(map);
                        addLogStepAdapter.notifyDataSetChanged();
                        dialog.cancel();
                    }
                });
            }
        });

    }
    public void setData(Map<String,Object> map){
        lists.add(map);
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
            Toast.makeText(AddLogsShiPuActivity.this, "相册", Toast.LENGTH_SHORT).show();
            if (requestCode == 200) {
                if (data != null) {//相册
                    filePath = getPhotoPathByLocalUri(this, data);
                    Log.e("MainActivity", filePath);
                    DisplayImageOptions options = new DisplayImageOptions.Builder()
                            .cacheInMemory(true)
                            .cacheOnDisk(true)
                            .bitmapConfig(Bitmap.Config.RGB_565)
                            .build();
                    ImageLoader.getInstance().displayImage("file:///" + filePath, add_log_step_dialog_iv, options);
                }
            } else if (requestCode == 204) {
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
    public void addViews(int i,String cailiao,String liangdu) {
        View view=LayoutInflater.from(this).inflate(R.layout.add_logs_add_shicai_item_top, add_logs_add_shicai_liner,false);
        TextView tvCailiao=(TextView)view.findViewById(R.id.shicai_add);
        TextView tvLiangdu=(TextView)view.findViewById(R.id.liangdu_add);
        tvCailiao.setText(cailiao);
        tvLiangdu.setText(liangdu);


        tvCailiao.setFocusable(false);
        tvCailiao.setEnabled(false);
        tvCailiao.setTextColor(getResources().getColor(R.color.transparent_gray));
        tvLiangdu.setFocusable(false);
        tvLiangdu.setEnabled(false);
        tvLiangdu.setTextColor(getResources().getColor(R.color.transparent_gray));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        list.add(i, view);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_logs_shi_pu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }if (id==R.id.commit){
            Intent intent=new Intent(AddLogsShiPuActivity.this,AddLogsStepActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
