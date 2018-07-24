package com.jilin.example.ziang.tuisong.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jilin.example.ziang.tuisong.Constant;
import com.jilin.example.ziang.tuisong.CustomToast;
import com.jilin.example.ziang.tuisong.Utils.LiteOrmDBUtil;
import com.jilin.example.ziang.tuisong.Utils.NetUtil;
import com.jilin.example.ziang.tuisong.OnlineService;
import com.jilin.example.ziang.tuisong.R;
import com.jilin.example.ziang.tuisong.Bean.TodoEkongMessage;
import com.jilin.example.ziang.tuisong.Bean.TodoMessage;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LocalBroadcastManager mManager;
    private FocusNoticeReceiver mFocusNoticeReceiver;
    private TextView tv_my_focus;
    private RelativeLayout rl_my_focus;
    private TextView tv_my_ekong_tips;
    private RelativeLayout rl_my_ekong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mManager = LocalBroadcastManager.getInstance(this);
        //注册接收消息广播
        registerFocusForNotice();
        //网络判断
        if (!NetUtil.isNetworkAvailable(this)) {
            CustomToast.INSTANCE.showToast(this, "请检查网络");
            return;
        }
        //启动服务
        Intent startSrv = new Intent(this, OnlineService.class);
        startSrv.putExtra("CMD", "TICK");
        this.startService(startSrv);

    }

    /**
     * 注册关注消息接收广播
     */
    private void registerFocusForNotice() {
        IntentFilter filter = new IntentFilter(Constant.NOTICE_FOCUS_ACTION);
        mFocusNoticeReceiver = new FocusNoticeReceiver();
        mManager.registerReceiver(mFocusNoticeReceiver, filter);
    }

    private void initView() {
        tv_my_focus = (TextView) findViewById(R.id.tv_my_focus);
        rl_my_focus = (RelativeLayout) findViewById(R.id.rl_my_focus);
        tv_my_ekong_tips = (TextView) findViewById(R.id.tv_my_ekong_tips);
        rl_my_ekong = (RelativeLayout) findViewById(R.id.rl_my_ekong);
        rl_my_ekong.setOnClickListener(this);
        rl_my_focus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_my_focus://重点关注
                tv_my_focus.setVisibility(View.INVISIBLE);
                LiteOrmDBUtil.deleteAll(TodoMessage.class);
                startActivity(new Intent(this, MessageActivity.class));
                break;
            case R.id.rl_my_ekong://我的关注
                LiteOrmDBUtil.deleteAll(TodoEkongMessage.class);
                tv_my_ekong_tips.setVisibility(View.INVISIBLE);
                startActivity(new Intent(this, EkongFocusActivity.class));
                break;
        }
    }

    /**
     * 接收关注消息推送 的广播
     */
    private class FocusNoticeReceiver extends BroadcastReceiver {

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onReceive(Context context, Intent intent) {
            if (Objects.equals(intent.getAction(), Constant.NOTICE_FOCUS_ACTION)) {
                List<TodoMessage> queryAll0 = LiteOrmDBUtil.getQueryByWhere(TodoMessage.class, "type", new Object[]{99});
                List<TodoMessage> queryAll1 = LiteOrmDBUtil.getQueryByWhere(TodoMessage.class, "type", new Object[]{98});
                int i = queryAll0.size() + queryAll1.size();
                Toast.makeText(MainActivity.this,"接收推送消息"+i,Toast.LENGTH_LONG).show();
                if (queryAll0.size() > 0 && tv_my_focus != null) {
                    tv_my_focus.setVisibility(View.VISIBLE);
                    tv_my_focus.setText(String.valueOf(queryAll0.size()));
                }
                if (queryAll1.size() > 0 && tv_my_focus != null) {
                    tv_my_focus.setVisibility(View.VISIBLE);
                    tv_my_focus.setText(String.valueOf(queryAll1.size()));
                }
            }
        }
    }
}
