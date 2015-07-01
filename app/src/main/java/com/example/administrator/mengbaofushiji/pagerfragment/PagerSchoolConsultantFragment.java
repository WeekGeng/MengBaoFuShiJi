package com.example.administrator.mengbaofushiji.pagerfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.mengbaofushiji.R;

/**
 * Created by Administrator on 2015/6/30.
 */
public class PagerSchoolConsultantFragment extends Fragment {
    private RelativeLayout relative_suo;
    int i=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.school_consultant_fragment,container,false);
        relative_suo=(RelativeLayout)view.findViewById(R.id.relative_suo);
        if (i>=10){
            relative_suo.setVisibility(View.GONE);
        }else {
            relative_suo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"您好,营养顾问解锁需要等级达到10级以上！,谢谢您对萌宝辅食的关注",Toast.LENGTH_SHORT).show();
                }
            });
        }
        return view;
    }
}
