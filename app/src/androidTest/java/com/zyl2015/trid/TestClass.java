package com.zyl2015.trid;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase;

import com.zyl2015.trid.dao.DaoFactory;
import com.zyl2015.trid.dao.Impl.InfoDaoImpl;
import com.zyl2015.trid.dao.Impl.UserDaoImpl;
import com.zyl2015.trid.dao.InfoDao;
import com.zyl2015.trid.dao.UserDao;
import com.zyl2015.trid.models.UserModel;
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
        InfoDao dao=(InfoDao) DaoFactory.getInstance().createDao(InfoDaoImpl.class,loginActivity);
        dao.setHxId("123");
        dao.getHxId();
        dao.setToken("dsind");
        dao.getToken();
        dao.setPwd("sdsd");
        dao.getPwd();

        UserModel user=new UserModel();
        user.setTel("12345678901");
        user.setUserName("12345678091");
        user.setAvatar(12342345);
        user.setType(1);

        UserDao userDao=(UserDao)DaoFactory.getInstance().createDao(UserDaoImpl.class,loginActivity);
        userDao.createTable();
        userDao.setUserInfo(user);
        userDao.getAvtar(user.getUserName());

    }
}
