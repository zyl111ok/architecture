package com.zyl2015.trid.ui.activities;

import android.view.View;

import com.zyl2015.trid.enums.RefreshType;

/**
 * 适配器模式，对于不需要handlerUI的Activity，可以继承该适配器
 * Created by zyl on 2015/11/9.
 */
public class BaseActivityAdapter extends BaseActivity {
    @Override
    public void handlerUI(RefreshType type){
        //stub method
    }
    @Override
    public void widgetClick(View v){
        //stub method
    }
}
