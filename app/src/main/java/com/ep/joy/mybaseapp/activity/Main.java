package com.ep.joy.mybaseapp.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.base.BaseActivity;
import com.ep.joy.mybaseapp.fragment.FindFragment;
import com.ep.joy.mybaseapp.fragment.HomeFragment;
import com.ep.joy.mybaseapp.fragment.MineFragment;
import com.ep.joy.mybaseapp.fragment.NewsFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarFragment;

/**
 * author   Joy
 * Date:  2016/3/18.
 * version:  V1.0
 * Description:
 */
public class Main extends BaseActivity {
    private BottomBar mBottomBar;


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
        HomeFragment homeFragment = new HomeFragment();
        FindFragment findFragment = new FindFragment();
        NewsFragment newsFragment = new NewsFragment();
        MineFragment mineFragment = new MineFragment();

        mBottomBar.setFragmentItems(getSupportFragmentManager(), R.id.fragmentContainer,
                new BottomBarFragment(homeFragment, R.drawable.selector_icon_home, R.string.home),
                new BottomBarFragment(findFragment, R.drawable.selector_icon_category, R.string.find),
                new BottomBarFragment(newsFragment, R.drawable.selector_icon_hot, R.string.news),
                new BottomBarFragment(mineFragment, R.drawable.selector_icon_mine, R.string.mine)
        );
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
}
