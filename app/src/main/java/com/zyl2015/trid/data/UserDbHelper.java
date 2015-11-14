package com.zyl2015.trid.data;

import android.content.Context;

/**
 * 用户信息数据库操作类，继承自DbHelper
 * Created by zyl on 2015/10/29.
 */
public class UserDbHelper extends DbHelper {
    private static UserDbHelper instance=null;

    private UserDbHelper(Context context){
        super(context,"UserInfo.db");
    }

    /**
     * 单例创建该实例
     * @param context
     * @return
     */
    public static synchronized UserDbHelper getInstance(Context context){
        if(instance==null){
            instance=new UserDbHelper(context);
        }
        return instance;
    }

    /***
     * 建表操作
     */
    public void createTable(){
        db.execSQL("Create table if not exists tb_uers (username TEXT PRIMARY KEY," +
                "chat_title TEXT, avtar BIGINT,type INT,tel INT);");
    }
}
