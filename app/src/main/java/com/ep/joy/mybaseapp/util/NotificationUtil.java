package com.ep.joy.mybaseapp.util;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * author   Joy
 * Date:  2016/3/31.
 * version:  V1.0
 * Description:通知工具类
 */
public class NotificationUtil {
    /**
     * 发送不会重复的通知
     *
     * @param context
     * @param title       标题
     * @param message     消息
     * @param SmallIconId 图标
     * @param activity    要启动的类
     * @param extras      传递的参数
     */
    @SuppressLint("NewApi")
    public static void sendNotification(Context context, String title,
                                        String message, int SmallIconId, Class<?> activity, Bundle extras) {

        Intent mIntent = new Intent(context, activity);
        mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        if (extras != null) {
            mIntent.putExtras(extras);
        }


        int requestCode = (int) System.currentTimeMillis();

        PendingIntent mContentIntent = PendingIntent.getActivity(context,
                requestCode, mIntent, 0);

        Notification mNotification = new Notification.Builder(context)
                .setContentTitle(title).setSmallIcon(SmallIconId)
                .setContentIntent(mContentIntent).setContentText(message)
                .build();
        mNotification.flags |= Notification.FLAG_AUTO_CANCEL;
        mNotification.defaults = Notification.DEFAULT_ALL;

        NotificationManager mNotificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(requestCode, mNotification);
    }

}
