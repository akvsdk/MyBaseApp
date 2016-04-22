package com.ep.joy.mybaseapp.base;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;

import com.ep.joy.mybaseapp.R;

/**
 * author   Joy
 * Date:  2016/4/20.
 * version:  V1.0
 * Description:
 */
public abstract class ToolBarActivity extends BaseActivity {
    protected Toolbar toolbar;
    protected AppBarLayout mbar;
    protected boolean isToolBarHiding = false;
    private CharSequence title;
    private boolean showback = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
    }

    private void initToolBar() {
        mbar = (AppBarLayout) findViewById(R.id.app_bar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle(title);
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            if (showback) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }

    }

    protected CharSequence setToolbar(String title) {
        this.title = title;
        return title;
    }

    protected void hideOrShowToolBar() {
        mbar.animate()
                .translationY(isToolBarHiding ? 0 : -mbar.getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();
        isToolBarHiding = !isToolBarHiding;
    }

    protected boolean isBack(boolean showBack) {
        this.showback = showBack;
        return showback;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //在Action Bar的最左边，就是Home icon和标题的区域
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
