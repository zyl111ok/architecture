package com.zyl2015.trid.dao;

import android.content.Context;

import java.util.List;

/**
 * 数据操作的通用接口,封装对数据库的操作，面向用户
 * Created by zyl on 2015/10/27.
 */
public interface IBaseDao<T> {
    /**
     * 创建表
     */
    void createTable();
    /**
     * 插入一条记录
     */
    void insert(T model);

    /**
     * 插入多条记录
     * @param modelList
     */
    void insertModels(List<T> modelList);
    /**
     * 查询指定值的一条数据
     * @param tableName 表名
     * @param columName 查询条件:列名
     * @param columValue 查询条件 :列值
     * @return
     */
    T rawQuery(String tableName,String columName,String columValue);

    /**
     * 查询某一列等于指定值的一组数据
     * @param tableName
     * @param colunName
     * @param columValue
     * @return
     */
    List<T> rawsQuery(String tableName,String colunName,String columValue);
    /**
     * 从数据库中删除一条数据
     * @param id
     * @param tableName
     */
    void delete(int id,String tableName);

}
