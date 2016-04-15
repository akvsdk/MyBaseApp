package com.ep.joy.mybaseapp.fragment;

import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.alibaba.fastjson.TypeReference;
import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.adapter.MyAdapter;
import com.ep.joy.mybaseapp.base.BaseFragment;
import com.ep.joy.mybaseapp.entity.User;
import com.ep.joy.mybaseapp.http.AppDao;
import com.ep.joy.mybaseapp.weight.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import cn.jclick.httpwrapper.callback.MyCallBack;


public class NewsFragment extends BaseFragment {

    private FrameLayout mFrameLayout;
    private FloatingActionButton mButton;
    private RefreshLayout refreshLayout;

    private List<User.ListEntity> mUser = new ArrayList<>();
    private ListView mListView;
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private int index = 1;
    private boolean isListview = true;

    @Override
    protected int getContentViewLayoutID() {
        if ("com.ep.joy.mybaseapp.activity.Main".equals(getActivity().getLocalClassName().trim())) {
            isListview = false;
            return R.layout.fragment_newss;
        } else {
            return R.layout.fragment_news;
        }

    }

    @Override
    protected void initView(View view) {
        mFrameLayout = (FrameLayout) view.findViewById(R.id.content);
        mButton = (FloatingActionButton) view.findViewById(R.id.fab);
        refreshLayout = (RefreshLayout) view.findViewById(R.id.rl_root);
        if (isListview) {
            mListView = (ListView) view.findViewById(R.id.list);
        } else {
            mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        }

    }

    @Override
    protected void initData() {
        mMyAdapter = new MyAdapter(getActivity(), mUser, R.layout.item_single);
        if (isListview) {

            mListView.setAdapter(mMyAdapter);
        } else {
            mRecyclerView.setAdapter(mMyAdapter);
            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }
        refreshLayout.setOnRefreshListener(new RefreshLayout.OnRefreshListener() {
            @Override
            public void onRefreshing() {
                index = 1;
                mMyAdapter.clear();
                dohttp();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefreshing();
                    }
                }, 1000);

            }

            @Override
            public void onLoading() {
                index++;
                dohttp();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefreshing();
                    }
                }, 1000);
            }
        });

    }

    private void dohttp() {
        AppDao.getInstance().fuck(index, new MyCallBack<User>(new TypeReference<User>() {
        }) {
            @Override
            protected void onSuccess(User result) {
                mMyAdapter.addAll(result.getList());
            }

            @Override
            protected void onCache(User result) {
                refreshLayout.setBackgroundColor(getResources().getColor(R.color.white));
                mMyAdapter.addAll(result.getList());

            }
        });

    }


}
