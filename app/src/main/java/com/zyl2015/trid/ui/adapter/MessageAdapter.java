package com.zyl2015.trid.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.easemob.chat.EMMessage;
import com.zyl2015.trid.ui.activities.BaseActivity;

/**
 * 消息列表的适配器，对应聊天界面
 * Created by Administrator on 2015/11/15.
 */
public class MessageAdapter extends BaseAdapter{
    private EMMessage[] messages=null;
    @Override
    public int getCount(){
        return 0;
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public EMMessage getItem(int position){
        if(messages!=null && position<messages.length){
            return messages[position];
        }
        return null;
    }
    @Override
    public View getView(final int position,View convertView,ViewGroup parent){
        return convertView;
    }

    public void refresh(){}
    public void refreshSelectLast(){}
    public void refreshSeekTo(int position){}


}
