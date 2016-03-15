package com.ep.joy.mybaseapp.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Toast;

import com.bugtags.library.Bugtags;
import com.ep.joy.mybaseapp.util.PermissionsActivity;
import com.ep.joy.mybaseapp.util.PermissionsChecker;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.jclick.httpwrapper.callback.ResponseData;
import cn.jclick.httpwrapper.interceptor.HandlerInterceptor;
import cn.jclick.httpwrapper.request.HttpRequestAgent;
import cn.jclick.httpwrapper.request.RequestConfig;
import cn.jclick.httpwrapper.request.RequestParams;

/**
 * author   Joy
 * Date:  2016/3/15.
 * version:  V1.0
 * Description:
 */
public class BaseActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0; // 请求码

    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private PermissionsChecker mPermissionsChecker; // 权限检测器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RequestConfig config = new RequestConfig.Builder(this).logEnable(true).cacheMode(RequestConfig.HttpCacheMode.ALWAYS_CACHE)
                .cacheTimeInSeconds(10).connectionTimeOut(30 * 1000).addInterceptor(new HandlerInterceptor() {
                    @Override
                    public boolean preHandler(RequestParams params) {
                        //TODO 请求前的拦截器
                        return true;

                    }

                    @Override
                    public void postSuccessHandler(final RequestParams params, final int statusCode, Map<String, List<String>> headers) {
                        //TODO 请求成功的拦截器

                    }

                    @Override
                    public void postFailedHandler(IOException exception) {
                        //TODO 请求失败的拦截器
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(BaseActivity.this, "o(︶︿︶)o 敢不敢不坑爹", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    @Override
                    public void afterCompletion(RequestParams params, ResponseData<String> responseData) {
                        //TODO 请求逻辑处理完毕的回调
                    }
                }).build();

        HttpRequestAgent.getInstance().init(config);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Bugtags.onResume(this);
        if (mPermissionsChecker != null && mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
            startPermissionsActivity();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Bugtags.onPause(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Bugtags.onDispatchTouchEvent(this, ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        HttpRequestAgent.getInstance().interruptAllRequest();
    }

    private void startPermissionsActivity() {
        PermissionsActivity.startActivityForResult(this, REQUEST_CODE, PERMISSIONS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            Toast.makeText(this, "您的程序缺少部分权限，可能某些功能无法正常运行.", Toast.LENGTH_SHORT).show();
        }
    }

}
