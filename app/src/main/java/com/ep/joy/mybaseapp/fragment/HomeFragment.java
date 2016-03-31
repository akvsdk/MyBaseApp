package com.ep.joy.mybaseapp.fragment;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.TypeReference;
import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.entity.User;
import com.ep.joy.mybaseapp.http.AppDao;
import com.ep.joy.mybaseapp.util.LogUtils;
import com.orhanobut.logger.Logger;

import cn.jclick.httpwrapper.callback.MyCallBack;


public class HomeFragment extends Fragment {

    private TextView homeTv;
    CoordinatorLayout container;
    private View mViewContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mViewContent == null) {
            mViewContent = inflater.inflate(R.layout.fragment_home, container, false);
        }
        // 缓存View判断是否含有parent, 如果有需要从parent删除, 否则发生已有parent的错误.
        ViewGroup parent = (ViewGroup) mViewContent.getParent();
        if (parent != null) {
            parent.removeView(mViewContent);
        }
        return mViewContent;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        container = (CoordinatorLayout) view.findViewById(R.id.container);
        homeTv = (TextView) view.findViewById(R.id.home_tv);
        homeTv.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(final View v) {
                                          AppDao.getInstance().fuck(new MyCallBack<User>(getActivity(), new TypeReference<User>() {
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
                                  }


        );
    }

}
