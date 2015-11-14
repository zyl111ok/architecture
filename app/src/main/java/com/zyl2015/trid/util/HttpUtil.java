package com.zyl2015.trid.util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.zyl2015.trid.value.CommonValue;

/**
 * Created by zyl on 2015/10/25.
 */
public class HttpUtil {
    public static Handler currentHandler;
    public static void postRequest(final String url, final String json) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String responseStr=getReponseString(url,json);
                if(currentHandler!=null)
                    sendHandlerMsg(responseStr, currentHandler);
            }
        }).start();
    }
    /**
     * 获取服务器返回字符串，针对不同的异常问题，返回不同的错误信息
     * @param url
     * @param json
     * @return
     */
    private static String getReponseString(final String url,final String json){
        HttpClient mHttpClient=MyHttpClient.getInstance();
        HttpPost post=BuildPost(url,json);
        if(mHttpClient!=null){
            if(post!=null){
                String result=getSeverResponse(mHttpClient,post);
                if(result!=null){
                    return result;
                }
                else
                    return "connect_timeout";
            }
            else
                return "PostError";
        }
        else
            return "InterNetError";
    }

    /**
     * 得到服务器返回字符串
     * @param mHttpClient
     * @param post
     * @return
     */
    private static String getSeverResponse(HttpClient mHttpClient, HttpPost post) {
        HttpResponse response;
        String result = null;
        try {
            response = mHttpClient.execute(post);
            int code = response.getStatusLine().getStatusCode();
            if (code == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity());
                Log.i("HttpUtil","result: "+result);
            } else {
                Log.i("HttpUtil",EntityUtils.toString(response.getEntity()));
            }
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return result;
    }
    /**
     * 设置post表单参数
     * @param url
     * @param json
     * @return
     */
    private static HttpPost BuildPost(String url,String json) {
        HttpPost httppost = new HttpPost(url);
        httppost.addHeader("Content-Type", "application/json");
        Log.i("HttpUtil", "will post this data:" + json);
        try {
            httppost.setEntity(new StringEntity(json,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return httppost;
    }
    /**
     * 用于判断是否请求失败
     * @param str
     * @return
     */
    private static boolean dealResponseState(String str){
        if(str!=null){
            if(str.equals("connect_timeout"))
                return false;
            else if(str.equals("PostError"))
                return false;
            else if(str.equals("InterNetError"))
                return false;
            else
                return true;
        }
        else
            return false;
    }

    // 向activity发服务器返回消息
    public static void sendHandlerMsg(String result, Handler h) {
        Message msg = h.obtainMessage();
        if(dealResponseState(result)) {
            msg.what = CommonValue.STATE_SUCCESS;
            msg.obj=result;
        }
        else
            msg.what=CommonValue.STATE_ERROR;
        h.sendMessage(msg);
    }

    public static void setHandler(Handler handler) {
        currentHandler = handler;
    }

}
