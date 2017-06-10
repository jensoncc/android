package com.stockbolt.android.util;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by guobin.zheng on 2016/3/17.
 * viewparamsutil
 */
public class ViewParamsUtil {
    public static void setWidthHeight(View view, int nWidth, int nHeight) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.width = nWidth;
        lp.height = nHeight;
        view.setLayoutParams(lp);
    }
}
