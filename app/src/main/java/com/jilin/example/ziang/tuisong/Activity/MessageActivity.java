package com.jilin.example.ziang.tuisong.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jilin.example.ziang.tuisong.Adapter.LoadMoreAdapter;
import com.jilin.example.ziang.tuisong.Adapter.MessageAdapter;
import com.jilin.example.ziang.tuisong.Bean.AdmComparingInfo;
import com.jilin.example.ziang.tuisong.Bean.SosBean;
import com.jilin.example.ziang.tuisong.Bean.ZYMessage;
import com.jilin.example.ziang.tuisong.Constant;
import com.jilin.example.ziang.tuisong.Fragment.BuyFragment;
import com.jilin.example.ziang.tuisong.Fragment.EnterFragment;
import com.jilin.example.ziang.tuisong.Page;
import com.jilin.example.ziang.tuisong.R;
import com.jilin.example.ziang.tuisong.UserService;

import java.util.List;


/**
 * @author liuhui
 * 重点关注
 */
public class MessageActivity extends ToolBarActivity implements View.OnClickListener{

    private List<AdmComparingInfo> mMessages;
    private MessageAdapter mAdapter;
    private LoadMoreAdapter mLoadMoreAdapter;
    private int page = 1;
    private Page mPage;

    private String token;
    private String filter = "";
    private int pageSize = 5;
    private int mNetType;
    private ZYMessage mZyMessage;
    public static final String TABLENAME = "adm_comparing_info";
    public String tableId;
    private static final String PRV_SELINDEX = "PREV_SELINDEX";
    private static final String[] FRAGMENT_TAG = {"focus", "wild"};
    private int selindex = 0;

    private EnterFragment mEnterFragment;//进站
    private BuyFragment mBuyFragment;//购票
    private TextView tvMessageSearch;
    private TextView tvFocusData;
    private LinearLayout llFocusData;
    private TextView tvWildData;
    private LinearLayout llWildData;
    private FrameLayout frame_container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        initView();

//        initFragment(savedInstanceState);
        //默认选择
        select(0);
        if (tvFocusData != null && llFocusData != null) {
            tvFocusData.setTextColor(Color.WHITE);
            llFocusData.setBackgroundColor(Color.parseColor("#0ba5f4"));
        }
        setRightImgGone(false);
    }
    private void initView() {
        tvMessageSearch = (TextView) findViewById(R.id.tv_message_search);
        tvFocusData = (TextView) findViewById(R.id.tv_focus_data);
        llFocusData = (LinearLayout) findViewById(R.id.ll_focus_data);
        tvWildData = (TextView) findViewById(R.id.tv_wild_data);
        llWildData = (LinearLayout) findViewById(R.id.ll_wild_data);
        frame_container = (FrameLayout) findViewById(R.id.frame_container);
        llFocusData.setOnClickListener(this);
        llWildData.setOnClickListener(this);
        tvMessageSearch.setOnClickListener(this);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Intent push = getIntent();
        SosBean userInfo = UserService.getUserInfo(this);
        String code = userInfo.getCode();
        filter = "watch_user_code=" + code;
        if (push != null) {
            int intExtra = push.getIntExtra(Constant.PUSH_DATA, 0);
            switch (intExtra) {
                case 98:
                    resetImg();
                    tvWildData.setTextColor(Color.parseColor("#0ba5f4"));
                    select(1);
                    mBuyFragment.getData(filter, 5, 1);
                    break;
                case 99:
                    resetImg();
                    tvFocusData.setTextColor(Color.parseColor("#0ba5f4"));
                    select(0);
                    mEnterFragment.getData("", filter, 5, 1);
                    break;
                default:
                    resetImg();
                    tvFocusData.setTextColor(Color.parseColor("#0ba5f4"));
                    mEnterFragment.getData("", filter, 5, 1);
                    select(0);
                    break;
            }

        }
    }

    private void initFragment(Bundle savedInstanceState) {
        FragmentManager sfm = getSupportFragmentManager();
        if (savedInstanceState != null) {
            //读取上一次界面Save的时候tab选中的状态
            selindex = savedInstanceState.getInt(PRV_SELINDEX, selindex);
            mEnterFragment = (EnterFragment) sfm.findFragmentByTag(FRAGMENT_TAG[0]);
            mBuyFragment = (BuyFragment) sfm.findFragmentByTag(FRAGMENT_TAG[1]);
        } else {
            select(selindex);
        }
    }

    private void select(int i) {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //隐藏所有fragment
        hideFragment(transaction);
        switch (i) {
            case 0:
                //初始化fragment并添加到事务中，如果为null就new一个
                if (mEnterFragment == null) {
                    mEnterFragment = EnterFragment.getInstance();
                    transaction.add(R.id.frame_container, mEnterFragment, FRAGMENT_TAG[0]);
                } else {
                    //显示需要显示的fragment
                    transaction.show(mEnterFragment);
                }
                break;
            case 1:
                if (mBuyFragment == null) {
                    mBuyFragment = BuyFragment.getInstance();
                    transaction.add(R.id.frame_container, mBuyFragment, FRAGMENT_TAG[1]);
                } else {
                    transaction.show(mBuyFragment);
                }
                break;
            default:
                break;

        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mEnterFragment != null) {
            transaction.hide(mEnterFragment);
        }
        if (mBuyFragment != null) {
            transaction.hide(mBuyFragment);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void resetImg() {
        tvFocusData.setTextColor(Color.parseColor("#535353"));
        tvWildData.setTextColor(Color.parseColor("#535353"));
        llFocusData.setBackgroundColor(Color.WHITE);
        llWildData.setBackgroundColor(Color.WHITE);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_focus_data:
                resetImg();
                tvFocusData.setTextColor(Color.WHITE);
                llFocusData.setBackgroundColor(Color.parseColor("#0ba5f4"));
                select(0);
                break;
            case R.id.ll_wild_data:
                resetImg();
                tvWildData.setTextColor(Color.WHITE);
                llWildData.setBackgroundColor(Color.parseColor("#0ba5f4"));
                select(1);
                break;
            case R.id.tv_message_search:
                //关注和失控详情页
                startActivity(new Intent(this, DetainSearchActivity.class));
                break;
            default:
                break;
        }
    }
}
