package com.zyl2015.trid.dao.Impl;

import android.content.Context;
import android.util.Log;

import com.zyl2015.trid.dao.IBaseDao;
import com.zyl2015.trid.dao.UserDao;
import com.zyl2015.trid.data.DbHelperFactory;
import com.zyl2015.trid.data.UserDbHelper;
import com.zyl2015.trid.models.UserModel;

import java.util.List;

/**
 * UserDao的具体实现类，为用户数据的数据库操作提供接口
 * Created by zyl on 2015/10/27.
 */
public class UserDaoImpl implements UserDao {
    //通过context来使用android sdk提供的数据库访问api
    private Context context;
    private UserDbHelper userDbHelper;
    private static String TAG="UserDaoImpl";
    //定义表名
    private static String TB_NAME="tb_uers";
    //定义一些列名
    private static String COL_NAME="username";
    private static String COL_TITLE="chat_title";
    private static String COL_AVTAR="avtar";
    private static String COL_TYPE="type";
    private static String COL_TEL="tel";
    public UserDaoImpl(Context context){
        this.context=context;
        userDbHelper=(UserDbHelper)DbHelperFactory.createDbHelper(UserDbHelper.class,context);
    }

    @Override
    public void createTable(){
        userDbHelper.createTable();
        Log.i(TAG,"create table ok");
    }

    @Override
    public void setUserInfo(UserModel user) {
        userDbHelper.insert(user);
    }

    @Override
    public void deleteUser(String username){
        userDbHelper.deleteUser(username);
    }

    @Override
    public UserModel getModel() {
        return userDbHelper.getUser();
    }

    @Override
    public long getAvtar(String username) {
        return (Long)userDbHelper.getValue(COL_AVTAR,username);
    }

    @Override
    public String getTel(String username) {
        return (String)userDbHelper.getValue(COL_TEL,username);
    }

    @Override
    public String getUserChatTitle(String username) {
        return (String)userDbHelper.getValue(COL_TITLE,username);
    }

    @Override
    public void changeUserInfo(UserModel user, String valueType, String newValue) {
        userDbHelper.update(valueType,newValue,user.getUserName());
    }




}
