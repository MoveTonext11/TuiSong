package com.jilin.example.ziang.tuisong;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 工厂, 提供 ApiService 对象
 * @author Berial
 * @date 16/8/18
 */
public final class ApiServiceFactory {
//        public static final String HOST = "http://20.3.2.47:8091";//测试环境
        public static final String HOST = "http://192.168.1.237:8080";//内部接口测试
//    public static final String HOST = "http://20.3.2.47:8080";//正式环境
    public static final String UPDATE_HOST = "http://20.3.2.44:9086";//一键升级接口
    public static final String BASE_URL = HOST + "/dcojp-api/";
    public static final String BASE_IMG_URL = "http://";

    private final NetInterface mApiService;

    private ApiServiceFactory() {
        Retrofit mRetrofit = new Retrofit.Builder()
                //添加网络请求的基地址
                .baseUrl(HOST)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //添加转换工厂，用于解析json并转化为javaBean
                .addConverterFactory(GsonConverterFactory.create())
                .client(DataLayer.getClient())
                .build();
        mApiService = mRetrofit.create(NetInterface.class);
    }

    private static class ApiServiceFactoryHolder {
        private static final ApiServiceFactory INSTANCE = new ApiServiceFactory();
    }

    /**
     * 获取 ApiService 对象
     * @return Api 接口对象
     */
    public static NetInterface getApi() {
        return ApiServiceFactoryHolder.INSTANCE.mApiService;
    }


}
