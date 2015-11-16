package com.zyl2015.trid.util;

import com.zyl2015.trid.models.UserModel;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户登记册，用于统一管理用户
 * Created by zyl on 2015/10/26.
 */
public class UserUtil {
    private static Map<String,UserModel> map=new HashMap<String,UserModel>();

    /**
     * User实例化之后，即向该类登记注册User，并一直持有它，确保User不被GC过早的回收
     * @param name
     * @param userModel
     */
    public static void putUserByName(String name,UserModel userModel){
        map.put(name, userModel);
    }

    public static void removeUserByName(String name) {
        if (map.get(name) != null) {
            map.remove(name);
        }
    }

    public static UserModel getUserByName(String name){
        UserModel userModel;
        userModel =map.get(name);
        return userModel;
    }
}
