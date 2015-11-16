package com.zyl2015.trid.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.zyl2015.trid.models.UserModel;

/**
 * 数据存取类，用于存放个人基本信息
 * Created by zyl on 2015/10/27.
 */
public class InfoUtil {

    private static InfoUtil instance=null;
    private static Context context;
    private static SharedPreferences mShare;
    private static final String PREFERENCE_NAME="userInfo";
    private static SharedPreferences.Editor editor;

    private String NOTIFICATION="notification";
    private String SOUND="sound";
    private String VIBRATE="vibrate";
    private String SPEAKER="speaker";
    private String ALREADYLOGIN="alreadylogin";
    private String BASICINFOREQUIRED="basicinforequired";
    private String HXID="hxid";
    private String HXPWD="hxpwd";


    private InfoUtil(){}
    //单例创建该实例
    public static synchronized InfoUtil getInstance(Context mcontext){
        if (instance==null){
            instance=new InfoUtil();
            context=mcontext;
            mShare=context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
            editor=mShare.edit();
        }
        return instance;
    }

    public boolean setToken(String token){
        return editor.putString("token", token).commit();
    }

    public void setSettingMsgNotification(boolean paramBoolean){
        editor.putBoolean(NOTIFICATION, paramBoolean);
        editor.commit();
    }

    public boolean getSettingMsgNotification(){
        return mShare.getBoolean(NOTIFICATION,true);
    }

    public void setSettingMsgSound(boolean paramBoolean){
        editor.putBoolean(SOUND,paramBoolean);
        editor.commit();
    }

    public boolean getSettingMsgSound(){
        return mShare.getBoolean(SOUND,true);
    }

    public void setSettingMsgVibrate(boolean paramBoolean){
        editor.putBoolean(VIBRATE,paramBoolean);
        editor.commit();
    }

    public boolean getSettingMsgVibrate(){
        return mShare.getBoolean(VIBRATE,true);
    }

    public void setSettingMsgSpeaker(boolean paramBoolean){
        editor.putBoolean(SPEAKER,paramBoolean);
        editor.commit();
    }

    public boolean getSettingMsgSpeaker(){
        return mShare.getBoolean(SPEAKER,true);
    }

    public void setAlreadyLogin(boolean paramBoolean){
        editor.putBoolean(ALREADYLOGIN,paramBoolean);
        editor.commit();
    }

    public boolean getAlreadyLogin(){
        return mShare.getBoolean(ALREADYLOGIN,true);
    }

    public void setBasicInfoRequired(boolean paramBoolean){
        editor.putBoolean(BASICINFOREQUIRED,paramBoolean);
        editor.commit();
    }

    public boolean getBasicInfoRequired(){
        return mShare.getBoolean(BASICINFOREQUIRED,true);
    }

    public boolean setHXId(String hxId){
        return editor.putString(HXID,hxId).commit();
    }

    public String getHXId(){
        return mShare.getString(HXID,"");
    }


    public String getToken(){
        String token=mShare.getString("token","");
        return token;
    }

    public boolean setHxPwd(String hxPwd){
        return editor.putString(HXPWD,hxPwd).commit();
    }

    public String getHxPwd(){
        return mShare.getString(HXPWD,"");
    }


}
