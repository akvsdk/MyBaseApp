package com.ep.joy.mybaseapp.activity;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.base.BaseActivity;
import com.ep.joy.mybaseapp.fragment.FindFragment;
import com.ep.joy.mybaseapp.fragment.HomeFragment;
import com.ep.joy.mybaseapp.fragment.MineFragment;
import com.ep.joy.mybaseapp.fragment.NewsFragment;

import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

/**
 * author   Joy
 * Date:  2016/3/18.
 * version:  V1.0
 * Description:
 */
public class Main extends BaseActivity {
    // private BottomBar mBottomBar;
    private Fragment currentFragment;
    private BottomNavigation mBottomNavigation;

    @Override
    protected void getsavedInstanceState(Bundle savedInstanceState) {
        super.getsavedInstanceState(savedInstanceState);
        if (null == savedInstanceState) {
            mBottomNavigation.setDefaultSelectedIndex(0);
            //// TODO: 2016/4/27
        }


    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        mBottomNavigation = (BottomNavigation) findViewById(R.id.BottomNavigation);
        if (null != mBottomNavigation) {
            mBottomNavigation.setOnMenuItemClickListener(new BottomNavigation.OnMenuItemSelectionListener() {
                @Override
                public void onMenuItemSelect(@IdRes int i, int i1) {
                    switch (i) {
                        case R.id.home_bottomBar:
                            switchContent(currentFragment, new HomeFragment());
                            break;
                        case R.id.find_bottomBar:
                            switchContent(currentFragment, new FindFragment());
                            break;
                        case R.id.news_bottomBar:
                            switchContent(currentFragment, new NewsFragment());
                            break;
                        case R.id.mine_bottomBar:
                            switchContent(currentFragment, new MineFragment());
                            break;
                    }

                }

                @Override
                public void onMenuItemReselect(@IdRes int i, int i1) {

                }
            });
        }
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.main;
    }


    @Override
    protected void initViewsAndEvents() {
        switchFragment(new HomeFragment());
    }


    private void switchFragment(Fragment fragment) {
        if (currentFragment == null || !fragment.getClass().getName().equals(currentFragment.getClass().getName())) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
            currentFragment = fragment;
        }
    }

    public void switchContent(Fragment from, Fragment to) {
        if (currentFragment == null || !to.getClass().getName().equals(currentFragment.getClass().getName())) {
            currentFragment = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().setCustomAnimations(
                    android.R.anim.fade_in, android.R.anim.fade_out);
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.hide(from).add(R.id.fragmentContainer, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }
}
