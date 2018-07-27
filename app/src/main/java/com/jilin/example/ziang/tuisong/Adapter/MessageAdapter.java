package com.jilin.example.ziang.tuisong.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jilin.example.ziang.tuisong.Activity.ZyMessageActivity;
import com.jilin.example.ziang.tuisong.Bean.AdmComparingInfo;
import com.jilin.example.ziang.tuisong.Bean.SosBean;
import com.jilin.example.ziang.tuisong.Constant;
import com.jilin.example.ziang.tuisong.CustomToast;
import com.jilin.example.ziang.tuisong.DetainRoot;
import com.jilin.example.ziang.tuisong.R;
import com.jilin.example.ziang.tuisong.TjApp;
import com.jilin.example.ziang.tuisong.UserService;
import com.jilin.example.ziang.tuisong.Utils.BitmapUtil;
import com.jilin.example.ziang.tuisong.Utils.GsonUtil;
import com.jilin.example.ziang.tuisong.Utils.StationUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @author huiliu
 * @date 2017/10/13
 * @email liu594545591@126.com
 * @introduce
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageAdapterViewHolder> {
    private List<AdmComparingInfo> typeInfos;

    private Context context;


    public MessageAdapter(List<AdmComparingInfo> typeInfos, Context context) {
        this.typeInfos = typeInfos;
        this.context = context;
    }

    @Override
    public MessageAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message_info, parent, false);
        return new MessageAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageAdapterViewHolder holder, final int position) {
        holder.setIsRecyclable(false);
        final AdmComparingInfo message = typeInfos.get(position);
        if (message != null) {
            if (message.getXp() != null) {
                if (BitmapUtil.stringtoBitmap(message.getXp()) != null) {
                    holder.ivPhoto.setImageBitmap(BitmapUtil.stringtoBitmap(message.getXp()));
                }

            }else {
                holder.ivPhoto.setBackgroundResource(R.drawable.user_photo_icon);
            }
//            holder.tv_state.setText(message.getSfzh());
            String xxwb = message.getXxwb();
            //目的地
            String end = xxwb.substring(xxwb.lastIndexOf("前往") + 2);
            String start = xxwb.substring(xxwb.lastIndexOf("火车站") - 3, xxwb.lastIndexOf("火车站"));
            //进站时间
            String rq = xxwb.substring(xxwb.lastIndexOf("于2") + 1, xxwb.lastIndexOf("在"));
            System.out.println("rq>>>>>>>>>>" + rq);
            String substring = rq.substring(10);

            holder.tv_come_time.setText(message.getJpsj());
            holder.tv_name.setText(message.getXm());
            holder.tv_id.setText("身份证:" + message.getSfzh());
            holder.tv_location.setText("地址:" + message.getXzdxz());
            holder.tv_reason.setText(message.getSqxx());
            holder.tv_sex.setText(message.getXb());
            String status = message.getStatus();
            if (status != null) {
                switch (status) {
                    case "1":
                        holder.tv_item_person_attention.setText("扣留");
                        break;
                    case "2":
                        holder.tv_item_person_attention.setText("已扣留");
                        break;
                    default:
                        holder.tv_item_person_attention.setText("扣留");
                        break;
                }
            }
            holder.tv_station_start_station.setText(StationUtil.getStation(start));
            holder.tv_station_end_station.setText(StationUtil.getStation(end));

            holder.ll_deal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            holder.ll_attention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getDetain(String.valueOf(message.getId()),position);
                }
            });

        }
        holder.rl_item_msg.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ZyMessageActivity.class);
                intent.setFlags(2);
                intent.putExtra(Constant.PUSH_DATA, message);
                context.startActivity(intent);
            }
        });

    }

    private void getDetain(String tableId, final int position) {
        SosBean userInfo = UserService.getUserInfo(context);
        String code = userInfo.getCode();
        TjApp.getRetrofit().getDetain(tableId, "2", code).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String data = response.body();
                DetainRoot detainRoot = GsonUtil.parseJsonWithGson(data, DetainRoot.class);
                if (detainRoot.getStatus() == 0) {
                    typeInfos.get(position).setStatus("2");
                    Intent intent = new Intent("com.anrongtec.focus");
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                } else {
                    CustomToast.INSTANCE.showToast(context, detainRoot.getMsg());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return typeInfos == null ? 0 : typeInfos.size();
    }

    class MessageAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        TextView tv_name;
        TextView tv_state;
        TextView tv_id;
        TextView tv_location;
        TextView tv_reason;
        TextView tv_sex;
        TextView tv_station_start_station;
        TextView tv_station_end_station;
        TextView tv_age;
        TextView tv_come_time;
        TextView tv_item_person_attention;

        LinearLayout ll_attention;
        LinearLayout ll_deal;
        LinearLayout ll_phone;
        RelativeLayout rl_item_msg;

        MessageAdapterViewHolder(View itemView) {
            super(itemView);
            ivPhoto = (ImageView) itemView.findViewById(R.id.iv_item_msg_user_photo);
            tv_name = (TextView) itemView.findViewById(R.id.tv_item_msg_name);
            tv_state = (TextView) itemView.findViewById(R.id.tv_item_msg_state);
            tv_sex = (TextView) itemView.findViewById(R.id.tv_item_msg_sex);
            tv_id = (TextView) itemView.findViewById(R.id.tv_item_person_id);
            tv_come_time = (TextView) itemView.findViewById(R.id.tv_item_person_come_time);
            tv_location = (TextView) itemView.findViewById(R.id.tv_item_person_location);
            tv_reason = (TextView) itemView.findViewById(R.id.tv_item_person_reason);
            tv_station_start_station = (TextView) itemView.findViewById(R.id.tv_item_person_start_station);
            tv_station_end_station = (TextView) itemView.findViewById(R.id.tv_item_person_end_station);
            ll_attention = (LinearLayout) itemView.findViewById(R.id.ll_focus_people_attention);
            ll_deal = (LinearLayout) itemView.findViewById(R.id.ll_focus_people_deal);
            ll_phone = (LinearLayout) itemView.findViewById(R.id.ll_focus_people_tel);
            rl_item_msg = (RelativeLayout) itemView.findViewById(R.id.rl_item_msg);
            tv_item_person_attention = (TextView) itemView.findViewById(R.id.tv_item_person_attention);

        }
    }


}
