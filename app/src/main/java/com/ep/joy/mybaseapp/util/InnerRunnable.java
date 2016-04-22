package com.ep.joy.mybaseapp.util;

import android.view.View;

import com.ep.joy.mybaseapp.weight.LoadingLayout;

import java.lang.ref.WeakReference;

/**
 * author   Joy
 * Date:  2016/4/21.
 * version:  V1.0
 * Description:
 */
public class InnerRunnable  implements Runnable{
    WeakReference<LoadingLayout> mReference;

    public InnerRunnable(View loadinglayout) {
       this.mReference = new WeakReference<LoadingLayout>((LoadingLayout) loadinglayout);
    }

    @Override
    public void run() {
         if (mReference.get()!=null){
             mReference.get().showContent();
         }

    }
}
