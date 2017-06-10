package com.stockbolt.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDex;
import android.util.DisplayMetrics;
import android.util.Log;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.stockbolt.android.util.AppLifecycleUtil;
import com.stockbolt.android.util.ImageCacheSavePathUtil;
import com.stockbolt.android.util.SpsUtil;
import java.io.File;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AppMain extends Application {
    private static int screenWidth;
    private static int screenHeight;
    public static final String FRESCO_CACHE = "fresco";
    private static final int nPageSize = 10;
    private static Context mTotalContext;
    public static RealmConfiguration realmConfiguration;
    public static Realm realm;
//    public static User user;
    public static boolean reload = false;

    public static final int CROWDFUNDING_INIT = -1;
    public static final int CROWDFUNDING_PENDING = 0;
    public static final int CROWDFUNDING_START = 1;
    public static final int CROWDFUNDING_PAUSE = 2;
    public static final int CROWDFUNDING_RESTART = 3;
    public static final int CROWDFUNDING_CANCEL = 4;
    public static final int CROWDFUNDING_END = 5;
    public static final int RS_PENDING = 6;
    public static final int RS_START = 7;
    public static final int RS_PAUSE = 8;
    public static final int RS_RESTART = 9;
    public static final int RS_CANCEL = 10;
    public static final int RS_END = 11;
    public static final int RS_SOLD = 12;

    public static double SELL_FEES_RATE = 0.05d;
    public static double MAX_INVEST_AMOUNT = 999999999999.0;
    public static double TRADE_HANDLING_FEE_RATE;
    public static double TRADE_TRANSACTION_FEE_RATE;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        // TODO 自动生成的方法存根
        super.onCreate();
        mTotalContext = this.getApplicationContext();
        initFresco(this);
        initRealm();
        //初始化 AppStatusUtil
        this.registerActivityLifecycleCallbacks(AppLifecycleUtil.getInstance());
    }

    private static void initFresco(Context context) {
        final int MAX_DISK_CACHE_VERY_LOW_SIZE = 10 * ByteConstants.MB;//默认图极低磁盘空间缓存的最大值
        final int MAX_DISK_CACHE_LOW_SIZE = 30 * ByteConstants.MB;//默认图低磁盘空间缓存的最大值
        final int MAX_DISK_CACHE_SIZE = 100 * ByteConstants.MB;//默认图磁盘缓存的最大值

        //默认图片的磁盘配置
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(context)
                .setBaseDirectoryPath(new File(ImageCacheSavePathUtil.getImageSavePath(context)))//缓存图片基路径
                .setBaseDirectoryName(FRESCO_CACHE)//文件夹名
                .setMaxCacheSize(MAX_DISK_CACHE_SIZE)//默认缓存的最大大小。
                .setMaxCacheSizeOnLowDiskSpace(MAX_DISK_CACHE_LOW_SIZE)//缓存的最大大小,使用设备时低磁盘空间。
                .setMaxCacheSizeOnVeryLowDiskSpace(MAX_DISK_CACHE_VERY_LOW_SIZE)//缓存的最大大小,当设备极低磁盘空间
                .build();

        ImagePipelineConfig.Builder builder = ImagePipelineConfig.newBuilder(context);
        builder.setMainDiskCacheConfig(diskCacheConfig);

        //FACEBOOK 图片加载工具
        Fresco.initialize(context, builder.build());
    }

    //--------------------------------------------------------------------------------------------------------

    /**
     * 设置屏幕宽度，在MainActivity,LoadingActivity调用
     */
    public static void setScreenWidth(int screenWidth) {
        AppMain.screenWidth = screenWidth;
        if (screenWidth != 0)
            SpsUtil.editInt(R.string.SCREEN_WIDTH, screenWidth);
    }

    public static int getScreenWidth() {
        if (screenWidth == 0)
            screenWidth = SpsUtil.getInt(R.string.SCREEN_WIDTH);
        return screenWidth;
    }

    /**
     * 设置屏幕高度，在MainActivity,LoadingActivity调用
     */
    public static void setScreenHeight(int screenHeight) {
        AppMain.screenHeight = screenHeight;
        if (screenHeight != 0)
            SpsUtil.editInt(R.string.SCREEN_HEIGHT, screenHeight);
    }

    public static int getScreenHeight() {
        if (screenHeight == 0)
            screenHeight = SpsUtil.getInt(R.string.SCREEN_HEIGHT);
        return screenHeight;
    }

    //--------------------------------------------------------------------------------------------------------


    /**
     * 获取用户ID
     */
    public static int getUserID() {
        return 0;
    }


    /**
     * 获取app的版本号
     *
     * @return 返回当前的版本号
     */
    public static int getVersionCode() {
        try {
            return mTotalContext.getPackageManager().getPackageInfo(mTotalContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取app的版本名称
     *
     * @return 返回当前的版本名称
     */
    public static String getVersionName() {
        try {
            return mTotalContext.getPackageManager().getPackageInfo(mTotalContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getMainPackageName() {
        try {
            return mTotalContext.getPackageManager().getPackageInfo(mTotalContext.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取屏幕宽高
     */
    public static void initScreen(Activity mActivity) {
        DisplayMetrics dm = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        AppMain.setScreenWidth(dm.widthPixels);
        AppMain.setScreenHeight(dm.heightPixels);
    }

    public static void logoutApp(Context mContext) {
        //清理数据缓存
//        SpsUtil.cleanPreferences(mContext);
//        SpsUtil.editInt(R.string.GUIDE_VERSION_CODE, AppMain.getVersionCode());
//        SpsUtil.editBoolean(R.string.GUIDE_IS_HAD, true);
//        SpsUtil.editBoolean(R.string.IS_NO_FIRST_INSTALL, true);
//        ExitAccountNotice.getInstance().notifyObserver(0);
    }


    public void initRealm() {
        Realm.init(mTotalContext);
        realmConfiguration = new RealmConfiguration.Builder()
                .name("test.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Log.d("RealmUtil", "RealmFile: delete:" + Realm.deleteRealm(realmConfiguration));
        realm = Realm.getInstance(realmConfiguration);
        Log.d("Realm", "path: " + realm.getPath());
    }

    public static Context getTotalContext() {
        return mTotalContext;
    }




}
