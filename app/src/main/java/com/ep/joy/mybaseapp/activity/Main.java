package com.ep.joy.mybaseapp.activity;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
    private HomeFragment homeFragment;
    private FindFragment findFragment;
    private NewsFragment newsFragment;
    private MineFragment mineFragment;


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
        setDefaultFragment();

        //   mBottomBar.setFragmentItems(getSupportFragmentManager(),R.id.fragmentContainer,new BottomBarFragment());
        mBottomBar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                switch (menuItemId) {
                    case R.id.home_bottomBar:
                        if (homeFragment == null) {
                            homeFragment = new HomeFragment();
                        }
                        transaction.replace(R.id.fragmentContainer, homeFragment);
                        break;
                    case R.id.find_bottomBar:
                        if (findFragment == null) {
                            findFragment = new FindFragment();
                        }
                        transaction.replace(R.id.fragmentContainer, findFragment);
                        break;
                    case R.id.news_bottomBar:
                        if (newsFragment == null) {
                            newsFragment = new NewsFragment();
                        }
                        transaction.replace(R.id.fragmentContainer, newsFragment);
                        break;
                    case R.id.mine_bottomBar:
                        if (mineFragment == null) {
                            mineFragment = new MineFragment();
                        }
                        transaction.replace(R.id.fragmentContainer, mineFragment);
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

//        mBottomBar.setFragmentItems(getSupportFragmentManager(), R.id.fragmentContainer,
//                new BottomBarFragment(homeFragment, R.drawable.selector_icon_home, R.string.home),
//                new BottomBarFragment(findFragment, R.drawable.selector_icon_category, R.string.find),
//                new BottomBarFragment(newsFragment, R.drawable.selector_icon_hot, R.string.news),
//                new BottomBarFragment(mineFragment, R.drawable.selector_icon_mine, R.string.mine)
//        );
        //  mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        // mBottomBar.mapColorForTab(1, 0xFF5D4037);
        // mBottomBar.mapColorForTab(2, "#7B1FA2");
        // mBottomBar.mapColorForTab(3, "#FF5252");
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorPrimary));
        mBottomBar.mapColorForTab(1, ContextCompat.getColor(this, R.color.colorPrimary));
        mBottomBar.mapColorForTab(2, ContextCompat.getColor(this, R.color.colorPrimary));
        mBottomBar.mapColorForTab(3, ContextCompat.getColor(this, R.color.colorPrimary));

    }

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        transaction.replace(R.id.fragmentContainer, homeFragment);
        transaction.commit();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

    public void switchContent(Fragment from, Fragment to) {  // // TODO: 2016/4/12   http://www.yrom.net/blog/2013/03/10/fragment-switch-not-restart/
        if (mContent != to) {
            mContent = to;
            FragmentTransaction transaction = mFragmentMan.beginTransaction().setCustomAnimations(
                    android.R.anim.fade_in, R.anim.slide_out);
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.hide(from).add(R.id.content_frame, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }
}
