package com.ep.joy.mybaseapp.application;

import android.app.Application;

import com.bugtags.library.Bugtags;
import com.facebook.stetho.Stetho;

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

