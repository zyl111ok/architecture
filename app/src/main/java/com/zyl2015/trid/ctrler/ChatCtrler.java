package com.zyl2015.trid.ctrler;

import android.content.Context;

import com.easemob.chat.EMChatManager;
import com.zyl2015.trid.ctrler.msgsender.ISender;
import com.zyl2015.trid.ctrler.msgsender.Sender;

/**
 * 聊天界面控制器
 * Created by zyl on 2015/11/10.
 */
public class ChatCtrler extends BaseCtrler {
    private String TAG="ChatCtrler";

    public ChatCtrler(Context context){
        this.context=context;
        setResponseListener(new ChatRspListener());
    }

    /**
     * 向对方发送消息的逻辑，视消息类型而定
     */
    public void sendMessage(ISender sender){
        Sender send=new Sender(sender);
        send.sendMessage();
    }
    public class ChatRspListener implements NetResponseListener{
        @Override
        public void onSuccess(String result){

        }
        @Override
        public void onFail(){
            setToastText("与服务器连接中断，请稍后...");
        }
    }
}
