package com.ep.joy.mybaseapp.adapter;

import android.content.Context;

import com.ep.joy.mybaseapp.R;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.internal.SuperViewHolder;

import java.util.List;

/**
 * author   Joy
 * Date:  2016/4/15.
 * version:  V1.0
 * Description:
 */
public class StringAdapter extends SuperAdapter<String> {
    public StringAdapter(Context context, List<String> items, int layoutResId) {
        super(context, items, layoutResId);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int position, String item) {
        holder.setText(R.id.item_single_tv, item);
    }
}
