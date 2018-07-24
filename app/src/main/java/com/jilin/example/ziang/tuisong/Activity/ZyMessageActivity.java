package com.jilin.example.ziang.tuisong.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.jilin.example.ziang.tuisong.Bean.AdmComparingInfo;
import com.jilin.example.ziang.tuisong.Utils.BitmapUtil;
import com.jilin.example.ziang.tuisong.Constant;
import com.jilin.example.ziang.tuisong.Bean.CooperPersonInfos;
import com.jilin.example.ziang.tuisong.CustomToast;
import com.jilin.example.ziang.tuisong.Bean.EKongPersonInfos;
import com.jilin.example.ziang.tuisong.Utils.GsonUtil;
import com.jilin.example.ziang.tuisong.Utils.LogUtil;
import com.jilin.example.ziang.tuisong.Bean.MessageInfo;
import com.jilin.example.ziang.tuisong.Bean.MessageInfos;
import com.jilin.example.ziang.tuisong.R;
import com.jilin.example.ziang.tuisong.Bean.SosNewBean;
import com.jilin.example.ziang.tuisong.Utils.StationUtil;
import com.jilin.example.ziang.tuisong.Utils.StringUtil;
import com.jilin.example.ziang.tuisong.TjApp;
import com.jilin.example.ziang.tuisong.UserService;
import com.jilin.example.ziang.tuisong.Bean.ZyPushMessage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author huiliu
 */
public class ZyMessageActivity extends ToolBarActivity implements Callback<String> {

    @BindView(R.id.tv_card_number)
    TextView mTvCardNumber;
    @BindView(R.id.tv_card_name)
    TextView mTvCardName;
    @BindView(R.id.tv_card_sex)
    TextView mTvCardSex;
    @BindView(R.id.tv_card_nation)
    TextView mTvCardNation;
    @BindView(R.id.tv_card_birthday)
    TextView mTvCardBirthday;
    @BindView(R.id.tv_card_original)
    TextView mTvCardOriginal;
    @BindView(R.id.card_photo)
    ImageView mCardPhoto;
    @BindView(R.id.textViewState)
    TextView mTextViewState;
    @BindView(R.id.tv_card_source)
    TextView mTvCardSource;
    @BindView(R.id.tv_card_rank)
    TextView mTvCardRank;
    @BindView(R.id.tv_card_origin)
    TextView mTvCardOrigin;
    @BindView(R.id.tv_copy_info)
    TextView mTvCopyInfo;
    @BindView(R.id.tv_card_police)
    TextView mTvCardPolice;
    @BindView(R.id.tv_card_police_phone)
    TextView mTvCardPolicePhone;
    @BindView(R.id.tv_card_police_location)
    TextView mTvCardPoliceLocation;
    @BindView(R.id.textView2)
    TextView mTextView2;
    @BindView(R.id.tv_station_number)
    TextView mTvStationNumber;
    @BindView(R.id.tv_station_train)
    TextView mTvStationTrain;
    @BindView(R.id.tv_station_destination)
    TextView mTvStationDestination;
    @BindView(R.id.tv_card_reason)
    TextView mTvCardReason;
    @BindView(R.id.tv_card_station_time)
    TextView mTvCardStationTime;
    @BindView(R.id.tv_card_compare_state)
    TextView mTvCardCompareState;
    @BindView(R.id.tv_card_receive_time)
    TextView mTvCardReceiveTime;
    @BindView(R.id.tv_rail_station)
    TextView mTvRailStation;
    @BindView(R.id.tv_destination)
    TextView mTvDestination;
    @BindView(R.id.ll_ticket_info)
    LinearLayout mLlTicketInfo;
    @BindView(R.id.tv_ticket_info)
    TextView mTvTicketInfo;
    @BindView(R.id.tv_card_collect_police)
    TextView mTvCardCollectPolice;
    @BindView(R.id.tv_card_collect_info)
    TextView mTvCardCollectInfo;
    private AdmComparingInfo mMessage;
    private EKongPersonInfos mPersonInfos;
    private CooperPersonInfos mCooperPersonInfos;
    private String mTitle;
    private String filter = "userId=111111";
    private int mFlags;
    private String mPersonXp;

