package com.zyl2015.trid.dao;

import android.content.Context;
import android.util.Log;

import com.zyl2015.trid.data.DbHelperFactory;
import com.zyl2015.trid.data.UserDbHelper;
import com.zyl2015.trid.models.UserModel;

import java.util.List;

/**
 * IBaseDao的具体实现类，为用户数据的数据库操作提供接口
 * Created by zyl on 2015/10/27.
 */
public class UserDao implements IBaseDao<UserModel> {
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
    public void insert(UserModel userModel){

    }
    @Override
    public void insertModels(List<UserModel> list){

    }
    @Override
    public UserModel rawQuery(String tableName,String columName,String columValue){
        UserModel userModel =null;
        return userModel;
    }
    @Override
    public List<UserModel> rawsQuery(String tableName,String columName,String columValue){
        List<UserModel> list=null;
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
    public UserModel getUser(String tableName,String columName,String columValue){
        UserModel userModel;
        userModel =rawQuery(tableName, columName, columValue);
        return userModel;
    }

    /**
     * 对外提供的接口，得到一组用户的数据
     * @param tableName
     * @param columName
     * @param columValue
     * @return
     */
    public List<UserModel> getContactList(String tableName,String columName,String columValue){
        List<UserModel> list;
        list=rawsQuery(tableName, columName, columValue);
        return list;
    }

}
