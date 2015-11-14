package com.zyl2015.trid.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.zyl2015.trid.entity.User;

/**
 * 数据存取类，用于存放个人基本信息
 * Created by zyl on 2015/10/27.
 */
public class InfoUtil {

    private static InfoUtil instance=null;
    private static Context context;
    private static SharedPreferences mShare;
    private InfoUtil(){}
    //单例创建该实例
    public static synchronized InfoUtil getInstance(Context mcontext){
        if (instance==null){
            instance=new InfoUtil();
            context=mcontext;
            mShare=context.getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        }
        return instance;
    }

    public void putData(User user){
        SharedPreferences.Editor editor=mShare.edit();
        if(user.getUserName()!=null)
            editor.putString("name",user.getUserName());
        if(user.getTel()!=null)
            editor.putString("tel",user.getTel());
        if(user.getToken()!=null)
            editor.putString("token",user.getToken());
        editor.commit();
    }

    public String getUserName(){
        String userName=mShare.getString("name", "");
        return userName;
    }

    public String getToken(){
        String token=mShare.getString("token","");
        return token;
    }

    public String getTel(){
        String tel=mShare.getString("tel","");
        return tel;
    }

}
