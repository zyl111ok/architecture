package com.zyl2015.trid;

import android.app.Activity;
import android.os.Looper;
import android.test.ActivityInstrumentationTestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.widget.Toast;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.zyl2015.trid.ctrler.ChatCtrler;
import com.zyl2015.trid.ctrler.msgsender.TxtSender;
import com.zyl2015.trid.dao.DaoFactory;
import com.zyl2015.trid.dao.InfoDao;
import com.zyl2015.trid.ui.activities.chat.ChatActivity;
import com.zyl2015.trid.ui.activities.login.LoginActivity;

/**
 * 基于具体Activity的单元测试
 * Created by zyl on 2015/10/26.
 */
public class TestClass extends ActivityInstrumentationTestCase<LoginActivity>{
    private Activity loginActivity;
    public TestClass(){
        super("com.zyl2015.trid.ui.activities.login",LoginActivity.class);
    }

    @Override
    protected void runTest() throws Throwable {
        super.runTest();
    }

    @Override
    protected void setUp()throws Exception{
        super.setUp();
        loginActivity=getActivity();
        InfoDao dao=(InfoDao) DaoFactory.getInstance().createDao(InfoDao.class,loginActivity);
        dao.setHxId("123");
        dao.getHxId();
        dao.setToken("dsind");
        dao.getToken();
        dao.setPassword("sdsd");
        dao.getPwd();

    }
}
