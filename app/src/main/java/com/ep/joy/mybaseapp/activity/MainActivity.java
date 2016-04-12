package com.ep.joy.mybaseapp.activity;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.base.BaseActivity;
import com.ep.joy.mybaseapp.entity.Tab;
import com.ep.joy.mybaseapp.fragment.FindFragment;
import com.ep.joy.mybaseapp.fragment.HomeFragment;
import com.ep.joy.mybaseapp.fragment.MineFragment;
import com.ep.joy.mybaseapp.fragment.NewsFragment;
import com.ep.joy.mybaseapp.weight.FragmentTabHost;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private FragmentTabHost mTabhost;
    private ArrayList<Tab> tabs = new ArrayList<>(4);
    private long exitTime;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {
        exitTime = System.currentTimeMillis();
        inittab();
    }

    private void inittab() {
        Tab tab1 = new Tab(R.string.home, R.drawable.selector_icon_home, HomeFragment.class);
        Tab tab2 = new Tab(R.string.find, R.drawable.selector_icon_category, FindFragment.class);
        Tab tab3 = new Tab(R.string.news, R.drawable.selector_icon_hot, NewsFragment.class);
        Tab tab4 = new Tab(R.string.mine, R.drawable.selector_icon_mine, MineFragment.class);
        tabs.add(tab1);
        tabs.add(tab2);
        tabs.add(tab3);
        tabs.add(tab4);
        mTabhost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        for (Tab tab : tabs) {
            TabHost.TabSpec tabspec = mTabhost.newTabSpec(getString(tab.getTitle()));
            tabspec.setIndicator(buildTab(tab));
            mTabhost.addTab(tabspec, tab.getFragment(), null);
        }
        mTabhost.getTabWidget().setDividerDrawable(null); // 去掉分割线
        mTabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

            }
        });
    }

    private View buildTab(Tab tab) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_indicator, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_icon);
        TextView textView = (TextView) view.findViewById(R.id.tab_txt);
        Drawable drawable = ContextCompat.getDrawable(this, tab.getImg());
        imageView.setBackground(drawable);
        textView.setText(tab.getTitle());
        return view;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
