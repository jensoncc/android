package com.stockbolt.android.util;

import android.text.TextUtils;
import android.util.Log;

import com.stockbolt.android.ServerConfig;


/**
 * Created by guobin.zheng on 2015/7/16.
 * log工具
 */
public class LogUtil {
    private String TAG;
    private static boolean isLog = true;

    private LogUtil() {
    }

    public static LogUtil getInstance(String TAG) {
        LogUtil INSTANCE = new LogUtil();
        INSTANCE.TAG = TAG;
        isLog = ServerConfig.isTest();
        return INSTANCE;
    }

    public void LogV(String strContent) {
        if (!isLog || TextUtils.isEmpty(strContent))
            return;
        Log.v(TAG, strContent);
    }

    public void LogD(String strContent) {
        if (!isLog || TextUtils.isEmpty(strContent))
            return;
        Log.d(TAG, strContent);
    }

    public void LogI(String strContent) {
        if (!isLog || TextUtils.isEmpty(strContent))
            return;
        Log.i(TAG, strContent);
    }

    public void LogE(String strContent) {
        if (!isLog || TextUtils.isEmpty(strContent))
            return;
        Log.e(TAG, strContent);
    }

    public void LogW(String strContent) {
        if (!isLog || TextUtils.isEmpty(strContent))
            return;
        Log.w(TAG, strContent);
    }
}
