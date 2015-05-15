package com.example.administrator.mengbaofushiji.view;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;

import java.util.ArrayList;

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
