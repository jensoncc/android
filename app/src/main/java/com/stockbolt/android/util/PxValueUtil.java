package com.stockbolt.android.util;


import com.stockbolt.android.AppMain;

/**
 * Created by guobin.zheng on 2015/11/10.
 * 像素工具
 */
public class PxValueUtil {
    private static int px235;
    private static int px250;
    private static int px245;
    private static int px200;
    private static int px170;
    private static int px150;
    private static int px145;
    private static int px140;
    private static int px125;
    private static int px115;
    private static int px96;
    private static int px80;
    private static int px75;
    private static int px55;
    private static int px50;
    private static int px45;
    private static int px40;

    public static int getPx245() {
        if (px245 == 0)
            px245 = UiUtils.dpToPx(122.5f, AppMain.getTotalContext().getResources());
        return px245;
    }

    public static int getPx235() {
        if (px235 == 0)
            px235 = UiUtils.dpToPx(117.5f, AppMain.getTotalContext().getResources());
        return px235;
    }

    public static int getPx200() {
        if (px200 == 0)
            px200 = UiUtils.dpToPx(100f, AppMain.getTotalContext().getResources());
        return px200;
    }
    public static int getPx170() {
        if (px170 == 0)
            px170 = UiUtils.dpToPx(85f, AppMain.getTotalContext().getResources());
        return px170;
    }
    public static int getPx150() {
        if (px150 == 0)
            px150 = UiUtils.dpToPx(75f, AppMain.getTotalContext().getResources());
        return px150;
    }

    public static int getPx145() {
        if (px145 == 0)
            px145 = UiUtils.dpToPx(72.5f, AppMain.getTotalContext().getResources());
        return px145;
    }
    public static int getPx140() {
        if (px140 == 0)
            px140 = UiUtils.dpToPx(70f, AppMain.getTotalContext().getResources());
        return px140;
    }

    public static int getPx125() {
        if (px125 == 0)
            px125 = UiUtils.dpToPx(62.5f, AppMain.getTotalContext().getResources());
        return px125;
    }

    public static int getPx115() {
        if (px115 == 0)
            px115 = UiUtils.dpToPx(57.5f, AppMain.getTotalContext().getResources());
        return px125;
    }

    public static int getPx96() {
        if (px96 == 0)
            px96 = UiUtils.dpToPx(48f, AppMain.getTotalContext().getResources());
        return px96;
    }

    public static int getPx80() {
        if (px80 == 0)
            px80 = UiUtils.dpToPx(40f, AppMain.getTotalContext().getResources());
        return px80;
    }
    public static int getPx75() {
        if (px75 == 0)
            px75 = UiUtils.dpToPx(37.5f, AppMain.getTotalContext().getResources());
        return px75;
    }

    public static int getPx55() {
        if (px55 == 0)
            px55 = UiUtils.dpToPx(27.5f, AppMain.getTotalContext().getResources());
        return px55;
    }

    public static int getPx50() {
        if (px50 == 0)
            px50 = UiUtils.dpToPx(25f, AppMain.getTotalContext().getResources());
        return px50;
    }
    public static int getPx45() {
        if (px45 == 0)
            px45 = UiUtils.dpToPx(22.5f, AppMain.getTotalContext().getResources());
        return px45;
    }
    public static int getPx40() {
        if (px40 == 0)
            px40 = UiUtils.dpToPx(22.5f, AppMain.getTotalContext().getResources());
        return px40;
    }
}
