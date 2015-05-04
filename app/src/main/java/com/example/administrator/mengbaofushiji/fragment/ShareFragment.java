package com.example.administrator.mengbaofushiji.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.adapter.MyListShareAdapter;
import com.example.administrator.mengbaofushiji.animation.AnimationAdapter;
import com.example.administrator.mengbaofushiji.animation.SwingBottomInAnimationAdapter;

public class ShareFragment extends Fragment{
    private ListView lv;
    private MyListShareAdapter adapter;
    LinearLayout linearLayout;
    TextView tv;
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.share_fragment,container,false);
        initView(view);
        setListener();
		return view;
	}

    private void setListener() {
        lv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                }
                return false;
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void initView(View view) {
        linearLayout= (LinearLayout) view.findViewById(R.id.share_huifu_input_liner);
        lv=(ListView)view.findViewById(R.id.share_showalldata_lv);
        adapter=new MyListShareAdapter(linearLayout,getActivity());
        linearLayout.setVisibility(View.GONE);
        tv= (TextView) view.findViewById(R.id.send);

        lv.setAdapter(adapter);
        AnimationAdapter animAdapter = new SwingBottomInAnimationAdapter(adapter);
        animAdapter.setAbsListView(lv);
        lv.setAdapter(animAdapter);
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	}
}


