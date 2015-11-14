package com.zyl2015.trid.ctrler.msgsender;

import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;
import com.easemob.chat.TextMessageBody;
import com.zyl2015.trid.ctrler.ChatCtrler;
import com.zyl2015.trid.enums.RefreshType;

/**
 * 向对方发送文本类消息的类
 * Created by Administrator on 2015/11/14.
 */
public class TxtSender extends BaseSender {
    private String content;
    public TxtSender(ChatCtrler ctrler, String content, EMConversation conversation,
                     String toChatUsername) {
        super(ctrler,conversation,toChatUsername);
        this.content = content;
    }

    /**
     * 发送消息类型为指定内容的文本类消息
     */
    @Override
    public void sendMessage(){
        if(content.length()>0) {
            EMMessage message = EMMessage.createSendMessage(EMMessage.Type.TXT);
            TextMessageBody txtBody = new TextMessageBody(content);
            message.addBody(txtBody);
            message.setReceipt(toChatUsername);
            conversation.addMessage(message);
            ctrler.notifyRefresh(RefreshType.ADAPTERSELECTLAST);
            ctrler.notifyRefresh(RefreshType.CLEAREDITTEXT);
            ctrler.notifyRefresh(RefreshType.SETRESULT);
        }
    }
}
