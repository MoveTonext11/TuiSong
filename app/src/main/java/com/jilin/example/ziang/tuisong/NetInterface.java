package com.jilin.example.ziang.tuisong;


import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/6/17.
 *
 * @email liu594545591@126.com
 * @introduce
 */
public interface NetInterface {
    //@GET 代表发送的GET请求
    //article/list/text?page=1 请求的路径(并且加上了基地址)
    //Call<T> 代表返回值的类型，ResponseBody 是Retrofit的原生的返回值
    @GET("article/list/text?page=1")
    Call<ResponseBody> getNetData();

    /**
     * 可以通过Retrofit 直接去解析获取到的json 得到的数据可以直接开始使用
     * TestModle 是gson生成的实体类
     *
     * @return
     */
    @GET("article/list/text?page=1")
    Call<ResponseBody> getNetModle();

    /**
     * 如果是get请求的参数 必须是加了@Field("page") 这个注解 括号里面试服务器接收的参数名字
     * 必须和服务器保持统一
     *
     * @param page
     * @return
     */
    @GET("article/list/text?")
    Call<ResponseBody> getNetModleWithParams(@Field("page") String page);

    /**
     * 动态替换地址
     * 需要替换的地址必须要用"{}"包裹起来，然后通过@path 来声明需要替换的参数
     *
     * @param contents
     * @return
     */
    @GET("article/list/{content}?page=1")
    Call<ResponseBody> getNetModleWithPath(@Path("content") String contents);

    @GET("article/{name}/text?")
    Call<ResponseBody> getNetModlePathWithParams(@Path("name") String list,
                                                 @Field("page") String path);

    /**
     * 通过map传递多个参数
     *
     * @param map
     * @return
     */
    @GET("article/list/text?")
    Call<ResponseBody> getNetModleWithMap(@FieldMap Map<String, String> map);

//-----------------------------------------------------------------------------------------------

    /**
     * 获取token
     *
     * @return
     */
    @FormUrlEncoded
    @POST("Login/getToken.do")
    Call<String> getToken(@Field("username") String username,
                          @Field("pwd") String pwd);

    /**
     * 获取待办公文
     *
     * @return
     */
    @FormUrlEncoded
    @POST("ajax/getDocDataCs.do")
    Call<String> getDocuments(@Field("Comm") String Comm,
                              @Field("token") String token);

    /**
     * @return
     */
    @FormUrlEncoded
    @POST("dcojp-api/ajax/checkToken.do")
    Call<String> getUserInfo(@Field("filters") String strToken);

    /**
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/checkTokenData.do")
    Call<String> getNewUserInfo(@Field("filters") String strToken);

    /**
     * 获取已读重点人消息
     *
     * @param strToken
     * @param filters
     * @param messId
     * @param pageSize
     * @param page
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/MessageRecord/pageList.do")
    Call<String> getMessageInfo(@Field("token") String strToken,
                                @Field("filters") String filters,
                                @Field("result_id") String messId,
                                @Field("pageSize") int pageSize,
                                @Field("page") int page);

    /**
     * 获取进站重点人消息
     * @param filters
     * @param pageSize
     * @param page
     * @return @POST("/dcojp-api/MessageRecord/pageListJl.do")
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/selectComparingInfo.do")
    Call<String> getMessageInfos(@Field("filters") String filters,
                                 @Field("pageSize") int pageSize,
                                 @Field("page") int page);

    /**
     * 获取购票重点人消息
     *
     * @param filters
     * @param pageSize
     * @param page
     * @return @POST("/dcojp-api/MessageRecord/pageListJl.do")
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/selectTicketInfo.do")
    Call<String> getMessageTicketInfos(@Field("filters") String filters,
                                       @Field("pageSize") int pageSize,
                                       @Field("page") int page);

    /**
     * 获取E控重点人消息
     *
     * @param filters
     * @param pageSize
     * @param page
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/selectTdekInfo.do")
    Call<String> getEKongInfos(@Field("filters") String filters,
                               @Field("pageSize") int pageSize,
                               @Field("page") int page);

    /**
     * 获取警辅核采重点人消息
     *
     * @param filters
     * @param pageSize
     * @param page
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax//selectHlwDbInfo.do")
    Call<String> getCooperInfos(@Field("filters") String filters,
                                @Field("pageSize") int pageSize,
                                @Field("page") int page);

    /**
     * 获取待办列表
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/commToDo.do")
    Call<String> getTodoList(@Field("filters") String filters);

    /**
     * 获取是否更新
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/commToDo.do")
    Call<String> getUpdate(@Field("filters") String filters);

    /**
     * 收藏关注人员
     *
     * @param tableName
     * @param tableId
     * @param type
     * @param watchUserCode
     * @param watchUserName
     * @return
     */
    @FormUrlEncoded
    @POST("dcojp-api/ajax/saveWatch.do")
    Call<String> favoriteItem(@Field("tableName") String tableName,
                              @Field("tableId") String tableId,
                              @Field("type") String type,
                              @Field("watchUserCode") String watchUserCode,
                              @Field("watchUserName") String watchUserName
    );

