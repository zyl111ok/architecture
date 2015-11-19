package com.zyl2015.trid.ctrler;

import com.zyl2015.trid.ctrler.loginhandler.BaseHandler;
import com.zyl2015.trid.ctrler.loginhandler.ChatHistoryHandler;
import com.zyl2015.trid.ctrler.loginhandler.ConfirmHandler;
import com.zyl2015.trid.ctrler.loginhandler.FriendListHandler;
import com.zyl2015.trid.ctrler.loginhandler.LoginHandler;
import com.zyl2015.trid.dao.DaoFactory;
import com.zyl2015.trid.dao.Impl.UserDaoImpl;
import com.zyl2015.trid.dao.UserDao;
import com.zyl2015.trid.ui.activities.login.LoginActivity;
import com.zyl2015.trid.value.CommonValue;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

/**
 * 登录操作控制器
 * Created by zyl on 2015/10/25.
 */
public class LoginCtrler extends BaseCtrler {

    private String TAG="LoginCtrler";
    private UserDao dao;
    private Handler handler;

    public LoginCtrler(Context context){
        this.context=context;
        setResponseListener(new LoginRspListener());
        dao=(UserDao)DaoFactory.getInstance().createDao(UserDaoImpl.class,context);
        refreshListener=((LoginActivity)context).getRefreshListener();

    }

    /**
     * 向服务器请求短信验证
     */
    public void requestConfrim(String tel,Handler handler){
        try {
            JSONObject object=new JSONObject();
            object.put("tel",tel);
            object.put("time",System.currentTimeMillis());
            object.put("type", CommonValue.TYPE_SMS_VALIDATION_REQUEST);
            netRequest(CommonValue.URL_SMS_VALIDATION_REQUEST,object.toString(),handler);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 向服务器请求登录
     */
    public void requestLogin(String tel,String code,Handler handler){
        try{
            JSONObject object=new JSONObject();
            object.put("type",CommonValue.TYPE_SMS_VALIDATION_CODE);
            object.put("tel",tel);
            object.put("code",code);
            object.put("time",System.currentTimeMillis());
            netRequest(CommonValue.URL_SMS_VALIDATION_CODE,object.toString(),handler);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 向服务器请求获取好友列表
     */
    public void requestFriendList(){

    }

    /**
     * 向服务器请求获取历史记录
     */
    public void requestHistory(){

    }

    public void setHandler(Handler handler){
        this.handler=handler;
    }

    private Handler getHandler(){
        return handler;
    }

    public class LoginRspListener implements NetResponseListener{
        @Override
        public void onSuccess(String result){
            BaseHandler baseHandler;
            Log.i(TAG, "[onSuccess]");
            //根据不同的返回类型来处理不同的业务逻辑
            try {
                JSONObject obj = new JSONObject(result);
                String type=obj.getString("type");
                //处理请求验证
                if(type.equals(CommonValue.TYPE_SMS_VALIDATION_SEND)){
                    baseHandler=new ConfirmHandler();
                    baseHandler.handleResult(dao,LoginCtrler.this);
                }
                //处理登录验证
                else if(type.equals(CommonValue.TYPE_SMS_VALIDATION_RESULT)){
                    baseHandler=new LoginHandler(result);
                    baseHandler.handleResult(dao,LoginCtrler.this);
                }
                //处理好友列表请求
                else if(type.equals(CommonValue.TYPE_FRIEND_LIST_RESULT)){
                    baseHandler=new FriendListHandler();
                    baseHandler.handleResult(dao,LoginCtrler.this);
                }
                else if(type.equals(CommonValue.TYPE_ALL_HISTORY_RESULT)){
                    baseHandler=new ChatHistoryHandler();
                    baseHandler.handleResult(dao,LoginCtrler.this);
                }

            }
            catch (JSONException e){
                e.printStackTrace();
            }

        }
        @Override
        public void onFail(){
            setToastText("网络请求超时，请稍后");
        }
    }

}
