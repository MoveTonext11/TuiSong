package com.jilin.example.ziang.tuisong.Fragment;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jilin.example.ziang.tuisong.Activity.ZyMessageActivity;
import com.jilin.example.ziang.tuisong.Adapter.LoadMoreAdapter;
import com.jilin.example.ziang.tuisong.Adapter.MessageAdapter;
import com.jilin.example.ziang.tuisong.Bean.AdmComparingInfo;
import com.jilin.example.ziang.tuisong.Bean.MessageInfo;
import com.jilin.example.ziang.tuisong.Bean.MessageInfos;
import com.jilin.example.ziang.tuisong.Bean.SosBean;
import com.jilin.example.ziang.tuisong.Bean.SosNewBean;
import com.jilin.example.ziang.tuisong.Constant;
import com.jilin.example.ziang.tuisong.CustomToast;
import com.jilin.example.ziang.tuisong.DetainRoot;
import com.jilin.example.ziang.tuisong.Page;
import com.jilin.example.ziang.tuisong.R;
import com.jilin.example.ziang.tuisong.TjApp;
import com.jilin.example.ziang.tuisong.UserService;
import com.jilin.example.ziang.tuisong.Utils.DialogUtil;
import com.jilin.example.ziang.tuisong.Utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @author huiliu
 */
public class EnterFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate, View.OnClickListener, Callback<String>, LoadMoreAdapter.LoadMoreApi {

    private static EnterFragment instance = null;
    private List<AdmComparingInfo> mMessages;
    private MessageAdapter mAdapter;
    private LoadMoreAdapter mLoadMoreAdapter;
    private int page = 1;
    private Page mPage;

    private String token;
    private String filter = "";
    private int pageSize = 5;
    private int mNetType;
    public static final String TABLENAME = "adm_comparing_info";
    public String tableId;
    private TextView tv_item_person_attention;
    private int position;
    private List<AdmComparingInfo> rows;
    private IntentFilter intentFilter;
    private LocalReceiver localReceiver;
    private RecyclerView mViewBreakfastList;
    private BGARefreshLayout mRefreshLayout;


    public static EnterFragment getInstance() {
        if (instance == null) {
            instance = new EnterFragment();
        }
        return instance;
    }

    public EnterFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_focus, container, false);
        initView(view);
        initData();
        initRefreshLayout();
        //正式版里面添加用户信息，获取用户信息来查询数据
