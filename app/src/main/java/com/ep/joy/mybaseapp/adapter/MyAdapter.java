package com.ep.joy.mybaseapp.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.ep.joy.mybaseapp.R;
import com.ep.joy.mybaseapp.entity.User;
import com.ep.joy.mybaseapp.util.MyUtil;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.internal.SuperViewHolder;

import java.util.List;

/**
 * author   Joy
 * Date:  2016/4/15.
 * version:  V1.0
 * Description:
 */
public class MyAdapter extends SuperAdapter<User.ListEntity> {
    private Context mContext;

    public MyAdapter(Context context, List<User.ListEntity> items, int layoutResId) {
        super(context, items, layoutResId);
        this.mContext = context;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int position, User.ListEntity item) {
        holder.setText(R.id.item_single_tv, item.getMacthName());
        String url = "http://img3.imgtn.bdimg.com/it/u=2790453178,2941744905&fm=23&gp=0.jpg";
        ImageView img = holder.getView(R.id.item_img);
        MyUtil.ShowImage(mContext, img, url);

    }
}
