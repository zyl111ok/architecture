package com.zyl2015.trid.models;

/**
 * 管理用户数据的类，抽象类
 * Created by Administrator on 2015/11/16.
 */
public abstract class InfoModel {
    public abstract void setSettingMsgNotification(boolean paramBoolean);

    // 震动和声音总开关，来消息时，是否允许此开关打开
    public abstract boolean getSettingMsgNotification();

    public abstract void setSettingMsgSound(boolean paramBoolean);

    // 是否打开声音
    public abstract boolean getSettingMsgSound();

    public abstract void setSettingMsgVibrate(boolean paramBoolean);

    // 是否打开震动
    public abstract boolean getSettingMsgVibrate();

    public abstract void setSettingMsgSpeaker(boolean paramBoolean);

    // 是否打开扬声器
    public abstract boolean getSettingMsgSpeaker();

    public abstract boolean setHXId(String hxId);
    public abstract String getHXId();

    public abstract boolean setPwd(String hxPwd);
    public abstract String getPwd();

    // 保存token
    public abstract boolean saveToken(String token);
    // 获取token
    public abstract String getToken();
    //是否需要基础信息
    public abstract void setBasicInfoRequired(boolean paramBoolean);

    public abstract boolean getBasicInfoRequired();

    // 保存登陆信息
    public abstract void setAlreadyLogin(boolean paramBoolean);
    // 获取登陆信息
    public abstract boolean getAlreadyLogin();

    public abstract String getAppProcessName();


}
