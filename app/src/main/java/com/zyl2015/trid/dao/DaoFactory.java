package com.zyl2015.trid.dao;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂方法模式，创建数据库访问对象 dao
 * Created by zyl on 2015/10/27.
 */
public class DaoFactory {

    private static String TAG="DaoFactory";
    private static DaoFactory ourInstance = new DaoFactory();
    //用map来维护dao实例，达到同一类型的对象创建一次的效果,节约内存
    private Map<Key,IBaseDao> map=new HashMap<>();
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
                dao=map.get(Key.UserDao);
                if(dao==null) {
                    dao = new UserDao(context);
                    map.put(Key.UserDao,dao);
                }
            }
            else if(s.equals("InfoDao")) {
                dao = map.get(Key.InfoDao);
                if (dao == null) {
                    dao = new InfoDao(context);
                    map.put(Key.InfoDao,dao);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dao;
    }

    private enum Key{
        UserDao,InfoDao
    }
}