    /**
     * 获取收藏列表
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/selectWatch.do")
    Call<String> getCollect(@Field("filters") String filters,
                            @Field("pageSize") int pageSize,
                            @Field("page") int page);

    /**
     * 上传位置信息
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/insertPoliceGps.do")
    Call<String> uploadLocation(@Field("filters") String filters);

    /**
     * 获取警员位置
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/findPoliceGps.do")
    Call<String> getLocation(@Field("filters") String filters);

    /**
     * 获取单位名称
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/selectOrgStruct.do")
    Call<String> getDeptCode(@Field("filters") String filters);

    /**
     * 获取在线时长 任务数量
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/addLoginOtherData.do")
    Call<String> getThirdSqlData(@Field("filters") String filters);

    /**
     * 获取单位名称、天气、个人状态
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/addLoginLocalData.do")
    Call<String> getServerLocalData(@Field("filters") String filters);

    /**
     * 检查版本更新
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/selectNewest.do")
    Call<String> getVersionUpdate(@Field("filters") String filters);

    /**
     * 检查版本更新
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/selectLimitCar.do")
    Call<String> getVRestrictCarNumber(@Field("filters") String filters);

    /**
     * 扣留接口
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/updateComparingInfo.do")
    Call<String> getDetain(@Field("id") String id,
                           @Field("status") String status,
                           @Field("updatorId") String updatorId);

    /**
     * 上传头像
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/savePolicePhoto.do")
    Call<String> uploadPhoto(@Field("filters") String filters);

    /**
     * 修改人员状态
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/changePoliceStatus.do")
    Call<String> changeState(@Field("filters") String filters);

    /**
     * 获取应用仓库升级信息
     * @param body
     * @return
     */

    @Headers({"url_name:pay"})
    @POST("/Update/update/http/api.do")
    Call<String> updataMessage(@Body RequestBody body);


    /**
     * 获取人员状态
     *
     * @param filters
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/findLoginPolice.do")
    Call<String> getPersonalState(@Field("filters") String filters);

    /**
     * 搜索关注与失控
     *
     * @param filters
     * @param pageSize
     * @param page
     * @return @POST("/dcojp-api/MessageRecord/pageListJl.do")
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/selectComparingInfo.do")
    Call<String> getSearchFocusand(@Field("filters") String filters,
                                   @Field("pageSize") int pageSize,
                                   @Field("page") int page);

    /**
     * 签到
     *
     * @param code
     * @param orgCode
     * @param clockInTime
     * @param clockOutTime
     * @param type
     * @param status
     * @param address
     * @param longitude
     * @param latitudinal
     * @param accuracy
     * @param note
     * @return
     * ,
     @Field("imei") String imei,
     @Field("versionName") String versionName,
     @Field("phoneType") String phoneType
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/addUserClockRecord.do")
    Call<String> addUserSign(@Field("code") String code,
                             @Field("orgCode") String orgCode,
                             @Field("orgName") String orgName,
                             @Field("name") String name,
                             @Field("identifier") String identifier,
                             @Field("clockInTime") String clockInTime,
                             @Field("clockOutTime") String clockOutTime,
                             @Field("type") int type,
                             @Field("status") int status,
                             @Field("address") String address,
                             @Field("longitude") String longitude,
                             @Field("latitudinal") String latitudinal,
                             @Field("accuracy") int accuracy,
                             @Field("note") String note);

    /**
     * 获取打卡明细
     *
     * @param code
     * @param page
     * @param pageSize
     * @param sort
     * @param order
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/selectClockRecord.do")
    Call<String> getSign(@Field("filters") String code,
                         @Field("page") int page,
                         @Field("pageSize") int pageSize,
                         @Field("sort") String sort,
                         @Field("order") String order);


    /**
     * 查询打卡天数
     *
     * @param code
     * @param page
     * @param pageSize
     * @param sort
     * @param order
     * @return
     */
    @FormUrlEncoded
    @POST("/dcojp-api/ajax/selectAttendanceList.do")
    Call<String> getPerSign(@Field("filters") String code,
                            @Field("page") int page,
                            @Field("pageSize") int pageSize,
                            @Field("sort") String sort,
                            @Field("order") String order);


}