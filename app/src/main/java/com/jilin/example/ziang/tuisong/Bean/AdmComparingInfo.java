package com.jilin.example.ziang.tuisong.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author liuhui
 * 重点关注  model类
 */
public class AdmComparingInfo implements Parcelable {
    /**
     * 对比信息ID
     */
    protected Long id;

    /**
     * 结果ID
     */
    protected String resultId;
    /**
     * 买票时间
     */
    protected String buytime;

    /**
     * 布控人员编号
     */
    protected String bkrybh;

    /**
     * 姓名
     */
    protected String xm;

    /**
     * 身份证
     */
    protected String sfzh;

    /**
     * 信息文本
     */
    protected String xxwb;

    /**
     * 检票时间
     */
    protected String checkinTime;

    /**
     * 检票时间
     */
    protected String jpsj;

    /**
     * 诉求信息
     */
    protected String sqxx;

    /**
     * 列控等级
     */
    protected String lkdj;

    /**
     * 户籍地详址
     */
    protected String hzdxz;

    /**
     * 现住地详址
     */
    protected String xzdxz;

    /**
     * 责任民警
     */
    protected String zrszxm;

    /**
     * 责任民警联系电话
     */
    protected String zrszlxdh;

    /**
     * 属地分局
     */
    protected String sdfj;

    /**
     * 数据来源
     */
    protected String sjly;

    /**
     * 性别
     */
    protected String xb;

    /**
     * 入库时间（巨龙）
     */
    protected String rksj;

    /**
     * 创建时间
     */
    protected long create_time;

    /**
     * 相片
     */
    protected String xp;
    /**
     * 是否删除标识(0:未删除; 1:已删除)这里用于已发送未发送
     */
    protected Boolean del;
    //扣留状态
    protected String status;
    protected String statusName;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getXp() {
        return xp;
    }

    public void setXp(String xp) {
        this.xp = xp;
    }

    /**
     * adm_comparing_info.id
     */
    public Long getId() {
        return id;
    }

    /**
     * adm_comparing_info.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * adm_comparing_info.result_id
     */
    public String getResultId() {
        return resultId;
    }

    /**
     * adm_comparing_info.result_id
     */
    public void setResultId(String resultId) {
        this.resultId = resultId == null ? null : resultId.trim();
    }

    /**
     * adm_comparing_info.bkrybh
     */
    public String getBkrybh() {
        return bkrybh;
    }

    /**
     * adm_comparing_info.bkrybh
     */
    public void setBkrybh(String bkrybh) {
        this.bkrybh = bkrybh == null ? null : bkrybh.trim();
    }

    /**
     * adm_comparing_info.xm
     */
    public String getXm() {
        return xm;
    }

    /**
     * adm_comparing_info.xm
     */
    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    /**
     * adm_comparing_info.sfzh
     */
    public String getSfzh() {
        return sfzh;
    }

    /**
     * adm_comparing_info.sfzh
     */
    public void setSfzh(String sfzh) {
        this.sfzh = sfzh == null ? null : sfzh.trim();
    }

    /**
     * adm_comparing_info.xxwb
     */
    public String getXxwb() {
        return xxwb;
    }

    /**
     * adm_comparing_info.xxwb
     */
    public void setXxwb(String xxwb) {
        this.xxwb = xxwb == null ? null : xxwb.trim();
    }

    /**
     * adm_comparing_info.checkin_time
     */
    public String getCheckinTime() {
        return checkinTime;
    }

