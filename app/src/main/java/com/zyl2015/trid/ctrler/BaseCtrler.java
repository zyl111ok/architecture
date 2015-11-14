package com.zyl2015.trid.ctrler;

import android.content.Context;
import android.os.Handler;

import com.zyl2015.trid.enums.RefreshType;
import com.zyl2015.trid.ui.activities.IRefreshListener;
import com.zyl2015.trid.util.HttpUtil;
import com.zyl2015.trid.value.CommonValue;

import java.util.ArrayList;
import java.util.List;

/**
 * 父类控制器，观察者模式，封装网络请求、数据交换的一些抽象操作
 * Created by zyl on 2015/10/25.
 */
public abstract class BaseCtrler {
    private List<NetResponseListener> listenerList=new ArrayList();
    //网络响应监听器，用于监听网络请求的结果，子类实现具体的监听
    protected NetResponseListener listener;
    //UI接口，接收控制器消息，通知UI更新视图
    protected IRefreshListener refreshListener;
    protected String  toastText=null;
    protected Context context;

    /**
     * 注册一个监听器
     * @param listener
     */
    public void attach(NetResponseListener listener){
        listenerList.add(listener);
    }

    /**
     * 将该监听器从列表中移出
     * @param listener
     */
    public void detach(NetResponseListener listener){
        listenerList.remove(listener);
    }

    /**
     * 绑定监听器
     * @param listener
     */
    protected void setResponseListener(NetResponseListener listener){
        this.listener=listener;
        attach(listener);
    }

    /**
     * 将监听器解除绑定
     * @param listener
     */
    protected void delResponseListener(NetResponseListener listener){
        detach(listener);
    }

    /**
     * 通知监听器，处理网络请求成功的操作，在handle处调用
     * @param state
     */
    public void notifyResponseState(int state,String result){
        if(listener!=null){
            if(state== CommonValue.STATE_SUCCESS){
                listener.onSuccess(result);
            }
            else if(state==CommonValue.STATE_ERROR){
                listener.onFail();
            }
        }
    }

    /**
     * 通知所有的监听器执行上述的操作
     * @param state
     */
    public void notifyAllResonseState(int state,String result){
        for(NetResponseListener listener:listenerList){
            if(listener!=null){
                if(state== CommonValue.STATE_SUCCESS){
                    listener.onSuccess(result);
                }
                else if(state==CommonValue.STATE_ERROR){
                    listener.onFail();
                }
            }
        }
    }

    /**
     * 通知UI更新视图
     * @param type
     */
    public void notifyRefresh(RefreshType type){
        refreshListener.onRefresh(type);
    }


    /**
     * 设置结果字符串，作为ui层toast的内容
     * @param text
     */
    protected void setToastText(String text){
        toastText=text;
    }

    /**
     * 得到结果字符串,该方法向ui层开放
     * @return
     */
    public String getToastText(){
        return toastText;
    }

    /**
     * 网络请求的操作
     * @param url 请求地址
     * @param json 请求表单
     * @param handler 如有需要，设置handler
     */
    protected void netRequest(String url,String json,Handler handler){
        if(handler!=null)
            HttpUtil.setHandler(handler);
        HttpUtil.postRequest(url, json);
    }

}
