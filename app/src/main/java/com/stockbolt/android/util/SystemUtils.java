package com.stockbolt.android.util;

import android.app.Activity;
import android.content.Context;

import java.util.LinkedList;
import java.util.List;

//import com.umeng.analytics.MobclickAgent;

public class SystemUtils {

    public static int count;
    private List<Activity> mList = new LinkedList<>();

    private static SystemUtils instance;

    private SystemUtils() {
    }

    public synchronized static SystemUtils getInstance() {
        if (null == instance)
            instance = new SystemUtils();
        return instance;
    }

    // add Activity
    public void addActivity(Activity activity) {
        if (!mList.contains(activity))
            mList.add(activity);
    }

    public void exit(Context context) {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
                System.gc();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            MobclickAgent.onKillProcess(context);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }



}
