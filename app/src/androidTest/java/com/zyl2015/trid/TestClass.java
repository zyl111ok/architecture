package com.zyl2015.trid;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.zyl2015.trid.ctrler.ChatCtrler;
import com.zyl2015.trid.ctrler.msgsender.TxtSender;
import com.zyl2015.trid.ui.activities.chat.ChatActivity;

/**
 * 基于具体Activity的单元测试
 * Created by zyl on 2015/10/26.
 */
public class TestClass extends ActivityInstrumentationTestCase<ChatActivity> {
    private Activity chatActivity;
    public TestClass(){
        super("com.zyl2015.trid.ui.activities.chat",ChatActivity.class);
    }
    @Override
    protected void setUp()throws Exception{
        super.setUp();
        chatActivity=getActivity();
        EMChat.getInstance().init(chatActivity.getApplicationContext());
        EMChatManager.getInstance().login("13577711234", "123", new EMCallBack() {
            @Override
            public void onSuccess() {}

            @Override
            public void onError(int i, String s) {}

            @Override
            public void onProgress(int i, String s) {}
        });
        ChatCtrler ctrler=new ChatCtrler(chatActivity, EMChatManager.getInstance().getConversation("13577711234"));
        ctrler.sendMessage(new TxtSender(ctrler,"你好", EMChatManager.getInstance().getConversation("13577711234"),"13577711234"));

    }
}
