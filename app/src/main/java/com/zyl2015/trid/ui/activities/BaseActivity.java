package com.zyl2015.trid.ui.activities;

import android.app.Activity;

import com.zyl2015.trid.ctrler.BaseCtrler;
import com.zyl2015.trid.enums.RefreshType;
import com.zyl2015.trid.util.ActivityUtil;
import com.zyl2015.trid.util.HttpUtil;
import com.zyl2015.trid.value.CommonValue;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

/**
 * 所有窗体的父类窗体
 * Created by zyl on 2015/10/25.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener {
    //父类控制器，子类继承者需要实例化它
    protected BaseCtrler ctrler;
    protected IRefreshListener refreshListener;

    private void setRefreshListener(IRefreshListener refreshListener){
        this.refreshListener=refreshListener;
    }

    public IRefreshListener getRefreshListener(){
        return refreshListener;
    }
    protected Handler handler=new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg){
            if(ctrler!=null) {
                if (msg.what == CommonValue.STATE_SUCCESS) {
                    //业务逻辑操作交予控制器执行
                    ctrler.notifyResponseState(CommonValue.STATE_SUCCESS, (String) msg.obj);

                }
                else if (msg.what == CommonValue.STATE_ERROR) {
                    ctrler.notifyResponseState(CommonValue.STATE_ERROR,null);
                    Toast.makeText(getApplicationContext(),ctrler.getToastText(),Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    public abstract  void widgetClick(View v);
    //更新UI操作
    public abstract void handlerUI(RefreshType type);

    public void onClick(View v){
        widgetClick(v);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRefreshListener(new IRefreshListener() {
            @Override
            public void onRefresh(RefreshType type) {
                //具体的方法定义交由子类完成
                handlerUI(type);
            }
        });
        ActivityUtil.addActivity(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        HttpUtil.setHandler(handler);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityUtil.removeActivity(this);
    }

}
