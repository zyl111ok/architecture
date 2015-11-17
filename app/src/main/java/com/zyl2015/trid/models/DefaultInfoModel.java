package com.zyl2015.trid.models;

import android.content.Context;

import com.zyl2015.trid.data.InfoAccessHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础信息管理实现类
 * Created by Administrator on 2015/11/16.
 */
public class DefaultInfoModel extends InfoModel {
    private Context context=null;
    //从内存读取，增加效率
    private Map<Key,Object> valueCache=new HashMap<>();

    public DefaultInfoModel(Context context) {
        this.context = context;
    }

    @Override
    public void setSettingMsgNotification(boolean paramBoolean) {
        InfoAccessHelper.getInstance(context).setSettingMsgNotification(paramBoolean);
        valueCache.put(Key.VibrateAndPlayToneOn,paramBoolean);
    }

    @Override
    public boolean getSettingMsgNotification() {
        Object val = valueCache.get(Key.VibrateAndPlayToneOn);

        if(val == null){
            val = InfoAccessHelper.getInstance(context).getSettingMsgNotification();
            valueCache.put(Key.VibrateAndPlayToneOn, val);
        }

        return (Boolean) (val != null?val:true);
    }

    @Override
    public void setSettingMsgSound(boolean paramBoolean) {
        InfoAccessHelper.getInstance(context).setSettingMsgSound(paramBoolean);
        valueCache.put(Key.PlayToneOn, paramBoolean);
    }

    @Override
    public boolean getSettingMsgSound() {
        Object val = valueCache.get(Key.PlayToneOn);

        if(val == null){
            val = InfoAccessHelper.getInstance(context).getSettingMsgSound();
            valueCache.put(Key.PlayToneOn, val);
        }

        return (Boolean) (val != null?val:true);
    }

    @Override
    public void setSettingMsgVibrate(boolean paramBoolean) {
        InfoAccessHelper.getInstance(context).setSettingMsgVibrate(paramBoolean);
        valueCache.put(Key.VibrateOn, paramBoolean);
    }

    @Override
    public boolean getSettingMsgVibrate() {
        Object val = valueCache.get(Key.VibrateOn);

        if(val == null){
            val = InfoAccessHelper.getInstance(context).getSettingMsgVibrate();
            valueCache.put(Key.VibrateOn, val);
        }

        return (Boolean) (val != null?val:true);
    }

    @Override
    public void setSettingMsgSpeaker(boolean paramBoolean) {
        InfoAccessHelper.getInstance(context).setSettingMsgSpeaker(paramBoolean);
        valueCache.put(Key.SpakerOn, paramBoolean);
    }

    @Override
    public boolean getSettingMsgSpeaker() {
        Object val = valueCache.get(Key.SpakerOn);

        if(val == null){
            val = InfoAccessHelper.getInstance(context).getSettingMsgSpeaker();
            valueCache.put(Key.SpakerOn, val);
        }

        return (Boolean) (val != null?val:true);
    }

    @Override
    public boolean setHXId(String hxId) {
       return InfoAccessHelper.getInstance(context).setHXId(hxId);
    }

    @Override
    public String getHXId() {
        return InfoAccessHelper.getInstance(context).getHXId();
    }

    @Override
    public boolean setPwd(String hxPwd) {
       return InfoAccessHelper.getInstance(context).setHxPwd(hxPwd);
    }

    @Override
    public String getPwd() {
        return InfoAccessHelper.getInstance(context).getHxPwd();
    }

    @Override
    public boolean saveToken(String token) {
        return InfoAccessHelper.getInstance(context).setToken(token);
    }

    @Override
    public String getToken() {
        return InfoAccessHelper.getInstance(context).getToken();
    }

    @Override
    public void setBasicInfoRequired(boolean paramBoolean) {
        InfoAccessHelper.getInstance(context).setBasicInfoRequired(paramBoolean);
    }

    @Override
    public boolean getBasicInfoRequired() {
        return InfoAccessHelper.getInstance(context).getBasicInfoRequired();
    }

    @Override
    public void setAlreadyLogin(boolean paramBoolean) {
         InfoAccessHelper.getInstance(context).setAlreadyLogin(paramBoolean);
    }

    @Override
    public boolean getAlreadyLogin() {
        return InfoAccessHelper.getInstance(context).getAlreadyLogin();
    }

    @Override
    public String getAppProcessName() {
        return null;
    }

    private enum Key{
        VibrateAndPlayToneOn,
        VibrateOn,
        PlayToneOn,
        SpakerOn
    }
}
