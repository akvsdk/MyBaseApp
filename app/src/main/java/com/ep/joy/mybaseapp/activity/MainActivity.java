package com.ep.joy.mybaseapp.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.ep.joy.mybaseapp.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inittab();

//        mTextView = (TextView) findViewById(R.id.tv);
//        mImageView = (ImageView) findViewById(R.id.img);
//        mTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppDao.getInstance().fuck(new MyCallBack<User>(MainActivity.this, new TypeReference<User>() {
//                }) {
//                    @Override
//                    protected void onSuccess(User result) {
//                        mTextView.setText(result.getList().get(0).getReleaseName());
//                    }
//
//                    @Override
//                    protected void onCache(User result) {
//
//                    }
//                });
//            }
//        });
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
        mTabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

            }
        });
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private View buildTab(Tab tab) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_indicator, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_icon);
        TextView textView = (TextView) view.findViewById(R.id.tab_txt);
        imageView.setBackground(getDrawable(tab.getImg()));
        textView.setText(tab.getTitle());
        return view;
    }
}
