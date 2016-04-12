package com.ep.joy.mybaseapp.activity;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;

import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.base.BaseActivity;
import com.ep.joy.mybaseapp.fragment.FindFragment;
import com.ep.joy.mybaseapp.fragment.HomeFragment;
import com.ep.joy.mybaseapp.fragment.MineFragment;
import com.ep.joy.mybaseapp.fragment.NewsFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

/**
 * author   Joy
 * Date:  2016/3/18.
 * version:  V1.0
 * Description:
 */
public class Main extends BaseActivity {
    private BottomBar mBottomBar;
    private Fragment currentFragment;

    @Override
    protected void getsavedInstanceState(Bundle savedInstanceState) {
        super.getsavedInstanceState(savedInstanceState);
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.noTopOffset();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.main;
    }


    @Override
    protected void initViewsAndEvents() {
        switchFragment(new HomeFragment());
        //   mBottomBar.setFragmentItems(getSupportFragmentManager(),R.id.fragmentContainer,new BottomBarFragment());
        mBottomBar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
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
            public void onMenuTabReSelected(@IdRes int menuItemId) {
            }
        });

        //  mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        // mBottomBar.mapColorForTab(1, 0xFF5D4037);
        // mBottomBar.mapColorForTab(2, "#7B1FA2");
        // mBottomBar.mapColorForTab(3, "#FF5252");
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorPrimary));
        mBottomBar.mapColorForTab(1, ContextCompat.getColor(this, R.color.colorPrimary));
        mBottomBar.mapColorForTab(2, ContextCompat.getColor(this, R.color.colorPrimary));
        mBottomBar.mapColorForTab(3, ContextCompat.getColor(this, R.color.colorPrimary));

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
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
