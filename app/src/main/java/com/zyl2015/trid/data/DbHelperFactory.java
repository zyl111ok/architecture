package com.zyl2015.trid.data;

import android.content.Context;

/**
 * 工厂模式，创建相应的数据库操作类
 * Created by zyl on 2015/10/29.
 */
public class DbHelperFactory {
    public static DbHelper createDbHelper(Class c,Context context){
        DbHelper helper=null;
           if(c.getSimpleName().equals("UserDbHelper")){
               helper=UserDbHelper.getInstance(context);
           }
        return helper;
    }
}