    /**
     * adm_comparing_info.checkin_time
     */
    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime == null ? null : checkinTime.trim();
    }

    /**
     * adm_comparing_info.jpsj
     */
    public String getJpsj() {
        return jpsj;
    }

    /**
     * adm_comparing_info.jpsj
     */
    public void setJpsj(String jpsj) {
        this.jpsj = jpsj == null ? null : jpsj.trim();
    }

    /**
     * adm_comparing_info.sqxx
     */
    public String getSqxx() {
        return sqxx;
    }

    /**
     * adm_comparing_info.sqxx
     */
    public void setSqxx(String sqxx) {
        this.sqxx = sqxx == null ? null : sqxx.trim();
    }

    /**
     * adm_comparing_info.lkdj
     */
    public String getLkdj() {
        return lkdj;
    }

    /**
     * adm_comparing_info.lkdj
     */
    public void setLkdj(String lkdj) {
        this.lkdj = lkdj == null ? null : lkdj.trim();
    }

    /**
     * adm_comparing_info.hzdxz
     */
    public String getHzdxz() {
        return hzdxz;
    }

    /**
     * adm_comparing_info.hzdxz
     */
    public void setHzdxz(String hzdxz) {
        this.hzdxz = hzdxz == null ? null : hzdxz.trim();
    }

    /**
     * adm_comparing_info.xzdxz
     */
    public String getXzdxz() {
        return xzdxz;
    }

    /**
     * adm_comparing_info.xzdxz
     */
    public void setXzdxz(String xzdxz) {
        this.xzdxz = xzdxz == null ? null : xzdxz.trim();
    }

    /**
     * adm_comparing_info.zrszxm
     */
    public String getZrszxm() {
        return zrszxm;
    }

    /**
     * adm_comparing_info.zrszxm
     */
    public void setZrszxm(String zrszxm) {
        this.zrszxm = zrszxm == null ? null : zrszxm.trim();
    }

    /**
     * adm_comparing_info.zrszlxdh
     */
    public String getZrszlxdh() {
        return zrszlxdh;
    }

    /**
     * adm_comparing_info.zrszlxdh
     */
    public void setZrszlxdh(String zrszlxdh) {
        this.zrszlxdh = zrszlxdh == null ? null : zrszlxdh.trim();
    }

    /**
     * adm_comparing_info.sdfj
     */
    public String getSdfj() {
        return sdfj;
    }

    /**
     * adm_comparing_info.sdfj
     */
    public void setSdfj(String sdfj) {
        this.sdfj = sdfj == null ? null : sdfj.trim();
    }

    /**
     * adm_comparing_info.sjly
     */
    public String getSjly() {
        return sjly;
    }

    /**
     * adm_comparing_info.sjly
     */
    public void setSjly(String sjly) {
        this.sjly = sjly == null ? null : sjly.trim();
    }

    /**
     * adm_comparing_info.xb
     */
    public String getXb() {
        return xb;
    }

    /**
     * adm_comparing_info.xb
     */
    public void setXb(String xb) {
        this.xb = xb == null ? null : xb.trim();
    }

    /**
     * adm_comparing_info.rksj
     */
    public String getRksj() {
        return rksj;
    }

    /**
     * adm_comparing_info.rksj
     */
    public void setRksj(String rksj) {
        this.rksj = rksj == null ? null : rksj.trim();
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    /**
     * adm_comparing_info.del
     */
    public Boolean getDel() {
        return del;
    }

    /**
     * adm_comparing_info.del
     */
    public void setDel(Boolean del) {
        this.del = del;
    }

    public String getBuytime() {
        return buytime;
    }

    public void setBuytime(String buytime) {
        this.buytime = buytime;
    }

    @Override
    public String toString() {
        return "AdmComparingInfo{" +
                "id=" + id +
                ", resultId='" + resultId + '\'' +
                ", buytime='" + buytime + '\'' +
                ", bkrybh='" + bkrybh + '\'' +
                ", xm='" + xm + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", xxwb='" + xxwb + '\'' +
                ", checkinTime='" + checkinTime + '\'' +
                ", jpsj='" + jpsj + '\'' +
                ", sqxx='" + sqxx + '\'' +
                ", lkdj='" + lkdj + '\'' +
                ", hzdxz='" + hzdxz + '\'' +
                ", xzdxz='" + xzdxz + '\'' +
                ", zrszxm='" + zrszxm + '\'' +
                ", zrszlxdh='" + zrszlxdh + '\'' +
                ", sdfj='" + sdfj + '\'' +
                ", sjly='" + sjly + '\'' +
                ", xb='" + xb + '\'' +
                ", rksj='" + rksj + '\'' +
                ", create_time=" + create_time +
                ", xp='" + xp + '\'' +
                ", del=" + del +
                ", status='" + status + '\'' +
                ", statusName='" + statusName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.resultId);
        dest.writeString(this.buytime);
        dest.writeString(this.bkrybh);
        dest.writeString(this.xm);
        dest.writeString(this.sfzh);
        dest.writeString(this.xxwb);
        dest.writeString(this.checkinTime);
        dest.writeString(this.jpsj);
        dest.writeString(this.sqxx);
        dest.writeString(this.lkdj);
        dest.writeString(this.hzdxz);
        dest.writeString(this.xzdxz);
        dest.writeString(this.zrszxm);
        dest.writeString(this.zrszlxdh);
        dest.writeString(this.sdfj);
        dest.writeString(this.sjly);
        dest.writeString(this.xb);
        dest.writeString(this.rksj);
        dest.writeLong(this.create_time);
        dest.writeString(this.xp);
        dest.writeValue(this.del);
        dest.writeString(this.status);
        dest.writeString(this.statusName);
    }

    public AdmComparingInfo() {
    }

    protected AdmComparingInfo(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.resultId = in.readString();
        this.buytime = in.readString();
        this.bkrybh = in.readString();
        this.xm = in.readString();
        this.sfzh = in.readString();
        this.xxwb = in.readString();
        this.checkinTime = in.readString();
        this.jpsj = in.readString();
        this.sqxx = in.readString();
        this.lkdj = in.readString();
        this.hzdxz = in.readString();
        this.xzdxz = in.readString();
        this.zrszxm = in.readString();
        this.zrszlxdh = in.readString();
        this.sdfj = in.readString();
        this.sjly = in.readString();
        this.xb = in.readString();
        this.rksj = in.readString();
        this.create_time = in.readLong();
        this.xp = in.readString();
        this.del = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.status = in.readString();
        this.statusName = in.readString();
    }

    public static final Creator<AdmComparingInfo> CREATOR = new Creator<AdmComparingInfo>() {
        @Override
        public AdmComparingInfo createFromParcel(Parcel source) {
            return new AdmComparingInfo(source);
        }

        @Override
        public AdmComparingInfo[] newArray(int size) {
            return new AdmComparingInfo[size];
        }
    };
}