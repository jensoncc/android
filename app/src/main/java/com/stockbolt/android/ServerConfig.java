package com.stockbolt.android;


public class ServerConfig {
    /**
     * 获取IP域名地址
     *
     * @return 返回域名
     */
    public static String getIpAddress() {
        return BuildConfig.API_SERVER_DOMAIN;
    }

    /**
     * 获取请求的服务器地址
     *
     * @return 返回服务器地址
     */
    public static String getServerAddress() {
        return getIpAddress();
    }

    public static String getMethod() {
        return BuildConfig.API_METHOD;
    }

    public static boolean isTest() {
        return BuildConfig.DEBUG;
    }
}
