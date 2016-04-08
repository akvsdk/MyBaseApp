package com.ep.joy.mybaseapp.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.activity.Main;
import com.ep.joy.mybaseapp.activity.MainActivity;
import com.ep.joy.mybaseapp.base.BaseFragment;


public class MineFragment extends BaseFragment {


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_mine);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("com.ep.joy.mybaseapp.activity.Main".equals(getActivity().getLocalClassName().trim())) {
                    startActivity(new Intent(getActivity(), MainActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), Main.class));
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

}
