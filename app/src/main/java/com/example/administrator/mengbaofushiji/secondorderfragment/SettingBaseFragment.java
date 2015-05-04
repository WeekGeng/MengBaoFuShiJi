package com.example.administrator.mengbaofushiji.secondorderfragment;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.administrator.mengbaofushiji.R;
public class SettingBaseFragment extends Fragment {
	private int position;
	public SettingBaseFragment() {
	}
	public SettingBaseFragment(int position) {
		this.position=position;
	}
	private int[] layout={R.layout.activity_setting_use_detail, R.layout.activity_settings_self_main,R.layout.activity_settings_responsible,R.layout.activity_setting_feedback};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(layout[position], container,false);
		if (position==3) {
			
		}else if (position==1) {
			System.out.println("Position="+position);
			TextView tv = (TextView)view.findViewById(R.id.activity_settings_tv);
			try {
				tv.setText("当前版本"+getVersionName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return view;
	}
	private String getVersionName() throws Exception{  
	    //获取packagemanager的实例   
	    PackageManager packageManager = getActivity().getPackageManager();  
	    //getPackageName()是你当前类的包名，0代表是获取版本信息  
	    PackageInfo packInfo = packageManager.getPackageInfo(getActivity().getPackageName(), 0);  
	    return packInfo.versionName;   
	}  
}
