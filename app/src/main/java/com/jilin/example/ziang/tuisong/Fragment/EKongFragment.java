package com.jilin.example.ziang.tuisong.Fragment;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import com.jilin.example.ziang.tuisong.Adapter.EKongAdapter;
import com.jilin.example.ziang.tuisong.Adapter.LoadMoreAdapter;
import com.jilin.example.ziang.tuisong.Bean.EKongPage;
import com.jilin.example.ziang.tuisong.Bean.EKongPerson;
import com.jilin.example.ziang.tuisong.Bean.EKongPersonInfos;
import com.jilin.example.ziang.tuisong.Bean.EKongPersons;
import com.jilin.example.ziang.tuisong.Bean.SosBean;
import com.jilin.example.ziang.tuisong.Bean.SosNewBean;
import com.jilin.example.ziang.tuisong.Bean.ZYMessage;
import com.jilin.example.ziang.tuisong.Constant;
import com.jilin.example.ziang.tuisong.CustomToast;
import com.jilin.example.ziang.tuisong.DetainRoot;
import com.jilin.example.ziang.tuisong.R;
import com.jilin.example.ziang.tuisong.TjApp;
import com.jilin.example.ziang.tuisong.UserService;
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
public class EKongFragment extends Fragment implements Callback<String>, View.OnClickListener, LoadMoreAdapter.LoadMoreApi, BGARefreshLayout.BGARefreshLayoutDelegate {

    public static EKongFragment instance = null;
    private List<EKongPersonInfos> mMessages;
    private EKongAdapter mAdapter;
    private LoadMoreAdapter mLoadMoreAdapter;
    private int page = 1;
    private EKongPage mPage;

    private String token;
    private String filter = "";
    private int pageSize = 5;
    private int mNetType;
    private ZYMessage mZyMessage;
    public static final String TABLENAME = "adm_comparing_info";
    public String tableId;
    private TextView tv_item_person_attention;
    private int position;
    private List<EKongPersonInfos> rows;
    private IntentFilter intentFilter;
    private LocalReceiver localReceiver;
    private RecyclerView mRlEkongTicket;
    private BGARefreshLayout mBgaEkongTicket;

    public static EKongFragment getInstance() {
        if (instance == null) {
            instance = new EKongFragment();
        }
        return instance;
    }

    public EKongFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ekong, container, false);
        initView(view);
        initData();
        initRefreshLayout();
        //人员服务开启之后启动
//        SosBean userInfo = UserService.getUserInfo(getActivity());
//        String identifier = userInfo.getIdentifier();
//        filter = "bkmj=" + identifier;
        getData(filter, pageSize, 1);
        return view;
    }
    private void initView(View view) {
        mRlEkongTicket = (RecyclerView) view.findViewById(R.id.rl_ekong_ticket);
        mBgaEkongTicket = (BGARefreshLayout) view.findViewById(R.id.bga_ekong_ticket);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }


    private void getData(String filter, int pageSize, int page) {
        mNetType = 2;
        TjApp.getRetrofit().getEKongInfos(filter, pageSize, page).enqueue(this);
    }

    private void initData() {
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.anrongtec.focus");
        localReceiver = new LocalReceiver();
        //注册本地接收器
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(localReceiver, intentFilter);

        mMessages = new ArrayList<>();
        mAdapter = new EKongAdapter(mMessages, getActivity(), this);
        mLoadMoreAdapter = new LoadMoreAdapter(getActivity(), mAdapter);
        mLoadMoreAdapter.setLoadMoreListener(this);
        mRlEkongTicket.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRlEkongTicket.setAdapter(mLoadMoreAdapter);


    }



    private class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            SosBean userInfo = UserService.getUserInfo(getActivity());
            mMessages.clear();
            page = 1;
            String code = userInfo.getCode();
            filter = "";
            getData(filter, pageSize, 1);
        }
    }


    private void initRefreshLayout() {
        // 为BGARefreshLayout 设置代理
        mBgaEkongTicket.setDelegate(this);
        BGAMeiTuanRefreshViewHolder meiTuanRefreshViewHolder = new BGAMeiTuanRefreshViewHolder(getActivity(), true);
        meiTuanRefreshViewHolder.setPullDownImageResource(R.mipmap.bga_refresh_mt_pull_down);
        meiTuanRefreshViewHolder.setChangeToReleaseRefreshAnimResId(R.drawable.bga_refresh_mt_change_to_release_refresh);
        meiTuanRefreshViewHolder.setRefreshingAnimResId(R.drawable.bga_refresh_mt_refreshing);
        mBgaEkongTicket.setRefreshViewHolder(meiTuanRefreshViewHolder);
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        page = 1;
        mMessages.clear();
        getData(filter, pageSize, page);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onClick(View view) {
        position = (int) view.getTag();
        EKongPersonInfos message = mMessages.get(position);
        tv_item_person_attention = view.findViewById(R.id.tv_item_person_attention);
        switch (view.getId()) {
            case R.id.rl_item_msg://跳转到重点人员信息的点击事件
                Intent intent = new Intent(getActivity(), ZyMessageActivity.class);
                intent.setFlags(4);
                intent.putExtra(Constant.PUSH_DATA, message);
                startActivity(intent);
                break;
            case R.id.ll_focus_people_attention:
                tableId = String.valueOf(message.getId());
                getDetain();
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
            mBgaEkongTicket.endRefreshing();
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
                mMessages.get(position).setStatus(2);
                mLoadMoreAdapter.loadCompleted();
                mBgaEkongTicket.endRefreshing();

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
                EKongPersons messageInfos = GsonUtil.parseJsonWithGson(data, EKongPersons.class);
                EKongPerson messageInfo = messageInfos.getData();
                mPage = messageInfo.getPage();
                rows = messageInfo.getRows();
                if (rows != null) {
                    mMessages.addAll(messageInfo.getRows());
                }
                if (rows == null || rows.size() <= 0) {
                    if (mBgaEkongTicket != null) {
                        mBgaEkongTicket.endRefreshing();
                    }
                    mLoadMoreAdapter.loadAllDataCompleted();
                    return;
                }
                mLoadMoreAdapter.loadCompleted();
                mBgaEkongTicket.endRefreshing();

            }
        }
    }

    @Override
    public void loadMore() {
        if (page < mPage.getTotalPage()) {
            page += 1;
            getData(filter, pageSize, page);
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
}

