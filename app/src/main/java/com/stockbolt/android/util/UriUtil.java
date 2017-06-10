package com.stockbolt.android.util;

import android.content.Context;

/**
 * Created by guobin.zheng on 2015/5/12.
 * uri工具
 */
public class UriUtil {
    /**
     * 获取资源文件绝对路径
     */
    public static String getResPath(Context mContext, int nResID) {
        return "res://" + mContext.getPackageName() + "/" + nResID;
    }

    public static String getFilePath(String strFilePath) {
        return "file://" + strFilePath;
    }

    public static String getTotalPath(String strPath) {
        return strPath.contains("http") ? strPath : getFilePath(strPath);
    }
}
