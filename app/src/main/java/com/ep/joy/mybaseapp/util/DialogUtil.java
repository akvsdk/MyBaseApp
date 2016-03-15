package com.ep.joy.mybaseapp.util;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

public final class DialogUtil {
    private static MaterialDialog progressDialog;

    private DialogUtil() {
    }

    public static void showProgressDialog(Context context) {
        showProgressDialog(context, "Loading");
    }

    public static void showProgressDialog(Context context, int resourceId) {
        showProgressDialog(context, context.getString(resourceId));
    }

    public static void showProgressDialog(Context context, String message) {
        if (progressDialog != null) {
            progressDialog.setContent(message);
            return;
        }
        progressDialog
                = new MaterialDialog.Builder(context)
                .content(message)
                .cancelable(false)
                .progress(true, 0)
                .show();
    }

    public static void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        progressDialog = null;
    }
}