package com.zyl2015.trid.util;

import android.app.Activity;

import java.util.*;

/**
 * activity控制类，实现activity的全局控制
 * Created by zyl on 2015/10/26.
 */
public class ActivityUtil {
    public static List<Activity> activities=new ArrayList<Activity>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
