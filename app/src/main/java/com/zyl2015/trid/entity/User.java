package com.zyl2015.trid.entity;

/**
 * Created by zyl on 2015/10/25.
 */
import com.zyl2015.trid.util.UserUtil;

/**
 * 通信实体类
 */
public class User {

    private String userName;
    private String nickName;
    private String tel;
    private String token;
    private String chat_title;
    //过期时间
    private long avatar;

    public void setUserName(String userName){
        this.userName=userName;
        UserUtil.putUserByName(userName,this);
    }

    public void setNickName(String nickName){
        this.nickName=nickName;
    }

    public void setTel(String tel){
        this.tel=tel;
    }

    public void setToken(String token){
        this.token=token;
    }

    public void setChat_title(String chat_title){
        this.chat_title=chat_title;
    }

    public String getUserName(){return this.userName;}

    public String getTel(){return this.tel;}

    public String getToken(){return this.token;}

    public String getChat_title(){return this.chat_title;}

    @Override
    public int hashCode(){
        return 17*getUserName().hashCode();
    }

    @Override
    public boolean equals(Object o){
        if(o==null || !(o instanceof User)){
            return false;
        }
        return getUserName().equals(((User) o).getUserName());
    }

    @Override
    public String toString(){
        return nickName==null ? userName:nickName;
    }

}
