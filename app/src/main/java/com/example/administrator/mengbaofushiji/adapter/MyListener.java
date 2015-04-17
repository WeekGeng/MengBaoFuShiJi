package com.example.administrator.mengbaofushiji.adapter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.view.NotifityActivity;


public class MyListener implements OnClickListener {
	private static MyListener listen=null;
	private MyListener(){}
	public static synchronized MyListener getInstance(){
		if(listen==null){
			listen = new MyListener();
		}
		return listen;
	}
	@Override
	public void onClick(View v) {
        switch (v.getId()){
            case R.id.relative_one_img:
                Intent intent=new Intent(v.getContext(), NotifityActivity.class);
                v.getContext().startActivity(intent);
                break;
            case R.id.iv_1:
            case R.id.iv2_1:
            case R.id.iv2_2:
                final AlertDialog db=new AlertDialog.Builder(v.getContext()).create();
                db.show();
                Window window = db.getWindow();
                window.setContentView(R.layout.activity_list_dialog);
                ImageView iv = (ImageView) window.findViewById(R.id.iv);
                final Bitmap bitmap=(((BitmapDrawable)((ImageView)v).getDrawable()).getBitmap());
                iv.setImageBitmap(bitmap);
                iv.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        db.dismiss();
                    }
                });
                (window.findViewById(R.id.btn)).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveImageview(v.getContext(), bitmap);
                        db.dismiss();
                    }
                });
                break;
        }
	}
	public  void saveImageview(Context context,Bitmap bitmap){
		File sdDir = Environment.getExternalStorageDirectory();
		File path = new File(sdDir+"/�ȱ���");
		if (!path.exists()) {
			path.mkdirs();
		}
		Date date = new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSS");
		String time = format.format(date);
		File file=new File(path, time+".png");
		BufferedOutputStream bos;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(file));
			boolean a = bitmap.compress(Bitmap.CompressFormat.PNG, 80, bos);
			if(a){
				Toast.makeText(context, "�Ա��浽���", Toast.LENGTH_LONG).show();
				MediaScannerConnection.scanFile(context, new String[]{file.toString()}, null, null);//ϵͳ���ˢ��
			}else {
				Toast.makeText(context, "����ʧ�ܣ�", Toast.LENGTH_LONG).show();
			}
			bos.flush();
			bos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}