    /**
     * 重点关注界面条目点击事件
     * @param msg
     */
    private void updateUi(AdmComparingInfo msg) {
        String s = msg.toString();
        LogUtil.e(s);
        mPersonXp = msg.getXp();
        if (BitmapUtil.stringtoBitmap(mPersonXp) != null) {
            mCardPhoto.setImageBitmap(BitmapUtil.stringtoBitmap(mPersonXp));
        } else {
            mCardPhoto.setImageResource(R.drawable.user_photo_icon);
        }
        if (mFlags == 2) {
            mTvCardNumber.setText(msg.getSfzh());
            mTvCardName.setText(msg.getXm());
            mTvCardSex.setText(msg.getXb());
            if ("1".equals(msg.getXb())) {
                mTvCardSex.setText("男");
            } else if ("2".equals(msg.getXm())) {
                mTvCardSex.setText("女");
            } else {
                mTvCardSex.setText("");
            }
            mTvCardOriginal.setText(msg.getSdfj());
            mTvCardRank.setText(msg.getLkdj());
            mTvCardReason.setText(msg.getSqxx());
            mTvCardOrigin.setText(msg.getSjly());

            mTvCardPolicePhone.setText(msg.getZrszlxdh());
            mTvCardPolice.setText(msg.getZrszxm());
            String srt = msg.getXxwb();

            //进站时间
            String rq = srt.substring(srt.lastIndexOf("于2") + 1, srt.lastIndexOf("在"));
            System.out.println("rq>>>>>>>>>>" + rq);
            String year = rq.substring(0, 4);
            String month = rq.substring(4, 6);
            String day = rq.substring(6, 8);
            String hour = rq.substring(8, 10);
            String minute = rq.substring(10, 12);
            String second = rq.substring(12, 14);
            //火车站
            String hcz = srt.substring(srt.lastIndexOf("在") + 1, srt.lastIndexOf("火车站"));
            System.out.println("hcz>>>>>>>>>>" + hcz);
            //检票口
            String jpk = srt.substring(srt.lastIndexOf("火车站") + 3, srt.lastIndexOf("检票口"));
            System.out.println("jpk>>>>>>>>>>" + jpk);
            //车次
            String cz = srt.substring(srt.lastIndexOf("乘坐") + 2, srt.lastIndexOf("列车"));
            System.out.println("cz>>>>>>>>>>" + cz);
            //目的地
            String qw = srt.substring(srt.lastIndexOf("前往") + 2);
            System.out.println("qw>>>>>>>>>>" + qw);
            mTvRailStation.setText("铁路时间(进站)");
            mTvCardStationTime.setText(year + "年" + month + "月" + day + "日" +
                    hour + "时" + minute + "分" + second + "秒");
            mTvCardStationTime.setText(msg.getJpsj());
            mTvCardCompareState.setText(msg.getRksj());
            long createTime = msg.getCreate_time();
            mTvCardReceiveTime.setText(String.valueOf(StringUtil.stampToTime(String.valueOf(createTime))));

            mTvStationNumber.setText(jpk);
            mTvStationTrain.setText(cz);
            mTvStationDestination.setText(StationUtil.getStation(qw));
//        mTvCardState.setText(msg.getBkrq());
        } else if (mFlags == 3) {
            mTvCardNumber.setText(msg.getSfzh());
            mTvCardName.setText(msg.getXm());
            mTvCardSex.setText(msg.getXb());
            if ("1".equals(msg.getXb())) {
                mTvCardSex.setText("男");
            } else if ("2".equals(msg.getXm())) {
                mTvCardSex.setText("女");
            } else {
                mTvCardSex.setText("");
            }
            mTvCardOriginal.setText(msg.getSdfj());
            mTvCardRank.setText(msg.getLkdj());
            mTvCardReason.setText(msg.getSqxx());
            mTvCardOrigin.setText(msg.getSjly());

            mTvCardPolicePhone.setText(msg.getZrszlxdh());
            mTvCardPolice.setText(msg.getZrszxm());
            String srt = msg.getXxwb();

            //买票时间
            String rq = "";
            if (srt.contains("于1")) {
                rq = srt.substring(srt.lastIndexOf("于1") + 1, srt.lastIndexOf("在"));
            } else if (srt.contains("于2")) {
                rq = srt.substring(srt.lastIndexOf("于2") + 1, srt.lastIndexOf("在"));
            }
            System.out.println("rq>>>>>>>>>>" + rq);
            String year = rq.substring(0, 4);
            String month = rq.substring(4, 6);
            String day = rq.substring(6, 8);
            String hour = rq.substring(8, 10);
            String minute = rq.substring(10, 12);
            String second = rq.substring(12, 14);
            //窗口
            String hcz = srt.substring(srt.lastIndexOf("在") + 1, srt.lastIndexOf("窗口"));
            System.out.println("hcz>>>>>>>>>>" + hcz);
            //车厢号
            String jpk = srt.substring(srt.lastIndexOf("车厢号为") + 4, srt.lastIndexOf("车厢号为") + 6);
            System.out.println("jpk>>>>>>>>>>" + jpk);
            //座位号
            String zwh = srt.substring(srt.lastIndexOf("座位号为") + 4, srt.lastIndexOf("座位号为") + 8);
            System.out.println("zwh>>>>>>>>>>" + zwh);
            //列车车次
            String lccc = srt.substring(srt.lastIndexOf("座位号为") + 9, srt.lastIndexOf("座位号为") + 14);
            System.out.println("lccc>>>>>>>>>>" + lccc);
            //目的地
            String qw = srt.substring(srt.lastIndexOf("前往") + 2);
            System.out.println("qw>>>>>>>>>>" + qw);
            mTvRailStation.setText("铁路时间(买票)");
            mTextView2.setText("车厢号");
            mTvDestination.setText("座位号");
            mTvCardStationTime.setText(year + "年" + month + "月" + day + "日" +
                    hour + "时" + minute + "分" + second + "秒");
            mTvCardStationTime.setText(msg.getBuytime());
            mTvCardCompareState.setText(msg.getRksj());
            long createTime = msg.getCreate_time();
            mTvCardReceiveTime.setText(String.valueOf(StringUtil.stampToTime(String.valueOf(createTime))));

            mTvStationNumber.setText(jpk);
            mTvStationTrain.setText(lccc);
            mTvStationDestination.setText(zwh);
        }
    }

