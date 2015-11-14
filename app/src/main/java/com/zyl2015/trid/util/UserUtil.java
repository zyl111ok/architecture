package com.zyl2015.trid.util;

import com.zyl2015.trid.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户登记册，用于统一管理用户
 * Created by zyl on 2015/10/26.
 */
public class UserUtil {
    private static Map<String,User> map=new HashMap<String,User>();

    /**
     * User实例化之后，即向该类登记注册User，并一直持有它，确保User不被GC过早的回收
     * @param name
     * @param user
     */
    public static void putUserByName(String name,User user){
        map.put(name,user);
    }

    public static void removeUserByName(String name) {
        if (map.get(name) != null) {
            map.remove(name);
        }
    }

    public static User getUserByName(String name){
        User user;
        user=map.get(name);
        return user;
    }
}
