package com.zyl2015.trid.ctrler.loginhandler;


import com.easemob.EMCallBack;
import com.easemob.chat.EMChatManager;
import com.zyl2015.trid.enums.RefreshType;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 用于处理登录的返回数据的类
 * Created by zyl on 2015/11/3.
 */
public class LoginHandler extends  BaseHandler{


    private String jsonResult;

    public LoginHandler(String jsonResult){
        this.jsonResult=jsonResult;
    }

    @Override
    public void doHandleResult(){
        try {
            JSONObject obj=new JSONObject(jsonResult);
            EMChatManager.getInstance().login(obj.getString("huanxin_id"),
                    obj.getString("huanxin_pwd"), new EMCallBack() {
                @Override
                public void onSuccess() {}

                @Override
                public void onError(int i, String s) {}

                @Override
                public void onProgress(int i, String s) {}
            });
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        ctrler.notifyRefresh(RefreshType.SKIP);
    }

    private void initializeContacts(String tel,String token){
        ctrler.requestFriendList();
    }
}