    private void updateEKongUi(EKongPersonInfos personInfos) {

        mPersonXp = personInfos.getXp();
        if (BitmapUtil.stringtoBitmap(mPersonXp) != null) {
            mCardPhoto.setImageBitmap(BitmapUtil.stringtoBitmap(mPersonXp));
        } else {
            mCardPhoto.setImageResource(R.drawable.user_photo_icon);
        }
        mTvRailStation.setText("登记日期(巨龙)");
        String djrq = personInfos.getDjrq();
        String year = djrq.substring(0, 4);
        String month = djrq.substring(4, 6);
        String day = djrq.substring(6, 8);
        String hour = djrq.substring(8, 10);
        String minute = djrq.substring(10, 12);
        String seconds = djrq.substring(12, 14);

        String dt_matched = personInfos.getDt_matched();
        String myear = dt_matched.substring(0, 4);
        String mmonth = dt_matched.substring(4, 6);
        String mday = dt_matched.substring(6, 8);
        String mhour = dt_matched.substring(8, 10);
        String mminute = dt_matched.substring(10, 12);
        String mseconds = dt_matched.substring(12, 14);


        mTvCardNumber.setText(personInfos.getSfzh());
        mTvCardName.setText(personInfos.getXm());
        mTvCardRank.setText(personInfos.getBkyxjb());

        LogUtil.d(personInfos.toString());
        mTvCardStationTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + seconds);
        mTvCardCompareState.setText(myear + "-" + mmonth + "-" + mday + " " + mhour + ":" + mminute + ":" + mseconds);
        long createTime = personInfos.getCreate_time();
        mTvCardReceiveTime.setText(String.valueOf(StringUtil.stampToTime(String.valueOf(createTime))));

//        mTvCardOriginal.setText(personInfos.getsd());
//        mTvCardReason.setText(msg.getSqxx());
//        mTvCardOrigin.setText(msg.getSjly());
//        mTvCardPolicePhone.setText(msg.getZrszlxdh());
//        mTvCardPolice.setText(msg.getZrszxm());
    }

    /**
     * 我的关注界面条目点击事件
     * @param mCooper
     */
    private void updateCooperUi(CooperPersonInfos mCooper) {
        String s = mCooper.toString();
        LogUtil.e(s);
        mPersonXp = mCooper.getXp();
        if (BitmapUtil.stringtoBitmap(mPersonXp) != null) {
            mCardPhoto.setImageBitmap(BitmapUtil.stringtoBitmap(mPersonXp));
        } else {
            mCardPhoto.setImageResource(R.drawable.user_photo_icon);
        }

        //警员信息
//        mTvCardCollectInfo.setText("警辅人员信息");
//        mTvCardCollectPolice.setText("姓        名:");
        mTvRailStation.setText("采集日期");
        String djrq = mCooper.getCjsj();
//        String year = djrq.substring(0, 4);
//        String month = djrq.substring(4, 6);
//        String day = djrq.substring(6, 8);
//        String hour = djrq.substring(8, 10);
//        String minute = djrq.substring(10, 12);
//        String seconds = djrq.substring(12, 14);


        mTvCardNumber.setText(mCooper.getSfzh());
        mTvCardName.setText(mCooper.getXm());
        mTvCardOriginal.setText(mCooper.getSdfj());
        mTvCardRank.setText(mCooper.getJb());
        mTvCardReason.setText(mCooper.getRylx());
        mTvCardOrigin.setText(mCooper.getSjly());

        mTvCardPolicePhone.setText(mCooper.getFjsjh());
        mTvCardPolice.setText(mCooper.getFjxm());

        LogUtil.d(mCooper.toString());
        mTvCardStationTime.setText(djrq);
//        mTvCardStationTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + seconds);
        String pushTime = String.valueOf(StringUtil.stampToTime(String.valueOf(mCooper.getCreateTime())));
        mTvCardCompareState.setText(pushTime);
        mTvCardReceiveTime.setText(pushTime);

//        mTvCardOriginal.setText(personInfos.getsd());
//        mTvCardReason.setText(msg.getSqxx());
//        mTvCardOrigin.setText(msg.getSjly());
//        mTvCardPolicePhone.setText(msg.getZrszlxdh());
//        mTvCardPolice.setText(msg.getZrszxm());
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zymessage);
        ButterKnife.bind(this);
        setRightImgGone(false);

        mFlags = getIntent().getFlags();
        if (mFlags == 2 || mFlags == 3) {
            mMessage = getIntent().getParcelableExtra(Constant.PUSH_DATA);
            if (mMessage != null) {
                updateUi(mMessage);
            }
        } else if (mFlags == 4) {
            mPersonInfos = getIntent().getParcelableExtra(Constant.PUSH_DATA);
            if (mPersonInfos != null) {
                updateEKongUi(mPersonInfos);
            }
        } else if (mFlags == 5) {//  我的关注调取方法
            mCooperPersonInfos = getIntent().getParcelableExtra(Constant.PUSH_DATA);
            if (mCooperPersonInfos != null) {
                updateCooperUi(mCooperPersonInfos);
            }

        } else {
            ZyPushMessage msgs = getIntent().getParcelableExtra(Constant.PUSH_DATA);
            if (msgs != null) {
                mTitle = msgs.getTitle();
                TjApp.getRetrofit().getMessageInfo("", filter, mTitle, 1, 1).enqueue(this);
            }
        }
    }


    /**
     * @param view
     */
    @SuppressLint("WrongConstant")
    @OnClick({R.id.card_photo, R.id.tv_copy_info, R.id.textViewState, R.id.tv_card_number})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card_photo:
                if (TextUtils.isEmpty(mPersonXp)) {
                    mCardPhoto.setImageResource(R.drawable.user_photo_icon);
                } else {
                    Intent intent = new Intent(this, ZoomImageActivity.class);
                    if (mFlags == 2 || mFlags == 3) {
                        intent.setFlags(1);
                        intent.putExtra("data", mMessage);
                    } else if (mFlags == 4) {
                        intent.setFlags(2);
                        intent.putExtra("data", mPersonInfos);
                    } else if (mFlags == 5) {
                        intent.setFlags(3);
                        intent.putExtra("data", mCooperPersonInfos);
                    }
                    startActivity(intent);
                }
                break;
            case R.id.tv_copy_info:
                CustomToast.INSTANCE.showToast(getApplication(), "复制成功");
                break;
            case R.id.textViewState:

                break;
            case R.id.tv_card_number:
                toZhiYu(mMessage.getSfzh());
                break;
            default:
                break;
        }
    }

    private void toZhiYu(String id) {
        SosNewBean userInfo = UserService.getNewUserInfo(this);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(mUpDateUIReceiver);
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        String data = response.body();
        if (response.isSuccessful()) {
            resolveData(data);
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        CustomToast.INSTANCE.showToast(this, "网络异常");
    }

    /**
     * 解析数据
     *
     * @param data
     */
    private void resolveData(String data) {
        MessageInfos messageInfos = GsonUtil.parseJsonWithGson(data, MessageInfos.class);
        MessageInfo messageInfo = messageInfos.getData();
        List<AdmComparingInfo> rows = messageInfo.getRows();
//        for (int i = 0; i < rows.size(); i++) {
//            String jsonContent = rows.get(i).getJsonContent();
//            ZYPushMsg message = GsonUtil.parseJsonWithGson(jsonContent, ZYPushMsg.class);
//            if (message != null) {
//                String dataJson = message.getJsonContent();
//                mMessage = GsonUtil.parseJsonWithGson(dataJson, ZYMessage.class);
//            }
//        }
        updateUi(mMessage);
    }


}
