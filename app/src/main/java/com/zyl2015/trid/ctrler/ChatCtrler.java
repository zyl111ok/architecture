package com.zyl2015.trid.ctrler;

import android.content.Context;

import com.easemob.EMEventListener;
import com.easemob.EMNotifierEvent;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;
import com.zyl2015.trid.ctrler.msgsender.ISender;
import com.zyl2015.trid.ctrler.msgsender.Sender;
import com.zyl2015.trid.enums.RefreshType;
import com.zyl2015.trid.ui.activities.chat.ChatActivity;
import com.zyl2015.trid.util.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 聊天界面控制器,用于处理收发信息
 * Created by zyl on 2015/11/10.
 */
public class ChatCtrler extends BaseCtrler implements EMEventListener{
    private String TAG="ChatCtrler";
    private EMConversation conversation;

    public ChatCtrler(Context context,EMConversation conversation){
        this.context=context;
        setResponseListener(new ChatRspListener());
        refreshListener=((ChatActivity)context).getRefreshListener();
        this.conversation=conversation;
        EMChatManager.getInstance().registerEventListener(this,new EMNotifierEvent.Event[] { EMNotifierEvent.Event.EventNewMessage,EMNotifierEvent.Event.EventOfflineMessage,
                EMNotifierEvent.Event.EventDeliveryAck, EMNotifierEvent.Event.EventReadAck });
    }

    /**
     * 向对方发送消息的逻辑，视消息类型而定
     */
    public void sendMessage(ISender sender){
        Sender send=new Sender(sender);
        send.sendMessage();
    }

    /**
     * 请求与单个用户的历史消息
     */
    public void requestHistory(){

    }

    public class ChatRspListener implements NetResponseListener{
        @Override
        public void onSuccess(String result){
            try {
                JSONObject obj = new JSONObject(result);
                conversation= JsonParser.getInstance().getConversation(obj);
                ChatCtrler.this.notifyRefresh(RefreshType.ADAPTERDATACHANGE);
            }
            catch (JSONException e){
                e.printStackTrace();
            }
        }
        @Override
        public void onFail(){
            setToastText("与服务器连接中断，请稍后...");
        }
    }

    @Override
    public void onEvent(EMNotifierEvent event){
        switch (event.getEvent()){
            case EventNewMessage:{
                EMMessage message=(EMMessage)event.getData();
                String username=null;
                username=message.getFrom();
                if(username.equals(((ChatActivity)context).getToChatUsername())){
                    notifyRefresh(RefreshType.NEWMSG);
                }
                break;
            }
            case EventDeliveryAck:{
                EMMessage message=(EMMessage)event.getData();
                notifyRefresh(RefreshType.CHATUI);
                break;
            }
            case EventOfflineMessage:{
                notifyRefresh(RefreshType.CHATUI);
                break;
            }
            default:
                break;
        }
    }


}
