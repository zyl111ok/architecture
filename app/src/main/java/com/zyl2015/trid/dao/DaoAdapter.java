package com.zyl2015.trid.dao;

import java.util.List;

/**
 * 数据访问操作的适配器，使子类能够使用IBaseDao接口
 * Created by Administrator on 2015/11/17.
 */
public class DaoAdapter<T> implements IBaseDao{
    @Override
    public void createTable() {

    }

    @Override
    public void insert(Object model) {}

    @Override
    public void insertModels(List modelList) {

    }

    @Override
    public Object rawQuery(String tableName, String columName, String columValue) {return null;}

    @Override
    public List rawsQuery(String tableName, String colunName, String columValue) {return null;}

    @Override
    public void delete(int id, String tableName) {}
}
