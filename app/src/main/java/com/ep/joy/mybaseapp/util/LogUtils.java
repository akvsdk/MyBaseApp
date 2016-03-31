package com.ep.joy.mybaseapp.util;

import android.support.annotation.Nullable;

import com.orhanobut.logger.Logger;

/**
 * author   Joy
 * Date:  2016/3/30.
 * version:  V1.0
 * Description:
 */
public class LogUtils {

    private static boolean mIsOpen = true;


    public static void d(@Nullable String info, Object... args) {
        if (!mIsOpen) { // 如果把开关关闭了，那么就不进行打印
            return;
        }
        Logger.t(getClassName()).d(info, args);
    }

    public static void w(@Nullable String info, Object... args) {
        if (!mIsOpen) {
            return;
        }
        info = info == null ? getClassName() : info;
        Logger.w(info, args);
    }

    public static void v(@Nullable String info, Object... args) {
        if (!mIsOpen) {
            return;
        }
        info = info == null ? getClassName() : info;
        Logger.v(info, args);
    }


    public static void i(@Nullable String info, Object... args) {
        if (!mIsOpen) {
            return;
        }
        info = info == null ? getClassName() : info;
        Logger.i(info, args);
    }

    public static void e(@Nullable String info, Object... args) {
        if (!mIsOpen) {
            return;
        }
        info = info == null ? getClassName() : info;
        Logger.e(info, args);
    }

    public static void obj(Object object) {
        if (!mIsOpen) {
            return;
        }
        Logger.object(object);
    }

    public static void json(String s) {
        if (!mIsOpen) {
            return;
        }
        Logger.json(s);
    }


    private static String getClassName() {
        String result;
        // 这里的数组的index2是根据你工具类的层级做不同的定义，这里仅仅是关键代码
        StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[2];
        result = thisMethodStack.getClassName();
        int lastIndex = result.lastIndexOf(".");
        result = result.substring(lastIndex + 1, result.length());
        return result;
    }


}
