package com.ep.joy.mybaseapp.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.TypeReference;
import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.base.BaseLoadingActivity;
import com.ep.joy.mybaseapp.entity.News;
import com.ep.joy.mybaseapp.entity.Result;
import com.ep.joy.mybaseapp.http.AppDao;

import cn.jclick.httpwrapper.callback.MyCallBack;

/**
 * author   Joy
 * Date:  2016/4/12.
 * version:  V1.0
 * Description:
 */
public class Loading extends BaseLoadingActivity {

    private TextView mTextView;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_loading;
    }

    @Override
    protected void initViewsAndEvents() {
        mTextView = (TextView) findViewById(R.id.tv_t);
    }

    @Override
    protected void doRefresh() {
        AppDao.getInstance().getNews(new MyCallBack<Result<News>>(new TypeReference<Result<News>>() {
        }) {
            @Override
            protected void onSuccess(Result<News> result, boolean isCache) {
                if (result.isSuccess()) {
                    Toast.makeText(Loading.this, result.getRecord().getNewsList().get(0).getSubtitle(), Toast.LENGTH_SHORT).show();
                }
            }
        });
//        AppDao.getInstance().fuck(new MyBaseCallBack<User>(this, new TypeReference<User>() {
//        }) {
//
//            @Override
//            protected void onSuccess(User result) {
//                mTextView.setText(result.getList().get(0).getSignEndTime());
//            }
//
//            @Override
//            protected void onCache(User result) {
//
//            }
//        });

    }

    //    public void doHttp(View v) {
//        AppDao.getInstance().fuck(1,new MyCallBack<User>(new TypeReference<User>() {
//        }) {
//            @Override
//            protected void onSuccess(User result) {
//                Toast.makeText(Loading.this, result.getList().get(0).getReleaseName(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            protected void onCache(User result) {
//
//            }
//        });
//
//    }
    public void doHttp(View v) {
        AppDao.getInstance().getNews(new MyCallBack<Result<News>>(new TypeReference<Result<News>>() {
        }) {
            @Override
            protected void onSuccess(Result<News> result, boolean isCache) {
                Toast.makeText(Loading.this, result.getRecord().getNewsList().get(0).getSubtitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
