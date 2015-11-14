package com.zyl2015.trid.ctrler.msgsender;

import com.easemob.chat.EMConversation;
import com.zyl2015.trid.ctrler.ChatCtrler;

/**
 * 发送图片类消息的类
 * Created by Administrator on 2015/11/14.
 */
public class ImageSender extends BaseSender {
    private String filePath;

    public ImageSender(ChatCtrler ctrler, EMConversation conversation, String toChatUsername
            , String filePath) {
        super(ctrler, conversation, toChatUsername);
        this.filePath = filePath;
    }

    /**
     * 发送图片类消息
     */
    @Override
    public void sendMessage() {

    }
}
