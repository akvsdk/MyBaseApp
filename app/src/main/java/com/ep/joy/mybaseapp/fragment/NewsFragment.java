package com.ep.joy.mybaseapp.fragment;

import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.FrameLayout;

import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.base.BaseFragment;


public class NewsFragment extends BaseFragment {

    private FrameLayout mFrameLayout;
    private FloatingActionButton mButton;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView(View view) {
        mFrameLayout = (FrameLayout) view.findViewById(R.id.content);
        mButton = (FloatingActionButton) view.findViewById(R.id.fab);
    }

    @Override
    protected void initData() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(mFrameLayout, "wtf");
            }
        });
    }


}
