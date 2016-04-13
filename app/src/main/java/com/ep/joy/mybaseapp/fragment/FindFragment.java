package com.ep.joy.mybaseapp.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.activity.AboutActivity;
import com.ep.joy.mybaseapp.base.BaseFragment;


public class FindFragment extends BaseFragment {


    private TextView mTextView;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView(View view) {
        mTextView = (TextView) view.findViewById(R.id.find_tv);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AboutActivity.class));
            }
        });
    }

    @Override
    protected void initData() {

    }
}
