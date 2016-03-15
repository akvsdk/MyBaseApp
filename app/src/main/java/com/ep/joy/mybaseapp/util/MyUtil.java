package com.ep.joy.mybaseapp.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ep.joy.mybaseapp.R;

/**
 * author   Joy
 * Date:  2016/3/4.
 * version:  V1.0
 * Description:
 */
public class MyUtil {

    public static void ShowImage(Context mtx, ImageView imageView, String imgUrl) {

        Glide.with(mtx).load(imgUrl).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView);

    }


}
