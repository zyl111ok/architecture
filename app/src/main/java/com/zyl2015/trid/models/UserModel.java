package com.zyl2015.trid.models;

/**
 * Created by zyl on 2015/10/25.
 */
import com.zyl2015.trid.util.UserUtil;

/**
 * 通信实体类
 */
public class UserModel {

    private String userName;
    private String nickName;
    private String tel;
    private String token;
    private String chat_title;
    private int type;
    //过期时间
    private long avatar;

    public void setUserName(String userName){
        this.userName=userName;
        UserUtil.putUserByName(userName,this);
    }

    public void setAvatar(long avatar) {
        this.avatar = avatar;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getNickName() {
        return nickName;
    }

    public long getAvatar() {

        return avatar;
    }

    public int getType() {
        return type;
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
        if(o==null || !(o instanceof UserModel)){
            return false;
        }
        return getUserName().equals(((UserModel) o).getUserName());
    }

    @Override
    public String toString(){
        return nickName==null ? userName:nickName;
    }

}
