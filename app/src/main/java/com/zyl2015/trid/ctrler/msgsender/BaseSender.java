package com.zyl2015.trid.ctrler.msgsender;

import com.easemob.chat.EMConversation;
import com.zyl2015.trid.ctrler.ChatCtrler;

/**
 * 消息发送者的父类，通过使用继承来增加代码复用性
 * Created by Administrator on 2015/11/14.
 */
public abstract class BaseSender implements ISender {
    protected ChatCtrler ctrler;
    protected EMConversation conversation;
    protected String toChatUsername;
    public BaseSender(ChatCtrler ctrler,EMConversation conversation,String toChatUsername){
        this.ctrler=ctrler;
        this.conversation=conversation;
        this.toChatUsername=toChatUsername;
    }
    @Override
    public abstract void sendMessage();
}
