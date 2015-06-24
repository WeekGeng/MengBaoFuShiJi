package com.example.administrator.mengbaofushiji.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.PopupListAdapter;
import com.example.administrator.mengbaofushiji.adapter.ShopingPayAdapter;

public class ShopPayActivity extends ActionBarActivity implements PopupListAdapter.Get{
    PopupWindow popupWindow;
    private Toolbar toolbar;
    private ListView shop_detail_lv;
    private TextView shopping_pay_address_change;
    private ScrollView shop_pay_sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_pay);
        initView();
        getData();
        initToolBar();
        setListeners();
    }
    private void setListeners() {
        shopping_pay_address_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(ShopPayActivity.this).inflate(R.layout.popupwindow_dalog, null);
                ListView popoup_window_lv = (ListView) view.findViewById(R.id.popoup_window_lv);
                PopupListAdapter adapter = new PopupListAdapter(ShopPayActivity.this);
                popoup_window_lv.setAdapter(adapter);
                popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(false);
                popupWindow.showAsDropDown(shopping_pay_address_change);
//                popoup_window_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//
//                    }
//                });
            }
        });
        shop_pay_sv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        }
                return false;
            }
        });
        shop_pay_sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }
        });
    }
    private void initView() {
        shop_detail_lv=(ListView)findViewById(R.id.shop_detail_lv);
        setListViewHeightBasedOnChildren(shop_detail_lv);
        ShopingPayAdapter adapter=new ShopingPayAdapter();
        shop_detail_lv.setAdapter(adapter);
        shopping_pay_address_change=(TextView)findViewById(R.id.shopping_pay_address_change);
        shop_pay_sv=(ScrollView)findViewById(R.id.shop_pay_sv);
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
    private void getData() {

    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("订单确认");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    @Override
    public void getData(String text) {
        shopping_pay_address_change.setText(text);
        popupWindow.dismiss();
    }
}
