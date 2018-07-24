package com.jilin.example.ziang.tuisong.Activity;

import android.os.Bundle;
import android.widget.Button;

import com.jilin.example.ziang.tuisong.Bean.AdmComparingInfo;
import com.jilin.example.ziang.tuisong.Utils.BitmapUtil;
import com.jilin.example.ziang.tuisong.Bean.CooperPersonInfos;
import com.jilin.example.ziang.tuisong.Bean.EKongPersonInfos;
import com.jilin.example.ziang.tuisong.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author huiliu
 */
public class ZoomImageActivity extends ToolBarActivity {

    @BindView(R.id.zi_photo)
    ZoomImageView mZiPhoto;
    @BindView(R.id.btn_show_pop)
    Button mBtnShowPop;
    private String mRyzp;
    private AdmComparingInfo mMessage;
    private CooperPersonInfos mCooperMessage;
    private EKongPersonInfos mEKongMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_image);
        ButterKnife.bind(this);
        setRightImgGone(false);
        int flags = getIntent().getFlags();
        switch (flags){
            case 1:
                mMessage = getIntent().getParcelableExtra("data");
                if (mMessage != null) {
                    if (mMessage.getXp() != null) {
                        if (BitmapUtil.stringtoBitmap(mMessage.getXp()) != null) {
                            mZiPhoto.setImageBitmap(BitmapUtil.stringtoBitmap(mMessage.getXp()));
                        }
                    }
                }
                break;
            case 2:
                mEKongMessage = getIntent().getParcelableExtra("data");
                if (mEKongMessage != null) {
                    if (mEKongMessage.getXp() != null) {
                        if (BitmapUtil.stringtoBitmap(mEKongMessage.getXp()) != null) {
                            mZiPhoto.setImageBitmap(BitmapUtil.stringtoBitmap(mEKongMessage.getXp()));
                        }
                    }
                }
                break;
            case 3:
                mCooperMessage = getIntent().getParcelableExtra("data");
                if (mCooperMessage != null) {
                    if (mCooperMessage.getXp() != null) {
                        if (BitmapUtil.stringtoBitmap(mCooperMessage.getXp()) != null) {
                            mZiPhoto.setImageBitmap(BitmapUtil.stringtoBitmap(mCooperMessage.getXp()));
                        }
                    }
                }
                default:
                    break;
        }
    }

}
