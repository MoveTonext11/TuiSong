package com.jilin.example.ziang.tuisong.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jilin.example.ziang.tuisong.Adapter.LoadMoreAdapter;
import com.jilin.example.ziang.tuisong.Adapter.MessageAdapter;
import com.jilin.example.ziang.tuisong.Bean.AdmComparingInfo;
import com.jilin.example.ziang.tuisong.Bean.MessageInfo;
import com.jilin.example.ziang.tuisong.Bean.MessageInfos;
import com.jilin.example.ziang.tuisong.Bean.SosBean;
import com.jilin.example.ziang.tuisong.Constant;
import com.jilin.example.ziang.tuisong.CustomToast;
import com.jilin.example.ziang.tuisong.DetainRoot;
import com.jilin.example.ziang.tuisong.Page;
import com.jilin.example.ziang.tuisong.R;
import com.jilin.example.ziang.tuisong.TjApp;
import com.jilin.example.ziang.tuisong.UserService;
import com.jilin.example.ziang.tuisong.Utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetainSearchActivity extends ToolBarActivity implements BGARefreshLayout.BGARefreshLayoutDelegate, View.OnClickListener, Callback<String>, LoadMoreAdapter.LoadMoreApi {

    @BindView(R.id.tv_search)
    EditText tvSearch;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.view_breakfast_list)
    RecyclerView viewBreakfastList;
    @BindView(R.id.rl_refresh)
    BGARefreshLayout rlRefresh;

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
    private String search_sfzh_xm;
    private List<AdmComparingInfo> rows;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detain_search);
        ButterKnife.bind(this);
        setRightImgGone(false);
        initRefreshLayout();
        initData();
    }


    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        toolbarTitle.setText("关注失控搜索");
    }

    @OnClick(R.id.btn_detain_wild_search)
    public void onViewClicked() {
        mMessages.clear();
        search_sfzh_xm = tvSearch.getText().toString();
        SosBean userInfo = UserService.getUserInfo(this);
        String code = userInfo.getCode();
        filter = "watch_user_code=" + code+"&keyword="+search_sfzh_xm;
        getData(filter, pageSize, 1);
    }

    private void getData(String filter, int pageSize, int page) {
        mNetType = 2;
        TjApp.getRetrofit().getSearchFocusand(filter, pageSize, page).enqueue(this);
    }

    private void initData() {
        mMessages = new ArrayList<>();
        mAdapter = new MessageAdapter(mMessages, this, this);
        mLoadMoreAdapter = new LoadMoreAdapter(this, mAdapter);
        mLoadMoreAdapter.setLoadMoreListener(this);
        viewBreakfastList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        viewBreakfastList.setAdapter(mLoadMoreAdapter);
    }


    private void initRefreshLayout() {
        // 为BGARefreshLayout 设置代理
        rlRefresh.setDelegate(this);
        BGAMeiTuanRefreshViewHolder meiTuanRefreshViewHolder = new BGAMeiTuanRefreshViewHolder(this,true);
        meiTuanRefreshViewHolder.setPullDownImageResource(R.mipmap.bga_refresh_mt_pull_down);
        meiTuanRefreshViewHolder.setChangeToReleaseRefreshAnimResId(R.drawable.bga_refresh_mt_change_to_release_refresh);
        meiTuanRefreshViewHolder.setRefreshingAnimResId(R.drawable.bga_refresh_mt_refreshing);
        rlRefresh.setRefreshViewHolder(meiTuanRefreshViewHolder);
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
        AdmComparingInfo message = mMessages.get(position);
        tv_item_person_attention = view.findViewById(R.id.tv_item_person_attention);
        switch (view.getId()) {
            case R.id.rl_item_msg:
                Intent intent = new Intent(this, ZyMessageActivity.class);
                intent.setFlags(2);
                intent.putExtra(Constant.PUSH_DATA, message);
                startActivity(intent);
                break;
            case R.id.ll_focus_people_attention:
                tableId = String.valueOf(message.getId());
//                favoriteItem();
                getDetain();
                break;
            default:
                break;
        }
    }


    /**
     * 扣留人员
     */
    private void getDetain() {
        mNetType = 1;
        SosBean userInfo = UserService.getUserInfo(this);
        String code = userInfo.getCode();
        TjApp.getRetrofit().getDetain(tableId, "2", code).enqueue(this);
    }

    /**
     * 收藏人员
     */
    private void favoriteItem() {
        mNetType = 1;
        SosBean userInfo = UserService.getUserInfo(this);
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
            rlRefresh.endRefreshing();
            mLoadMoreAdapter.loadAllDataCompleted();
            CustomToast.INSTANCE.showToast(this, "服务器异常" + response.code());
        }
    }


    @Override
    public void onFailure(Call<String> call, Throwable t) {
        CustomToast.INSTANCE.showToast(this, "网络异常");
    }


    @SuppressLint("HandlerLeak")
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==998){
                mMessages.get(position).setStatus("2");
                mLoadMoreAdapter.loadCompleted();
                rlRefresh.endRefreshing();
                Intent intent=new Intent("com.anrongtec.focus");
                LocalBroadcastManager.getInstance(DetainSearchActivity.this).sendBroadcast(intent);
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
                    CustomToast.INSTANCE.showToast(this, detainRoot.getMsg());
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
                    rlRefresh.endRefreshing();
                    mLoadMoreAdapter.loadAllDataCompleted();
                    return;
                }
                mLoadMoreAdapter.loadCompleted();
                rlRefresh.endRefreshing();

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





}
