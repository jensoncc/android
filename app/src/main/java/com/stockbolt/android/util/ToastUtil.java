package com.stockbolt.android.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

import com.stockbolt.android.AppMain;


public class ToastUtil {

    private static Toast longToast;
    private static Toast shortToast;
    private static Context mContext;

    private static void initContext() {
        if (mContext == null)
            mContext = AppMain.getTotalContext();
        cancelToast();
    }


    public static void showToastShort(int strId) {
        initContext();
        if (strId <= 0)
            return;
        shortToast = Toast.makeText(mContext, strId, Toast.LENGTH_SHORT);
        showToast(shortToast);
    }

    public static void showToastShort(String str) {
        initContext();
        if (TextUtils.isEmpty(str))
            return;
        shortToast = Toast.makeText(mContext, str, Toast.LENGTH_SHORT);
        showToast(shortToast);
    }

    public static void showToastLong(int strId) {
        initContext();
        if (strId <= 0)
            return;
        longToast = Toast.makeText(mContext, strId, Toast.LENGTH_LONG);
        showToast(longToast);
    }

    public static void showToastLong(String str) {
        initContext();
        if (TextUtils.isEmpty(str))
            return;
        longToast = Toast.makeText(mContext, str, Toast.LENGTH_LONG);
        showToast(longToast);
    }

    private static void showToast(Toast toast) {
        toast.setGravity(Gravity.TOP, 0, 100);
        toast.show();
    }

    private static void cancelToast() {
        if (shortToast != null)
            shortToast.cancel();
        if (longToast != null)
            longToast.cancel();
    }

}
