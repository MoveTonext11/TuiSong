package com.jilin.example.ziang.tuisong.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.jilin.example.ziang.tuisong.Bean.AdmComparingInfo;
import com.jilin.example.ziang.tuisong.R;
import com.jilin.example.ziang.tuisong.Utils.BitmapUtil;
import com.jilin.example.ziang.tuisong.Utils.StationUtil;

import java.util.List;

/**
 *
 * @author huiliu
 * @date 2018/2/2
 *
 * @email liu594545591@126.com
 * @introduce
 */
public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketAdapterViewHolder> {

    private List<AdmComparingInfo> typeInfos;

    private Context context;

    private View.OnClickListener listener;

    public TicketAdapter(List<AdmComparingInfo> typeInfos, Context context, View.OnClickListener listener) {
        this.typeInfos = typeInfos;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public TicketAdapter.TicketAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message_info, parent, false);
        return new TicketAdapter.TicketAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TicketAdapter.TicketAdapterViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        final AdmComparingInfo message = typeInfos.get(position);
        if (message != null) {
            if (!TextUtils.isEmpty(message.getXp())) {
                if (BitmapUtil.stringtoBitmap(message.getXp()) != null) {
                    holder.ivPhoto.setImageBitmap(BitmapUtil.stringtoBitmap(message.getXp()));
                }
            }else {
                holder.ivPhoto.setImageResource(R.drawable.user_photo_icon);
            }
            String xxwb = message.getXxwb();
            //目的地
            String end = xxwb.substring(xxwb.lastIndexOf("前往") + 2);
            String start = xxwb.substring(xxwb.lastIndexOf("从") + 1, xxwb.lastIndexOf("前往"));
            //买票时间
            String rq = xxwb.substring(xxwb.lastIndexOf("于1") + 1, xxwb.lastIndexOf("在"));
            System.out.println("rq>>>>>>>>>>" + rq);
            String substring = rq.substring(10);

            holder.tv_come_time.setText(message.getJpsj());
            holder.tv_name.setText(message.getXm());
            holder.tv_id.setText("身份证:" + message.getSfzh());
            String xzdxz = message.getXzdxz();
            holder.tv_location.setText("地址:" + xzdxz);
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

            holder.ll_deal.setOnClickListener(listener);
            holder.ll_deal.setTag(position);
            holder.ll_attention.setOnClickListener(listener);
            holder.ll_attention.setTag(position);

        }
        holder.rl_item_msg.setTag(position);
        holder.rl_item_msg.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return typeInfos == null ? 0 : typeInfos.size();
    }

    class TicketAdapterViewHolder extends RecyclerView.ViewHolder {
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

        TicketAdapterViewHolder(View itemView) {
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
