package com.zyl2015.trid.dao;

import android.content.Context;

import java.util.List;

/**
 * 数据操作的通用接口,封装对数据库的操作，面向用户
 * Created by zyl on 2015/10/27.
 */
public interface IBaseDao<T> {
   T getModel();

}
