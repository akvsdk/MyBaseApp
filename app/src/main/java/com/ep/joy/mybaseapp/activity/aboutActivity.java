package com.ep.joy.mybaseapp.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.TextView;

import com.ep.joy.mybaseapp.BuildConfig;
import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.base.BaseToolbarActivity;

/**
 * author   Joy
 * Date:  2016/4/13.
 * version:  V1.0
 * Description:
 */
public class AboutActivity extends BaseToolbarActivity {


    private CollapsingToolbarLayout mLayout;
    private TextView mTextView;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_about;
    }

    @Override
    protected void initViewsAndEvents() {
        mLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mTextView = (TextView) findViewById(R.id.tv_version);
        mTextView.setText("版本号" + BuildConfig.VERSION_CODE);
        mLayout.setTitle("关于");
    }
}
