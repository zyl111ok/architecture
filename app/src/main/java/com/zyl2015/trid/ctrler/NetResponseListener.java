package com.zyl2015.trid.ctrler;

import android.os.Handler;

/**
 * 网络返回状态监听器
 * Created by zyl on 2015/10/25.
 */
public interface NetResponseListener {
     void onSuccess(String result);
     void onFail();
}
