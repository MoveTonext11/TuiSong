package com.jilin.example.ziang.tuisong.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jilin.example.ziang.tuisong.Adapter.LoadMoreAdapter;
import com.jilin.example.ziang.tuisong.Adapter.MessageAdapter;
import com.jilin.example.ziang.tuisong.Bean.AdmComparingInfo;
import com.jilin.example.ziang.tuisong.Constant;
import com.jilin.example.ziang.tuisong.Fragment.CooperationFragment;
import com.jilin.example.ziang.tuisong.Fragment.EKongFragment;
import com.jilin.example.ziang.tuisong.R;

import java.util.List;

/**
 * @author huiliu
 * 我的关注 类
 */
public class EkongFocusActivity extends ToolBarActivity implements View.OnClickListener{

    private List<AdmComparingInfo> mMessages;
    private MessageAdapter mAdapter;
    private LoadMoreAdapter mLoadMoreAdapter;

    private static final String[] FRAGMENT_TAG = {"cooper", "ekong",};
    private int selindex = 0;

    private EKongFragment eKongFragment;//E控
    private CooperationFragment mCooperationFragment;//实名盾
    private TextView mTvMessageSearch;
    private TextView mTvCooperData;
    private LinearLayout mLlCooperData;
    private TextView mTvEkongData;
    private LinearLayout mLlEkongData;
    private FrameLayout mFrameContainer;
    private RecyclerView mViewBreakfastList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekong_focus);
        initView();

        //默认选择显示
        select(0);
        mTvCooperData.setTextColor(Color.WHITE);
        mLlCooperData.setBackgroundColor(Color.parseColor("#0ba5f4"));
        setRightImgGone(false);
    }
    private void initView() {
        mTvMessageSearch = (TextView) findViewById(R.id.tv_message_search);
        mTvCooperData = (TextView) findViewById(R.id.tv_cooper_data);
        mLlCooperData = (LinearLayout) findViewById(R.id.ll_cooper_data);
        mTvEkongData = (TextView) findViewById(R.id.tv_ekong_data);
        mLlEkongData = (LinearLayout) findViewById(R.id.ll_ekong_data);
        mFrameContainer = (FrameLayout) findViewById(R.id.frame_ekong_container);
        mViewBreakfastList = (RecyclerView) findViewById(R.id.view_breakfast_list);
        mLlCooperData.setOnClickListener(this);
        mLlEkongData.setOnClickListener(this);
        mTvMessageSearch.setOnClickListener(this);

    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Intent push = getIntent();
        if (push != null) {
            int intExtra = push.getIntExtra(Constant.PUSH_DATA, 0);
            switch (intExtra) {
                case 96:
                    resetImg();
                    mTvEkongData.setTextColor(Color.WHITE);
                    mLlEkongData.setBackgroundColor(Color.parseColor("#0ba5f4"));
                    select(3);
                    break;
                case 97:
                    resetImg();
                    mTvCooperData.setTextColor(Color.WHITE);
                    mLlCooperData.setBackgroundColor(Color.parseColor("#0ba5f4"));
                    select(2);
                    break;
                default:
                    resetImg();
                    mTvEkongData.setTextColor(Color.WHITE);
                    mLlEkongData.setBackgroundColor(Color.parseColor("#0ba5f4"));
                    select(0);
                    break;
            }

        }
    }

    private void select(int i) {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //隐藏所有fragment
        hideFragment(transaction);
        switch (i) {
            case 1:
                if (eKongFragment == null) {
                    eKongFragment = EKongFragment.getInstance();
                    transaction.add(R.id.frame_ekong_container, eKongFragment, FRAGMENT_TAG[1]);
                } else {
                    transaction.show(eKongFragment);
                }
                break;
            case 0:
                if (mCooperationFragment == null) {
                    mCooperationFragment = CooperationFragment.getInstance();
                    transaction.add(R.id.frame_ekong_container, mCooperationFragment, FRAGMENT_TAG[0]);
                } else {
                    transaction.show(mCooperationFragment);
                }
                break;
            default:
                break;

        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (eKongFragment != null) {
            transaction.hide(eKongFragment);
        }
        if (mCooperationFragment != null) {
            transaction.hide(mCooperationFragment);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 设置默认颜色
     * 点击进行重置所有填充颜色
     */
    private void resetImg() {
        mTvEkongData.setTextColor(Color.parseColor("#535353"));
        mTvCooperData.setTextColor(Color.parseColor("#535353"));
        mLlEkongData.setBackgroundColor(Color.WHITE);
        mLlCooperData.setBackgroundColor(Color.WHITE);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_ekong_data://e控
                resetImg();
                mTvEkongData.setTextColor(Color.WHITE);
                mLlEkongData.setBackgroundColor(Color.parseColor("#0ba5f4"));
                select(1);
                break;
            case R.id.ll_cooper_data://警辅核采
                resetImg();
                mTvCooperData.setTextColor(Color.WHITE);
                mLlCooperData.setBackgroundColor(Color.parseColor("#0ba5f4"));
                select(0);
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
