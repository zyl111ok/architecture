package com.zyl2015.trid.dao;

import android.content.Context;

import com.easemob.chat.EMChat;
import com.zyl2015.trid.models.DefaultInfoModel;
import com.zyl2015.trid.models.InfoModel;

/**
 * 用于操作用户基本信息的类，包含一些全局操作
 * Created by Administrator on 2015/11/17.
 */
public class InfoDao extends DaoAdapter<InfoModel>{
    private static final String TAG="InfoAccessHelper";
    private Context context;
    private InfoModel infoModel;
    private String hxId;
    private String password;
    private String token;
    private boolean sdkInited=false;
    private boolean network_state=true;
    private static InfoDao infodao=null;

    public InfoDao(Context context){
        this.context=context;
        init(context);
    }

    private synchronized boolean init(Context context){
        if(sdkInited){
            return true;
        }
        infoModel=new DefaultInfoModel(context);
        EMChat.getInstance().init(context);
        sdkInited =true;
        return true;
    }

    @Override
    public void insert(Object infoModel){
        //stub method
    }

    public InfoModel getInfoModel(){
        return infoModel;
    }

    public String getHxId(){
        if(hxId==null){
            hxId=infoModel.getHXId();
        }
        return  hxId;
    }

    public String getPwd(){
        if(password==null){
            password=infoModel.getPwd();
        }
        return password;
    }

    public String getToken(){
        if(token==null){
            token=infoModel.getToken();
        }
        return token;
    }

    public boolean getAlreadyLogin(){
        return infoModel.getAlreadyLogin();
    }

    public boolean getBasicInfoRequred(){
        return infoModel.getBasicInfoRequired();
    }

    public void setHxId(String hxId) {
        if(infoModel.setHXId(hxId)) {
            this.hxId = hxId;
        }
    }

    public void setPassword(String password) {
        if(infoModel.setPwd(password)) {
            this.password = password;
        }
    }

    public void setToken(String token) {
        if(infoModel.saveToken(token)) {
            this.token = token;
        }
    }

    public void setAlreadyLogin(boolean paramBoolean){
        infoModel.setAlreadyLogin(paramBoolean);
    }


}
