package com.jilin.example.ziang.tuisong.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by huiliu on 2017/10/14.
 *
 * @email liu594545591@126.com
 * @introduce
 */
public class ZYMessage implements Parcelable {

    /**
     * private String dt_matched;

     private String bkmj;

     private String xxwb;

     private String sfzh;

     private String xm;

     private String xb;

     private String csrq;

     private String cxdd;

     private String bkyxjb;

     private String bkrq;

     private String bkdw;

     private String ryzp;
     */
    private String dt_matched;

    private String bkmj;

    private String xxwb;//信息文本

    private String sfzh;

    private String xm;

    private String xb;

    private String csrq;

    private String cxdd;

    private String bkyxjb;

    private String bkrq;

    private String bkdw;

    private String ryzp;

    private int messid;

    public String getDt_matched() {
        return dt_matched;
    }

    public void setDt_matched(String dt_matched) {
        this.dt_matched = dt_matched;
    }

    public String getBkmj() {
        return bkmj;
    }

    public void setBkmj(String bkmj) {
        this.bkmj = bkmj;
    }

    public String getXxwb() {
        return xxwb;
    }

    public void setXxwb(String xxwb) {
        this.xxwb = xxwb;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getCxdd() {
        return cxdd;
    }

    public void setCxdd(String cxdd) {
        this.cxdd = cxdd;
    }

    public String getBkyxjb() {
        return bkyxjb;
    }

    public void setBkyxjb(String bkyxjb) {
        this.bkyxjb = bkyxjb;
    }

    public String getBkrq() {
        return bkrq;
    }

    public void setBkrq(String bkrq) {
        this.bkrq = bkrq;
    }

    public String getBkdw() {
        return bkdw;
    }

    public void setBkdw(String bkdw) {
        this.bkdw = bkdw;
    }

    public String getRyzp() {
        return ryzp;
    }

    public void setRyzp(String ryzp) {
        this.ryzp = ryzp;
    }

    public int getMessid() {
        return messid;
    }

    public void setMessid(int messid) {
        this.messid = messid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.dt_matched);
        dest.writeString(this.bkmj);
        dest.writeString(this.xxwb);
        dest.writeString(this.sfzh);
        dest.writeString(this.xm);
        dest.writeString(this.xb);
        dest.writeString(this.csrq);
        dest.writeString(this.cxdd);
        dest.writeString(this.bkyxjb);
        dest.writeString(this.bkrq);
        dest.writeString(this.bkdw);
        dest.writeString(this.ryzp);
    }

    public ZYMessage() {
    }

    protected ZYMessage(Parcel in) {
        this.dt_matched = in.readString();
        this.bkmj = in.readString();
        this.xxwb = in.readString();
        this.sfzh = in.readString();
        this.xm = in.readString();
        this.xb = in.readString();
        this.csrq = in.readString();
        this.cxdd = in.readString();
        this.bkyxjb = in.readString();
        this.bkrq = in.readString();
        this.bkdw = in.readString();
        this.ryzp = in.readString();
    }

    public static final Creator<ZYMessage> CREATOR = new Creator<ZYMessage>() {
        @Override
        public ZYMessage createFromParcel(Parcel source) {
            return new ZYMessage(source);
        }

        @Override
        public ZYMessage[] newArray(int size) {
            return new ZYMessage[size];
        }
    };
}
