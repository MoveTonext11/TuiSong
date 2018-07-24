package com.jilin.example.ziang.tuisong.Utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;


/**
 * 各种dialog
 *
 * @author dongtianhao
 */
public class DialogUtil {

    /**
     * 提示框
     */
    public static Dialog createTipDialog(Context context, String title, String message,
                                         DialogInterface.OnClickListener linister,
                                         DialogInterface.OnClickListener onCancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title).setMessage(message).setPositiveButton("确定", linister)
                .setNegativeButton("取消", onCancelListener);
        Dialog dialog = builder.create();
        builder.show();
        return dialog;

    }
}
