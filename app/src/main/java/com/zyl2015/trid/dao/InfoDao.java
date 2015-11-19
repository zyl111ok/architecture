package com.zyl2015.trid.dao;

import com.zyl2015.trid.models.InfoModel;
import com.zyl2015.trid.models.UserModel;

/**
 * Created by Administrator on 2015/11/19.
 */
public interface InfoDao extends IBaseDao<InfoModel> {
    @Override
    InfoModel getModel();

    /**
     * 获取环信id
     * @return
     */
    String getHxId();

    /**
     * 获取密码
     * @return
     */
    String getPwd();

    /**
     * 获取token
     * @return
     */
    String getToken();

    /**
     * 判断是否已经登录
     * @return
     */
    boolean getAlreadyLogin();

    /**
     * 判断是否需要基础信息
     * @return
     */
    boolean getBasicInfoRequired();

    /**
     * 保存环信id
     * @param hxId
     */
    void setHxId(String hxId);

    /**
     * 保存环信密码
     * @param pwd
     */
    void setPwd(String pwd);

    /**
     * 保存token
     * @param token
     */
    void setToken(String token);

    /**
     * 保存登录信息
     * @param paramBoolean
     */
    void setAlreadyLogin(boolean paramBoolean);

}
