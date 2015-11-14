package com.zyl2015.trid.ctrler.loginhandler;

import com.zyl2015.trid.ctrler.LoginCtrler;
import com.zyl2015.trid.dao.UserDao;

/**
 * 模板方法模式，用于处理登录的网络请求返回数据
 * Created by zyl on 2015/11/3.
 */
public abstract class BaseHandler {
    protected UserDao dao;
    protected LoginCtrler ctrler;

    public final void handleResult(UserDao dao,LoginCtrler ctrler){
        doInit(dao, ctrler);
        doHandleResult();
    }
    protected abstract void doHandleResult();

    private  void doInit(UserDao dao,LoginCtrler ctrler){
        this.dao=dao;
        this.ctrler=ctrler;
    }


}
