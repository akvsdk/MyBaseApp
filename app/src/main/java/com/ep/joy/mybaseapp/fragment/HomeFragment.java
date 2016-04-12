package com.ep.joy.mybaseapp.fragment;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.TypeReference;
import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.base.BaseFragment;
import com.ep.joy.mybaseapp.entity.User;
import com.ep.joy.mybaseapp.http.AppDao;
import com.ep.joy.mybaseapp.util.LogUtils;
import com.ep.joy.mybaseapp.weight.LoadingLayout;
import com.orhanobut.logger.Logger;

import cn.jclick.httpwrapper.callback.MyBaseCallBack;


public class HomeFragment extends BaseFragment {
    private TextView homeTv;
    CoordinatorLayout container;
    private View mViewContent;
    private LoadingLayout mLoadingLayout;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        container = (CoordinatorLayout) view.findViewById(R.id.container);
        homeTv = (TextView) view.findViewById(R.id.home_tv);
        mLoadingLayout = (LoadingLayout) view.findViewById(R.id.loading);
        mLoadingLayout.showError();
        mLoadingLayout.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoadingLayout.showContent();
            }
        });
        homeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDao.getInstance().fuck(new MyBaseCallBack<User>(getActivity(), new TypeReference<User>() {
                }) {
                    @Override
                    protected void onSuccess(User result) {
                        Logger.object(result.getList().get(0));
                        LogUtils.d("1111");
                        homeTv.setText(result.getList().get(0).getReleaseName());
                    }

                    @Override
                    protected void onCache(User result) {
                        Toast.makeText(context, "(⊙_⊙)?", Toast.LENGTH_SHORT).show();
                        Snackbar.make(container, result.getList().get(0).getReleaseName(), Snackbar.LENGTH_LONG).setAction("Intent", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(context, "凸^-^凸", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            }
        });
    }

    @Override
    protected void initData() {

    }

}
