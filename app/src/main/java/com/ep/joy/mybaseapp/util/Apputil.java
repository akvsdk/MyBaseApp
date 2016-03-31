package com.ep.joy.mybaseapp.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.telephony.TelephonyManager;

import java.io.File;

/**
 * author   Joy
 * Date:  2016/3/31.
 * version:  V1.0
 * Description: 应用数据清除管理器
 */
public class Apputil {

    /**
     * 获取App包 信息版本号
     *
     * @param context
     * @return
     */
    public PackageInfo getAppInfo(Context context) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo;
    }

    /**
     * 获取手机的IMEI号
     */
    public static String getIMEI(Context context) {
        if (context == null) {
            LogUtils.e("getIMEI  context为空");
        }
        TelephonyManager telecomManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telecomManager.getDeviceId();
        LogUtils.i("IMEI标识：" + imei);
        return imei;
    }

    /**
     * 获取 MAC 地址
     * <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
     */
    public static String getMacAddress(Context context) {
        //wifi mac地址
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        String mac = info.getMacAddress();

        return mac;
    }

    /**
     * 获取手机号码
     */
    public static String getTelNumber(Context context) {
        if (context == null) {
            LogUtils.e("getTelNumber  context为空");
        }
        TelephonyManager telecomManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String numer = telecomManager.getLine1Number(); // 手机号码，有的可得，有的不可得
        LogUtils.i("手机号码：" + numer);
        return numer;
    }


    /**
     * 清除本应用内部缓存(/data/data/com.xxx.xxx/cache)
     *
     * @param context
     */
    public static void cleanInternalCache(Context context) {
        deleteFilesByDirectory(context.getCacheDir());
    }


    /**
     * 获取内部缓存大小
     *
     * @param context
     * @return
     */
    public static long getInternalCacheSize(Context context) {
        return getFilesSize(context.getCacheDir());
    }


    /**
     * 外部缓存大小
     *
     * @param context
     * @return
     */
    public static long getExternalCacheSize(Context context) {
        return getFilesSize(context.getExternalCacheDir());
    }

    /**
     * 清除本应用所有数据库(/data/data/com.xxx.xxx/databases)
     *
     * @param context
     */
    public static void cleanDatabases(Context context) {
        deleteFilesByDirectory(new File("/data/data/"
                + context.getPackageName() + "/databases"));
    }

    /**
     * 清除本应用SharedPreference(/data/data/com.xxx.xxx/shared_prefs)
     *
     * @param context
     */
    public static void cleanSharedPreference(Context context) {
        deleteFilesByDirectory(new File("/data/data/"
                + context.getPackageName() + "/shared_prefs"));
    }

    /**
     * 按名字清除本应用数据库
     *
     * @param context
     * @param dbName
     */
    public static void cleanDatabaseByName(Context context, String dbName) {
        context.deleteDatabase(dbName);
    }

    /**
     * 清除/data/data/com.xxx.xxx/files下的内容
     *
     * @param context
     */
    public static void cleanFiles(Context context) {
        deleteFilesByDirectory(context.getFilesDir());
    }

    /**
     * 清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache)
     *
     * @param context
     */
    public static void cleanExternalCache(Context context) {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            deleteFilesByDirectory(context.getExternalCacheDir());
        }
    }

    /**
     * 清除自定义路径下的文件，使用需小心，请不要误删。而且只支持目录下的文件删除
     *
     * @param filePath
     */
    public static void cleanCustomCache(String filePath) {
        deleteFilesByDirectory(new File(filePath));
    }

    /**
     * 清除本应用所有的数据
     *
     * @param context
     * @param filepath
     */
    public static void cleanApplicationData(Context context, String... filepath) {
        cleanInternalCache(context);
        cleanExternalCache(context);
        cleanDatabases(context);
        cleanSharedPreference(context);
        cleanFiles(context);
        for (String filePath : filepath) {
            cleanCustomCache(filePath);
        }
    }

    /**
     * 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理
     *
     * @param directory
     */
    private static void deleteFilesByDirectory(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            for (File item : directory.listFiles()) {
                item.delete();
            }
        }
    }


    /**
     * 获得文件大小和文件夹下所有文件的大小
     *
     * @param mfile
     */
    private static long getFilesSize(File mfile) {
        if (mfile != null && mfile.exists()) {
            if (mfile.isDirectory()) {
                int sum = 0;
                for (File item : mfile.listFiles()) {
                    sum += getFilesSize(item);
                }
                return sum;
            } else {
                return mfile.length();
            }
        } else {
            return 0l;
        }

    }

}
