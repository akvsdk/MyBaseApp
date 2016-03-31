package com.ep.joy.mybaseapp.application;

import android.app.Application;
import android.util.Log;

import com.bugtags.library.Bugtags;
import com.ep.joy.mybaseapp.BuildConfig;
import com.facebook.stetho.Stetho;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Settings;

/**
 * author   Joy
 * Date:  2016/3/15.
 * version:  V1.0
 * Description:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        BTGInvocationEventNone    // 静默模式，只收集 Crash 信息（如果允许）
//
//        BTGInvocationEventShake   // 通过摇一摇呼出 Bugtags
//
//        BTGInvocationEventBubble  // 通过悬浮小球呼出 Bugtags
        Logger.initialize(
                Settings.getInstance()
                        .isShowMethodLink(true)
                        .isShowThreadInfo(false)
                        .setMethodOffset(0)
                        .setLogPriority(BuildConfig.DEBUG ? Log.VERBOSE : Log.ASSERT)
        );

        Bugtags.start("daf756fd3bc68a71cb8985d33899601f", this, Bugtags.BTGInvocationEventBubble);
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}

