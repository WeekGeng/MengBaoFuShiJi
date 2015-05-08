package com.example.administrator.mengbaofushiji.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper{

	public MyOpenHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql="create table if not exists "+DBConsts.TABLE_HOME_PERSONAL_DATA+"(_id integer primary key autoincrement,"
				+DBConsts.TABLE_HOME_PERSONAL_DATA_IMAGE_URL+"varchar(20) not null,"
				+DBConsts.TABLE_HOME_PERSONAL_DATA_NICK+"varchar(20) not null)";
		db.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
}
