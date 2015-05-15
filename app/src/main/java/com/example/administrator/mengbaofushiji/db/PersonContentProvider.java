package com.example.administrator.mengbaofushiji.db;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PersonContentProvider extends ContentProvider {
	private MyOpenHelper helper;
	private static final UriMatcher matcher = new UriMatcher(
			UriMatcher.NO_MATCH);// ר������ƥ��URI����
	private static final int PERSONS = 1;
	private static final int PERSON = 2;
	private ContentResolver resolver;
	static {
		matcher.addURI("com.example.compare.PersonContentProvider", DBConsts.TABLE_HOME_PERSONAL_DATA,
				PERSONS);
		matcher.addURI("com.example.compare.PersonContentProvider", DBConsts.TABLE_HOME_PERSONAL_DATA+"/#",
				PERSON);
	}
	@Override
	public boolean onCreate() {
		helper = new MyOpenHelper(getContext(),DBConsts.DATABASE_HOME_PERSONAL_DATA, null, 1);
		resolver = getContext().getContentResolver();
		return true;
	}
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase database = helper.getWritableDatabase();
		long id = database.insert(DBConsts.TABLE_HOME_PERSONAL_DATA, null, values);
		Uri rUri = ContentUris.withAppendedId(uri, id);
		resolver.notifyChange(rUri, null);
		return rUri;
	}
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,String[] selectionArgs, String sortOrder) {
		Cursor cursor = null;
		int flag = matcher.match(uri);
		SQLiteDatabase database = helper.getReadableDatabase();
		switch (flag) {
		case PERSONS:
			cursor = database.query(DBConsts.TABLE_HOME_PERSONAL_DATA, null, null, null, null, null,
					null);
			break;
		case PERSON:
			long _id = ContentUris.parseId(uri);
			String where_value = " _id  = " + _id;
			if (selection != null && !selection.equals("")) {
				where_value += selection;
			}
			cursor = database.query(DBConsts.TABLE_HOME_PERSONAL_DATA, projection, where_value,
					selectionArgs, null, null, sortOrder);
			break;
		default:
			break;
		}
		cursor.setNotificationUri(resolver, uri);
		return cursor;
	}
	@Override
	public String getType(Uri uri) {
		int match = matcher.match(uri);
		switch (match) {
		case PERSONS:
			return "vnd.android.cursor.dir/"+DBConsts.TABLE_HOME_PERSONAL_DATA;
		case PERSON:
			return "vnd.android.cursor.item/"+DBConsts.TABLE_HOME_PERSONAL_DATA;
		default:
			return null;
		}
	}
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return 0;
	}
}
