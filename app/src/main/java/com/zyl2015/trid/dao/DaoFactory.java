package com.zyl2015.trid.dao;

import android.content.Context;
import android.util.Log;

/**
 * 工厂方法模式，创建数据库访问对象 dao
 * Created by zyl on 2015/10/27.
 */
public class DaoFactory {

    private static String TAG="DaoFactory";
    private static DaoFactory ourInstance = new DaoFactory();

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    private DaoFactory() {
    }

    @SuppressWarnings("unchecked")
    public IBaseDao createDao(Class c, Context context) {
        IBaseDao dao = null;
        try {
            String s=c.getSimpleName();
            if (s.equals("UserDao")) {
                Log.i(TAG,s);
                dao = new UserDao(context);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dao;
    }
}
