package com.ep.joy.mybaseapp.activity;

import android.view.View;

import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.base.ToolBarActivity;

/**
 * author   Joy
 * Date:  2016/4/20.
 * version:  V1.0
 * Description:
 */
public class TestActivity extends ToolBarActivity {
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_test;
    }

    @Override
    protected void initViewsAndEvents() {
        isBack(true);
        setToolbar("JYQ");
    }

    public void showtool(View v) {
        hideOrShowToolBar();
    }
}
