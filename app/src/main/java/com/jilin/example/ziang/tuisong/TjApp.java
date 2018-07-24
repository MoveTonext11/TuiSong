package com.jilin.example.ziang.tuisong;

import android.app.Application;
import android.content.Context;

import com.jilin.example.ziang.tuisong.Utils.LiteOrmDBUtil;
import com.jilin.example.ziang.tuisong.Utils.LogUtil;


/**
 * @author huiliu
 * @date 2017/11/15
 * @email liu594545591@126.com
 * @introduce
 */
public class TjApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        DataLayer.init(this);

        //数据库初始化
        initOrmLite();


    }


    /**
     * 初始化数据库
     */
    private void initOrmLite() {
        boolean cascadeDB = LiteOrmDBUtil.createCascadeDB(this);
        if (cascadeDB) {
            LogUtil.d("创建数据库成功");
        }
    }

    public static NetInterface getRetrofit() {
        return ApiServiceFactory.getApi();
    }

    public static Context getContext() {
        return context;
    }

    /**
     * 程序退出的时候 调用这个方法
     */
    @Override
    public void onTerminate() {
        super.onTerminate();

    }

    /**
     * 当程序运行内存不足的时候就会回调这个方法
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


}

