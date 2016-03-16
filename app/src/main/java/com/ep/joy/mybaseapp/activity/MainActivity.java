package com.ep.joy.mybaseapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.TypeReference;
import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.entity.User;
import com.ep.joy.mybaseapp.http.AppDao;

import cn.jclick.httpwrapper.callback.MyCallBack;

public class MainActivity extends BaseActivity {

    private TextView mTextView;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv);
        mImageView = (ImageView) findViewById(R.id.img);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDao.getInstance().fuck(new MyCallBack<User>(MainActivity.this, new TypeReference<User>() {
                }) {
                    @Override
                    protected void onSuccess(User result) {
                        mTextView.setText(result.getList().get(0).getReleaseName());
                    }

                    @Override
                    protected void onCache(User result) {

                    }
                });
            }
        });
    }
}
