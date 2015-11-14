package com.zyl2015.trid.ctrler.loginhandler;


import com.zyl2015.trid.enums.RefreshType;

/**
 * 用于处理验证码请求成功的操作
 * Created by zyl on 2015/11/3.
 */
public class ConfirmHandler extends BaseHandler {

    @Override
    protected void doHandleResult(){
       ctrler.notifyRefresh(RefreshType.COUNT);
    }
}
