package com.zyl2015.trid.ctrler.msgsender;

import com.easemob.chat.EMConversation;
import com.zyl2015.trid.ctrler.ChatCtrler;

/**
 *向对方发送语音消息的类
 * Created by Administrator on 2015/11/14.
 */
public class VoiceSender extends BaseSender{

    private String filePath;
    private String fileName;
    private String length;
    private String isResend;

    public VoiceSender(ChatCtrler ctrler, EMConversation conversation, String toChatUsername
            , String filePath,String fileName,String length,String isResend) {
        super(ctrler, conversation, toChatUsername);
        this.filePath = filePath;
        this.fileName=fileName;
        this.length=length;
        this.isResend=isResend;
    }

    /**
     * 发送语音类消息
     */
    @Override
    public void sendMessage() {

    }
}
