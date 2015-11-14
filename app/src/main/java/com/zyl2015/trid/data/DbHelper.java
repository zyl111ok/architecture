package com.zyl2015.trid.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库交互类的父类
 * Created by zyl on 2015/10/29.
 */
public class DbHelper {

    private static final int DATABASE_VERSON=1;
    private static DbHelper instance=null;
    private String dataBaseName;
    protected DatabaseHelper mHelper;
    protected SQLiteDatabase db;

    public DbHelper(Context context,String dataBaseName){
        this.dataBaseName=dataBaseName;
        mHelper=new DatabaseHelper(context);
        db=mHelper.getWritableDatabase();
    }

    /**
     * 内部类，创建一个数据库
     */
    private class DatabaseHelper extends SQLiteOpenHelper{
        DatabaseHelper(Context context){
            super(context,dataBaseName,null,DATABASE_VERSON);
        }
        @Override
        public void onCreate(SQLiteDatabase db){

        }
        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
            onCreate(db);
        }
    }


}
