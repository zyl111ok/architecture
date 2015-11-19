package com.zyl2015.trid.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.zyl2015.trid.models.UserModel;

/**
 * 用户信息数据库操作类，继承自DbHelper
 * Created by zyl on 2015/10/29.
 */
public class UserDbHelper extends DbHelper {
    private static UserDbHelper instance=null;
    //定义表名
    private static String TB_NAME="tb_uers";
    //定义一些列名
    private static String COL_NAME="username";
    private static String COL_TITLE="chat_title";
    private static String COL_AVTAR="avtar";
    private static String COL_TYPE="type";
    private static String COL_TEL="tel";

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

    /**
     * 插入操作
     */
    public void insert(UserModel user){
        ContentValues values=new ContentValues();
        values.put(COL_NAME,user.getUserName());
        values.put(COL_TITLE,user.getChat_title());
        values.put(COL_AVTAR,user.getAvatar());
        values.put(COL_TYPE,user.getType());
        values.put(COL_TEL,user.getTel());

        db.insert(TB_NAME, null, values);
    }

    /**
     * 数据更新操作
     */
    public void update(String columName,String newValue,String username){
        db.execSQL("update" + TB_NAME + "set " + columName + " =?" + " where " + username + " =?", new Object[]
                {newValue, username});
    }

    /**
     * 得到具体的值
     */
    public Object getValue(String columName,String username){
        Cursor cur=db.rawQuery("select * from "+TB_NAME+" where "+COL_NAME+" = "+username,null);
        String result=null;
        Long avtar=null;
        int type=0;
        if(columName.equals(COL_AVTAR)){
            while(cur.moveToNext()){
                avtar=cur.getLong(cur.getColumnIndex(columName));
            }
            cur.close();
            return avtar;
        }
        else if(columName.equals(COL_TYPE)){
            while(cur.moveToNext()){
                type=cur.getInt(cur.getColumnIndex(columName));
            }
            cur.close();
            return type;
        }
        else {
            while (cur.moveToNext()) {
                result = cur.getString(cur.getColumnIndex(columName));
            }
            cur.close();
            return result;
        }
    }

    /**
     * 从数据库中读取数据
     */
    public UserModel getUser(){
        Cursor cur=db.rawQuery("select * from "+TB_NAME,null);
        UserModel user=new UserModel();
        while (cur.moveToNext()){
            user.setUserName(cur.getString(cur.getColumnIndex(COL_NAME)));
            user.setAvatar(cur.getLong(cur.getColumnIndex(COL_AVTAR)));
            user.setChat_title(cur.getString(cur.getColumnIndex(COL_TITLE)));
            user.setType(cur.getInt(cur.getColumnIndex(COL_TYPE)));
            user.setTel(cur.getString(cur.getColumnIndex(COL_TEL)));
        }
        cur.close();
        return user;
    }

    /**
     * 从数据库中删除用户
     */

    public void deleteUser(String username) {
        if (db.isOpen()) {
            db.delete(TB_NAME, COL_NAME + " =? ", new String[]{username});
        }
    }
}
