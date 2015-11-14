package com.zyl2015.trid;

import android.app.Activity;
import android.content.Context;
import android.test.InstrumentationTestCase;

import com.zyl2015.trid.ctrler.BaseCtrler;
import com.zyl2015.trid.ctrler.LoginCtrler;
import com.zyl2015.trid.ctrler.loginhandler.BaseHandler;
import com.zyl2015.trid.ctrler.loginhandler.ChatHistoryHandler;
import com.zyl2015.trid.ctrler.loginhandler.ConfirmHandler;
import com.zyl2015.trid.ctrler.loginhandler.FriendListHandler;
import com.zyl2015.trid.ctrler.loginhandler.LoginHandler;
import com.zyl2015.trid.dao.DaoFactory;
import com.zyl2015.trid.dao.UserDao;
import com.zyl2015.trid.entity.User;
import com.zyl2015.trid.ui.activities.login.LoginActivity;
import com.zyl2015.trid.value.CommonValue;

/**
 * Created by zyl on 2015/10/26.
 */
public class TestClass extends InstrumentationTestCase {
    public LoginCtrler ctrler;

    public void test() throws Exception{
        Activity activity=new LoginActivity();
        LoginCtrler ctrler=new LoginCtrler(activity);
        UserDao dao= (UserDao)DaoFactory.getInstance().createDao(UserDao.class,activity);
       // dao.createTable();

    }
}