//        SosBean userInfo = UserService.getUserInfo(getActivity());
//        String code = userInfo.getCode();
//        filter = "watch_user_code=" + code;
        getData("", filter, pageSize, 1);

        return view;
    }

    private void initView(View view) {
        mViewBreakfastList = (RecyclerView) view.findViewById(R.id.view_breakfast_list);
        mRefreshLayout = (BGARefreshLayout) view.findViewById(R.id.rl_refresh);
    }
    public void getData(String token, String filter, int pageSize, int page) {
        mNetType = 2;
        TjApp.getRetrofit().getMessageInfos(filter, pageSize, page).enqueue(this);
    }

    private void initData() {
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.anrongtec.focus");
        localReceiver = new LocalReceiver();
        //注册本地接收器
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(localReceiver, intentFilter);

        mMessages = new ArrayList<>();
        mAdapter = new MessageAdapter(mMessages, getActivity());
        mLoadMoreAdapter = new LoadMoreAdapter(getActivity(), mAdapter);
        mLoadMoreAdapter.setLoadMoreListener(this);
        mViewBreakfastList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mViewBreakfastList.setAdapter(mLoadMoreAdapter);


    }



    private class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            SosBean userInfo = UserService.getUserInfo(getActivity());
            mMessages.clear();
            page = 1;
            String code = userInfo.getCode();
            filter = "watch_user_code=" + code;
            getData("", filter, pageSize, 1);
        }
    }


    private void initRefreshLayout() {
        // 为BGARefreshLayout 设置代理
        mRefreshLayout.setDelegate(this);
        BGAMeiTuanRefreshViewHolder meiTuanRefreshViewHolder = new BGAMeiTuanRefreshViewHolder(getActivity(), true);
        meiTuanRefreshViewHolder.setPullDownImageResource(R.mipmap.bga_refresh_mt_pull_down);
        meiTuanRefreshViewHolder.setChangeToReleaseRefreshAnimResId(R.drawable.bga_refresh_mt_change_to_release_refresh);
        meiTuanRefreshViewHolder.setRefreshingAnimResId(R.drawable.bga_refresh_mt_refreshing);
        mRefreshLayout.setRefreshViewHolder(meiTuanRefreshViewHolder);
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        page = 1;
        mMessages.clear();
        getData(token, filter, pageSize, page);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onClick(View view) {
        position = (int) view.getTag();
        AdmComparingInfo message = mMessages.get(position);
        tv_item_person_attention = view.findViewById(R.id.tv_item_person_attention);
        switch (view.getId()) {
            case R.id.rl_item_msg://重点关注条目点击事件 2
                Intent intent = new Intent(getActivity(), ZyMessageActivity.class);
                intent.setFlags(2);
                intent.putExtra(Constant.PUSH_DATA, message);
                startActivity(intent);
                break;
            case R.id.ll_focus_people_attention:
                toDetain(message);
                break;
            case R.id.ll_focus_people_deal:
                toZhiYu(message.getSfzh());
            default:
                break;
        }
    }

    private void toZhiYu(String id) {
        SosNewBean userInfo = UserService.getNewUserInfo(getActivity());
        String userInfoName = userInfo.getName();
        String code = userInfo.getCode();
        Intent mIntent = new Intent();
        mIntent.putExtra("SYSTEM_USER_ID", code);//当前登录民警的警号
        mIntent.putExtra("SYSTEM_USER_NAME", userInfoName);//当前登录民警的姓名
        mIntent.putExtra("SFZH", id);//(被核查人员)身份证
        mIntent.putExtra("YWID", "2"); //你的业务ID
        mIntent.putExtra("YWKZZD1", ""); //你的业务扩展字段1
        mIntent.putExtra("YWKZZD2", ""); //你的业务扩展字段2
        mIntent.putExtra("YWKZZD3", ""); //你的业务扩展字段3
        mIntent.putExtra("YWKZZD4", ""); //你的业务扩展字段4
        mIntent.putExtra("YWKZZD5", ""); //你的业务扩展字段5
        mIntent.setAction("com.mosty.ydjw.xlpc.person.VIEW");
        startActivityForResult(mIntent, 10001);
    }


    private void toDetain(final AdmComparingInfo message) {
        DialogUtil.createTipDialog(getActivity(), "温馨提示", "确定要扣留此人", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tableId = String.valueOf(message.getId());
                getDetain();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }


    /**
     * 扣留人员
     */
    private void getDetain() {
        mNetType = 1;
        SosBean userInfo = UserService.getUserInfo(getActivity());
        String code = userInfo.getCode();
        TjApp.getRetrofit().getDetain(tableId, "2", code).enqueue(this);
    }

    /**
     * 收藏人员
     */
    private void favoriteItem() {
        mNetType = 1;
        SosBean userInfo = UserService.getUserInfo(getActivity());
        String code = userInfo.getCode();
        String name = userInfo.getName();
        TjApp.getRetrofit().favoriteItem(TABLENAME, tableId, "2", code, name).enqueue(this);
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        String data = response.body();
        if (response.isSuccessful()) {
            resolveData(data);
        } else {
            mRefreshLayout.endRefreshing();
            mLoadMoreAdapter.loadAllDataCompleted();
            CustomToast.INSTANCE.showToast(getActivity(), "服务器异常" + response.code());
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        CustomToast.INSTANCE.showToast(getActivity(), "网络异常");
    }


    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 998) {
                mMessages.get(position).setStatus("2");

                mLoadMoreAdapter.loadCompleted();
                mRefreshLayout.endRefreshing();

            }
        }
    };

    /**
     * 解析数据
     *
     * @param data
     */
    private void resolveData(String data) {
        if (mNetType == 1) {
            if (data != null) {
                DetainRoot detainRoot = GsonUtil.parseJsonWithGson(data, DetainRoot.class);
                if (detainRoot.getStatus() == 0) {
                    mHandler.sendEmptyMessage(998);
                } else {
                    CustomToast.INSTANCE.showToast(getActivity(), detainRoot.getMsg());
                }
            }
        } else if (mNetType == 2) {
            if (data != null) {
                MessageInfos messageInfos = GsonUtil.parseJsonWithGson(data, MessageInfos.class);
                MessageInfo messageInfo = messageInfos.getData();
                mPage = messageInfo.getPage();
                rows = messageInfo.getRows();
                if (rows != null) {
                    mMessages.addAll(messageInfo.getRows());
                }
                if (rows == null || rows.size() <= 0) {
                    mRefreshLayout.endRefreshing();
                    mLoadMoreAdapter.loadAllDataCompleted();
                    return;
                }
                mLoadMoreAdapter.loadCompleted();
                mRefreshLayout.endRefreshing();
            }
        }
    }

    @Override
    public void loadMore() {
        if (page < mPage.getTotalPage()) {
            page += 1;
            getData(token, filter, pageSize, page);
        } else {
            Handler handler = new Handler();
            final Runnable r = new Runnable() {
                @Override
                public void run() {
                    mLoadMoreAdapter.loadAllDataCompleted();
                }
            };
            handler.post(r);

        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(localReceiver);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (10000 == requestCode || 10001 == requestCode) {
            //调用成功。。

        }
    }
}
