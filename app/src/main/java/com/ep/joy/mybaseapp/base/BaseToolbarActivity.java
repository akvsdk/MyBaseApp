package com.ep.joy.mybaseapp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.bugtags.library.Bugtags;
import com.ep.joy.mybaseapp.R;

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
 * Description: 折叠视图的toolbar
 */
public abstract class BaseToolbarActivity extends AppCompatActivity {

    public static final long CACHE_TIME = 10;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseAppManager.getInstance().addActivity(this);
        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getBundleExtras(extras);
        }

        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
            getsavedInstanceState(savedInstanceState);
            inithttp();
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
        initToolBar();
        initViewsAndEvents();

    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle("");
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            if (isBack()) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    protected boolean isBack() {
        return true;
    }

    private void inithttp() {
        RequestConfig config = new RequestConfig.Builder(this).logEnable(true).cacheMode(RequestConfig.HttpCacheMode.ALWAYS_CACHE)
                .cacheTimeInSeconds(CACHE_TIME).connectionTimeOut(30 * 1000).addInterceptor(new HandlerInterceptor() {
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
                                Toast.makeText(BaseToolbarActivity.this, "o(︶︿︶)o 敢不敢不坑爹", Toast.LENGTH_SHORT).show();
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


    /**
     * show toast
     *
     * @param msg
     */
    protected void showToast(View v, String msg) {
        //防止遮盖虚拟按键
        if (null != msg && !TextUtils.isEmpty(msg)) {
            Snackbar.make(v, msg, Snackbar.LENGTH_SHORT).show();
        }
    }


    @Override
    public void finish() {
        super.finish();
        BaseAppManager.getInstance().removeActivity(this);
    }


    /**
     * startActivity
     *
     * @param clazz
     */
    protected void readyGo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz
     */
    protected void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }


    /**
     * startActivity with bundle then finish
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz
     * @param requestCode
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    protected void getBundleExtras(Bundle extras) {
    }

    protected void getsavedInstanceState(Bundle savedInstanceState) {
    }


    protected abstract int getContentViewLayoutID();

    protected abstract void initViewsAndEvents();
}
