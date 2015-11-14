package com.zyl2015.trid.ctrler.msgsender;

/**
 * 发送消息的实体类
 * Created by Administrator on 2015/11/14.
 */
public class Sender {
    private ISender sender;
    public Sender(ISender sender){
        this.sender=sender;
    }
    public void sendMessage(){
        this.sender.sendMessage();
    }
}
