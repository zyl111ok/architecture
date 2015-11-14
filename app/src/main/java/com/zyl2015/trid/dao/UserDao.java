package com.zyl2015.trid.dao;

import android.content.Context;
import android.util.Log;

import com.zyl2015.trid.data.DbHelper;
import com.zyl2015.trid.data.DbHelperFactory;
import com.zyl2015.trid.data.UserDbHelper;
import com.zyl2015.trid.entity.User;

import java.util.List;

/**
 * IBaseDao的具体实现类，为用户数据的数据库操作提供接口
 * Created by zyl on 2015/10/27.
 */
public class UserDao implements IBaseDao<User> {
    //通过context来使用android sdk提供的数据库访问api
    private Context context;
    private UserDbHelper userDbHelper;
    private static String TAG="UserDao";
    public UserDao(Context context){
        this.context=context;
        userDbHelper=(UserDbHelper)DbHelperFactory.createDbHelper(UserDbHelper.class,context);
    }


    @Override
    public void createTable(){
        userDbHelper.createTable();
        Log.i(TAG,"create table ok");
    }
    @Override
    public void insert(User user){

    }
    @Override
    public void insertModels(List<User> list){

    }
    @Override
    public User rawQuery(String tableName,String columName,String columValue){
        User user=null;
        return user;
    }
    @Override
    public List<User> rawsQuery(String tableName,String columName,String columValue){
        List<User> list=null;
        return  list;
    }
    @Override
    public void delete(int id,String tableName){

    }
    /**
     * 对外提供的接口，得到一个用户的数据
     * @param tableName
     * @param columName
     * @param columValue
     * @return
     */
    public User getUser(String tableName,String columName,String columValue){
        User user;
        user=rawQuery(tableName, columName, columValue);
        return user;
    }

    /**
     * 对外提供的接口，得到一组用户的数据
     * @param tableName
     * @param columName
     * @param columValue
     * @return
     */
    public List<User> getContactList(String tableName,String columName,String columValue){
        List<User> list;
        list=rawsQuery(tableName, columName, columValue);
        return list;
    }

}
