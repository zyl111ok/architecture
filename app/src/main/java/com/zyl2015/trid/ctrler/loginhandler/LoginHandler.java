package com.zyl2015.trid.ctrler.loginhandler;

import com.zyl2015.trid.ctrler.LoginCtrler;
import com.zyl2015.trid.dao.UserDao;
import com.zyl2015.trid.enums.RefreshType;

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
        ctrler.notifyRefresh(RefreshType.SKIP);
    }

    private void initializeContacts(String tel,String token){
        ctrler.requestFriendList();
    }
}
