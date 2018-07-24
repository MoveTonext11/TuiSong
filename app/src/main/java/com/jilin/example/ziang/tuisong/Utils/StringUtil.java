package com.jilin.example.ziang.tuisong.Utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串处理类
 *
 * @author huiliu
 * @date 2014年6月25日
 **/
public class StringUtil {

    /**
     * 判断字符串是否为空
     *
     * @param str 字符串
     * @return boolean true空，false 非空
     */
    public static boolean isBlank(String str) {
        if (str != null) {
            return "".equals(str.trim());
        }
        return true;
    }

    /**
     * 将时间戳转换为时间
     *
     * @param s
     * @return
     */
    public static String stampToTime(String s) {
        String res;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

}
