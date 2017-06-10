package com.stockbolt.android.util;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by guobin.zheng on 2016/6/2.
 * layout params util
 */
public class LayoutParamUtil   {
    private static final String TAG = "LayoutParamUtil";

    public static void setLayoutWidth(View view, int nWidth) {
        setLayoutEdge(view, nWidth, 0);
    }

    public static void setLayoutHeight(View view, int nHeight) {
        setLayoutEdge(view, 0, nHeight);
    }

    public static void setMarginLeftParams(View view, int nLeft) {
        setMargin(view, nLeft, 0, 0, 0);
    }

    public static void setMarginTopParams(View view, int nTop) {setMargin(view, 0, nTop, 0, 0);}

    public static void setMarginRightParams(View view, int nRight) {
        setMargin(view, 0, 0, nRight, 0);
    }

    public static void setMarginBottomParams(View view, int nBottom) {
        setMargin(view, 0, 0, 0, nBottom);
    }

    public static void setLayoutEdge(View view, int nWidth, int nHeight) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.width = nWidth == 0 ? lp.width : nWidth;
        lp.height = nHeight == 0 ? lp.height : nHeight;
        view.setLayoutParams(lp);
    }

    public static void setMargin(View view, int nLeft, int nTop, int nRight, int nBottom) {
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Log.e(TAG, "parent of this view's layout params don't extent MarginLayoutParams");
            return;
        }
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        lp.leftMargin = nLeft == 0 ? lp.leftMargin : nLeft;
        lp.topMargin = nTop == 0 ? lp.topMargin : nTop;
        lp.rightMargin = nRight == 0 ? lp.rightMargin : nRight;
        lp.bottomMargin = nBottom == 0 ? lp.bottomMargin : nBottom;
        view.setLayoutParams(lp);
    }

}
