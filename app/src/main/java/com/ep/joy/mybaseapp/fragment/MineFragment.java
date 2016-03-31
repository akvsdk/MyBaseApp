package com.ep.joy.mybaseapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.activity.Main;
import com.ep.joy.mybaseapp.activity.MainActivity;


public class MineFragment extends Fragment {


    private View mViewContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mViewContent == null) {
            mViewContent = inflater.inflate(R.layout.fragment_mine, container, false);
        }
        // 缓存View判断是否含有parent, 如果有需要从parent删除, 否则发生已有parent的错误.
        ViewGroup parent = (ViewGroup) mViewContent.getParent();
        if (parent != null) {
            parent.removeView(mViewContent);
        }
        return mViewContent;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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

}
