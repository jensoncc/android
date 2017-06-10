package com.stockbolt.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stockbolt.android.AppMain;
import java.util.ArrayList;
import java.util.List;


public class SpsUtil {
    private static SharedPreferences preferences;
    private static Context mContext = AppMain.getTotalContext();

    /**
     * 初始化preferences
     */
    private static void initPreferences() {
//        if (mContext == null)
//            mContext = AppMain.getTotalContext();
//        if (preferences == null)
//            preferences = mContext.getSharedPreferences(mContext.getString(R.string.WeLand), Context.MODE_PRIVATE);
    }

    public static int getInt(int nResID) {

        return SharedPreferenceUtil.getInt(mContext, mContext.getString(nResID));

    }

    public static int getInt(String strKey) {
        return SharedPreferenceUtil.getInt(mContext, strKey);
    }

    public static boolean getBoolean(int nResID) {
        return SharedPreferenceUtil.getBoolean(mContext, mContext.getString(nResID));
    }

    public static String getString(int nResID) {
        return SharedPreferenceUtil.getString(mContext, mContext.getString(nResID));
    }

    public static void editString(int nResID, String strContent) {
        if (TextUtils.isEmpty(strContent))
            strContent = "";
        SharedPreferenceUtil.setString(mContext, mContext.getString(nResID), strContent);
    }

    public static void editString(String strKey, String strContent) {
        SharedPreferenceUtil.setString(mContext, strKey, strContent);
    }

    public static void editLong(int nResID, long content) {
        SharedPreferenceUtil.setLong(mContext, mContext.getString(nResID), content);
    }

    public static void editInt(int nResID, int value) {
        SharedPreferenceUtil.setInt(mContext, mContext.getString(nResID), value);
    }

    public static void editBoolean(int nResID, String key, boolean value) {
        SharedPreferenceUtil.setBoolean(mContext, key, value);
    }


//    public static void editStringList(int nResID, List<String> list) {
//        if (list == null || list.size() == 0) {
//            editString(nResID, "");
//            return;
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(list.get(i));
//            if (i != list.size() - 1)
//                sb.append(",");
//        }
//        String saveProperty = sb.toString();
//        editString(nResID, saveProperty);
//    }
//
//    public static List<String> getStringList(int nResID) {
//        String textAll = getString(nResID);
//        String[] values = null;
//        try {
//            values = textAll.split(",");
//        } catch (Exception e) {
//        }
//
//        List<String> list = new ArrayList<String>();
//        if (values != null && values.length > 0)
//            for (int j = 0; j < values.length; j++)
//                if (!TextUtils.isEmpty(values[j]))
//                    list.add(values[j]);
//        return list;
//    }

    public static List<String> getArrayList(int nResID) {
        initPreferences();
        String[] arrays = mContext.getResources().getStringArray(nResID);
        if (arrays == null || arrays.length <= 0)
            return new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++)
            list.add(arrays[i]);
        return list;
    }

    /**
     * 清除资料
     *
     * @param mContext
     */
    public static void cleanPreferences(Context mContext) {
        initPreferences();
        preferences.edit().clear().commit();
    }


}
