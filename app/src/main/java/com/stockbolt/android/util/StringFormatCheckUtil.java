package com.stockbolt.android.util;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatCheckUtil {
    public static boolean isAccountNeedCheck(String str) {
        return !TextUtils.isEmpty(str) && !(StringFormatCheckUtil.isEmail(str) || StringFormatCheckUtil.isMobileNO(str));
    }

    public static boolean isPswNeedCheck(String str)
    {
        return !TextUtils.isEmpty(str) && !StringFormatCheckUtil.isPassword(str);
    }

    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|147|(17[0,6,7,8])|(15[^4,\\D])|(18[0,1,2,3,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    //判断email格式是否正确
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    //判断密码格式是否正确
    public static boolean isPswFormat(String strPsw) {
        String str = "^[a-zA-Z0-9]{6,16}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(strPsw);
        return m.matches();
    }

    //判断是否全是数字
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isBigLetter(String str) {
        Pattern pattern = Pattern.compile("[A-Z]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;

    }

    public static boolean isSmallLetter(String str) {
        Pattern pattern = Pattern.compile("[a-z]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;

    }

    public static boolean isHadNumber(String str) {
        boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        for (int i = 0; i < str.length(); i++) {
            //用char包装类中的判断数字的方法判断每一个字符
            if (Character.isDigit(str.charAt(i))) {
                isDigit = true;
                break;
            }
        }
        return isDigit;
    }

    public static boolean isHadBigLetter(String str) {
        boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        for (int i = 0; i < str.length(); i++) {
            //用char包装类中的判断数字的方法判断每一个字符
            if (isBigLetter(String.valueOf(str.charAt(i)))) {
                isDigit = true;
                break;
            }
        }
        return isDigit;
    }

    public static boolean isHadSmallLetter(String str) {
        boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        for (int i = 0; i < str.length(); i++) {
            //用char包装类中的判断数字的方法判断每一个字符
            if (isSmallLetter(String.valueOf(str.charAt(i)))) {
                isDigit = true;
                break;
            }
        }
        return isDigit;
    }

    public static boolean isPassword(String str) {
        if (str.length() < 6 || str.length() > 16)
            return false;
        return isHadNumber(str) && isHadBigLetter(str) && isHadSmallLetter(str);
    }


    /**
     * 判断字符串是否全是中文
     *
     * @param str
     * @return 是、
     */
    public static boolean isChinese(String str) {
        char[] ch = str.toCharArray();
        boolean isCn = false;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            isCn = isChinese(c);
            if (isCn == false) {
                break;
            }
        }
        return isCn;
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是json结构
     */
    public static boolean isJson(String value) {
        if (value == null) {
            return false;
        }
        try {
            new JSONObject(value);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }
}
