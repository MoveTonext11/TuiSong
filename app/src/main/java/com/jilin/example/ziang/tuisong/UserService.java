package com.jilin.example.ziang.tuisong;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.jilin.example.ziang.tuisong.Bean.SosBean;
import com.jilin.example.ziang.tuisong.Bean.SosNewBean;
import com.jilin.example.ziang.tuisong.Utils.GsonUtil;


/**
 * @author huiliu
 * @date 2017/10/10
 * @email liu594545591@126.com
 * @introduce
 */
public class UserService {
    private static final String USER_INFO = "userInfo";
    private static final String STATE_INFO = "stateInfo";
    private static final String AUTO_LOGIN = "autoLogin";
    private static String ACTIVE = "active";


    /**
     * 存储用户信息
     *
     * @param user
     */
    public static void saveNewUserInfo(SosNewBean user) {
        if (user == null) {
            return;
        }
        String userJson = GsonUtil.parseBeanWithJson(user);
        SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil(TjApp.getContext(), Constant.SP_NAME);
        sharedPreferencesUtil.setData(USER_INFO, userJson);
    }
    /**
     * 获取用户信息
     *
     * @return
     */
    public static SosBean getUserInfo(Context context) {
        SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil(TjApp.getContext(), Constant.SP_NAME);
        String userJson = (String) sharedPreferencesUtil.getData(USER_INFO);
        if (TextUtils.isEmpty(userJson)) {
            return null;
        } else {
            Gson gson = new Gson();
            return gson.fromJson(userJson, SosBean.class);
        }
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public static SosNewBean getNewUserInfo(Context context) {
        SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil(TjApp.getContext(), Constant.SP_NAME);
        String userJson = (String) sharedPreferencesUtil.getData(USER_INFO);
        if (TextUtils.isEmpty(userJson)) {
            return null;
        } else {
            Gson gson = new Gson();
            return gson.fromJson(userJson, SosNewBean.class);
        }
    }

    /**
     * 获取激活状态
     *
     * @return
     */
    public static String getIsActive(Context context) {
        SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil(TjApp.getContext(), Constant.CHECK_IS_ACTIVE);
        return (String) sharedPreferencesUtil.getData(ACTIVE);
    }

    /***
     * 保存激活状态  0 激活 1未激活
     */
    public static void saveActive(String autoLogin) {
        SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil(TjApp.getContext(), Constant.CHECK_IS_ACTIVE);
        sharedPreferencesUtil.setData(ACTIVE, autoLogin);

    }

}