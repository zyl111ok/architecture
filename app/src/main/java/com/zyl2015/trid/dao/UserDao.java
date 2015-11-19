package com.zyl2015.trid.dao;

import com.zyl2015.trid.models.UserModel;

/**
 * 抽象类接口，操作用户数据
 * Created by Administrator on 2015/11/19.
 */
public interface UserDao extends IBaseDao<UserModel> {
    /**
     * 建表的抽象操作
     */
    void createTable();

    /**
     * 向表中插入数据的抽象操作
     * @param user
     */
    void setUserInfo(UserModel user);

    /**
     * 修改表中数据的抽象接口
     * @param user
     */
    void changeUserInfo(UserModel user,String valueType,String newValue);
    /**
     * 从数据库中查询，并得到用户的聊天标题
     * @return
     */
    String getUserChatTitle(String username);

    /**
     * 从数据库中查询，并得到用户的电话号码
     * @return
     */
    String getTel(String username);

    /**
     * 从数据库中查询,得到到期时间
     * @return
     */
    long getAvtar(String username);

    /**
     * 从数据库中删除用户
     * @param username
     */
    void deleteUser(String username);

    /**
     * 得到数据模型，这里是User
     * @return
     */
    @Override
    UserModel getModel();


}
