package com.ep.joy.mybaseapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ep.joy.mybaseapp.application.App;
import com.squareup.leakcanary.RefWatcher;

/**
 * author   Joy
 * Date:  2016/4/7.
 * version:  V1.0
 * Description:
 */
public abstract class BaseFragment extends Fragment {

    private View mViewContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mViewContent == null) {
            if (getContentViewLayoutID() != 0) {
                mViewContent = inflater.inflate(getContentViewLayoutID(), container, false);
            } else {
                throw new IllegalArgumentException("You must return a right contentView layout resource Id");
            }

        }
        // 缓存View判断是否含有parent, 如果有需要从parent删除, 否则发生已有parent的错误.
        ViewGroup parent = (ViewGroup) mViewContent.getParent();
        if (parent != null) {
            parent.removeView(mViewContent);
        }
        return mViewContent;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected void showToast(View v, String msg) {
        //防止遮盖虚拟按键
        if (null != msg && !TextUtils.isEmpty(msg)) {
            Snackbar.make(v, msg, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);//内存泄露检测
    }

    protected abstract int getContentViewLayoutID();

    protected abstract void initView(View view);

    protected abstract void initData();

}
