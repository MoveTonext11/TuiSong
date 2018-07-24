package com.jilin.example.ziang.tuisong.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by huiliu on 2018/3/3.
 *
 * @email liu594545591@126.com
 * @introduce
 */
public class EKongPersonInfos implements Parcelable {

    private String bkmj;

    private String bkrybh;

    private int status;

    private String statusName;

    private String jgb_sjdx_gid;

    private String entiron_id;

    private String ywxxlx;

    private String xm;

    private String sfzh;

    private String xp;

    private String djrq;

    private String bkdw;

    private String bkyxjb;

    private int id;

    private String result_id;

    private String bd_id;

    private String xxwb;

    private long create_time;

    private boolean del;

    private String dt_matched;

    private String bkdyqh;

    private String bkrq;

    private String cxdd;

    public String getBkmj() {
        return bkmj;
    }

    public void setBkmj(String bkmj) {
        this.bkmj = bkmj;
    }

    public String getBkrybh() {
        return bkrybh;
    }

    public void setBkrybh(String bkrybh) {
        this.bkrybh = bkrybh;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getJgb_sjdx_gid() {
        return jgb_sjdx_gid;
    }

    public void setJgb_sjdx_gid(String jgb_sjdx_gid) {
        this.jgb_sjdx_gid = jgb_sjdx_gid;
    }

    public String getEntiron_id() {
        return entiron_id;
    }

    public void setEntiron_id(String entiron_id) {
        this.entiron_id = entiron_id;
    }

    public String getYwxxlx() {
        return ywxxlx;
    }

    public void setYwxxlx(String ywxxlx) {
        this.ywxxlx = ywxxlx;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getXp() {
        return xp;
    }

    public void setXp(String xp) {
        this.xp = xp;
    }

    public String getDjrq() {
        return djrq;
    }

    public void setDjrq(String djrq) {
        this.djrq = djrq;
    }

    public String getBkdw() {
        return bkdw;
    }

    public void setBkdw(String bkdw) {
        this.bkdw = bkdw;
    }

    public String getBkyxjb() {
        return bkyxjb;
    }

    public void setBkyxjb(String bkyxjb) {
        this.bkyxjb = bkyxjb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult_id() {
        return result_id;
    }

    public void setResult_id(String result_id) {
        this.result_id = result_id;
    }

    public String getBd_id() {
        return bd_id;
    }

    public void setBd_id(String bd_id) {
        this.bd_id = bd_id;
    }

    public String getXxwb() {
        return xxwb;
    }

    public void setXxwb(String xxwb) {
        this.xxwb = xxwb;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public String getDt_matched() {
        return dt_matched;
    }

    public void setDt_matched(String dt_matched) {
        this.dt_matched = dt_matched;
    }

    public String getBkdyqh() {
        return bkdyqh;
    }

    public void setBkdyqh(String bkdyqh) {
        this.bkdyqh = bkdyqh;
    }

    public String getBkrq() {
        return bkrq;
    }

    public void setBkrq(String bkrq) {
        this.bkrq = bkrq;
    }

    public String getCxdd() {
        return cxdd;
    }

    public void setCxdd(String cxdd) {
        this.cxdd = cxdd;
    }

    @Override
    public String toString() {
        return "EKongPersonInfos{" +
                "bkmj='" + bkmj + '\'' +
                ", bkrybh='" + bkrybh + '\'' +
                ", status=" + status +
                ", statusName='" + statusName + '\'' +
                ", jgb_sjdx_gid='" + jgb_sjdx_gid + '\'' +
                ", entiron_id='" + entiron_id + '\'' +
                ", ywxxlx='" + ywxxlx + '\'' +
                ", xm='" + xm + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", djrq='" + djrq + '\'' +
                ", bkdw='" + bkdw + '\'' +
                ", bkyxjb='" + bkyxjb + '\'' +
                ", id=" + id +
                ", result_id='" + result_id + '\'' +
                ", bd_id='" + bd_id + '\'' +
                ", xxwb='" + xxwb + '\'' +
                ", create_time=" + create_time +
                ", del=" + del +
                ", dt_matched='" + dt_matched + '\'' +
                ", bkdyqh='" + bkdyqh + '\'' +
                ", bkrq='" + bkrq + '\'' +
                ", cxdd='" + cxdd + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bkmj);
        dest.writeString(this.bkrybh);
        dest.writeInt(this.status);
        dest.writeString(this.statusName);
        dest.writeString(this.jgb_sjdx_gid);
        dest.writeString(this.entiron_id);
        dest.writeString(this.ywxxlx);
        dest.writeString(this.xm);
        dest.writeString(this.sfzh);
        dest.writeString(this.xp);
        dest.writeString(this.djrq);
        dest.writeString(this.bkdw);
        dest.writeString(this.bkyxjb);
        dest.writeInt(this.id);
        dest.writeString(this.result_id);
        dest.writeString(this.bd_id);
        dest.writeString(this.xxwb);
        dest.writeLong(this.create_time);
        dest.writeByte(this.del ? (byte) 1 : (byte) 0);
        dest.writeString(this.dt_matched);
        dest.writeString(this.bkdyqh);
        dest.writeString(this.bkrq);
        dest.writeString(this.cxdd);
    }

    public EKongPersonInfos() {
    }

    protected EKongPersonInfos(Parcel in) {
        this.bkmj = in.readString();
        this.bkrybh = in.readString();
        this.status = in.readInt();
        this.statusName = in.readString();
        this.jgb_sjdx_gid = in.readString();
        this.entiron_id = in.readString();
        this.ywxxlx = in.readString();
        this.xm = in.readString();
        this.sfzh = in.readString();
        this.xp = in.readString();
        this.djrq = in.readString();
        this.bkdw = in.readString();
        this.bkyxjb = in.readString();
        this.id = in.readInt();
        this.result_id = in.readString();
        this.bd_id = in.readString();
        this.xxwb = in.readString();
        this.create_time = in.readLong();
        this.del = in.readByte() != 0;
        this.dt_matched = in.readString();
        this.bkdyqh = in.readString();
        this.bkrq = in.readString();
        this.cxdd = in.readString();
    }

    public static final Creator<EKongPersonInfos> CREATOR = new Creator<EKongPersonInfos>() {
        @Override
        public EKongPersonInfos createFromParcel(Parcel source) {
            return new EKongPersonInfos(source);
        }

        @Override
        public EKongPersonInfos[] newArray(int size) {
            return new EKongPersonInfos[size];
        }
    };
}
