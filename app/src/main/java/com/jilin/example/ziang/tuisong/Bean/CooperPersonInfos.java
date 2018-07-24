package com.jilin.example.ziang.tuisong.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by huiliu on 2018/3/3.
 *
 * @email liu594545591@126.com
 * 我的关注model类
 * @introduce
 */
public class CooperPersonInfos implements Parcelable {

    /**
     * 信息ID
     */
    protected Long id;

    /**
     * 属地分局
     */
    protected String sdfj;

    /**
     * 姓名
     */
    protected String xm;

    /**
     * 身份证
     */
    protected String sfzh;

    /**
     * 人员类型
     */
    protected String rylx;

    /**
     * 级别
     */
    protected String jb;

    /**
     * 责任民警姓名
     */
    protected String zrmjxm;

    /**
     * 数据来源
     */
    protected String sjly;

    /**
     * 车牌号
     */
    protected String cph;

    /**
     * 随行民警身份证号
     */
    protected String sxsfzh;

    /**
     * 检查点名称
     */
    protected String jcdmc;

    /**
     * 采集点经度坐标
     */
    protected String cjdjd;

    /**
     * 采集点纬度坐标
     */
    protected String cjdwd;

    /**
     * 采集时间
     */
    protected String cjsj;

    /**
     * 检察辅警手机号
     */
    protected String fjsjh;

    /**
     * 检察辅警姓名
     */
    protected String fjxm;

    /**
     * 检察辅警身份证号
     */
    protected String fjsfzh;

    /**
     * 检察辅警警号
     */
    protected String fjcode;

    /**
     * 创建时间
     */
    protected long createTime;

    /**
     * 修改人code
     */
    protected String updatorId;

    /**
     * 修改时间
     */
    protected long updateTime;

    /**
     * 是否删除标识(0:未删除; 1:已删除)
     */
    protected Boolean del;

    /**
     * 状态
     */
    protected Integer status;

    /**
     * 信息类型(1:社会访重点人;2:公安部;3:两项目;4:肇事肇祸精神病人;5:个人极端人员)
     */
    protected Integer type;

    /**
     * 相片
     */
    protected String xp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSdfj() {
        return sdfj;
    }

    public void setSdfj(String sdfj) {
        this.sdfj = sdfj;
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

    public String getRylx() {
        return rylx;
    }

    public void setRylx(String rylx) {
        this.rylx = rylx;
    }

    public String getJb() {
        return jb;
    }

    public void setJb(String jb) {
        this.jb = jb;
    }

    public String getZrmjxm() {
        return zrmjxm;
    }

    public void setZrmjxm(String zrmjxm) {
        this.zrmjxm = zrmjxm;
    }

    public String getSjly() {
        return sjly;
    }

    public void setSjly(String sjly) {
        this.sjly = sjly;
    }

    public String getCph() {
        return cph;
    }

    public void setCph(String cph) {
        this.cph = cph;
    }

    public String getSxsfzh() {
        return sxsfzh;
    }

    public void setSxsfzh(String sxsfzh) {
        this.sxsfzh = sxsfzh;
    }

    public String getJcdmc() {
        return jcdmc;
    }

    public void setJcdmc(String jcdmc) {
        this.jcdmc = jcdmc;
    }

    public String getCjdjd() {
        return cjdjd;
    }

    public void setCjdjd(String cjdjd) {
        this.cjdjd = cjdjd;
    }

    public String getCjdwd() {
        return cjdwd;
    }

    public void setCjdwd(String cjdwd) {
        this.cjdwd = cjdwd;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    public String getFjsjh() {
        return fjsjh;
    }

    public void setFjsjh(String fjsjh) {
        this.fjsjh = fjsjh;
    }

    public String getFjxm() {
        return fjxm;
    }

    public void setFjxm(String fjxm) {
        this.fjxm = fjxm;
    }

    public String getFjsfzh() {
        return fjsfzh;
    }

    public void setFjsfzh(String fjsfzh) {
        this.fjsfzh = fjsfzh;
    }

    public String getFjcode() {
        return fjcode;
    }

    public void setFjcode(String fjcode) {
        this.fjcode = fjcode;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(String updatorId) {
        this.updatorId = updatorId;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getXp() {
        return xp;
    }

    public void setXp(String xp) {
        this.xp = xp;
    }

    @Override
    public String toString() {
        return "CooperationCFragment{" +
                "id=" + id +
                ", sdfj='" + sdfj + '\'' +
                ", xm='" + xm + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", rylx='" + rylx + '\'' +
                ", jb='" + jb + '\'' +
                ", zrmjxm='" + zrmjxm + '\'' +
                ", sjly='" + sjly + '\'' +
                ", cph='" + cph + '\'' +
                ", sxsfzh='" + sxsfzh + '\'' +
                ", jcdmc='" + jcdmc + '\'' +
                ", cjdjd='" + cjdjd + '\'' +
                ", cjdwd='" + cjdwd + '\'' +
                ", cjsj='" + cjsj + '\'' +
                ", fjsjh='" + fjsjh + '\'' +
                ", fjxm='" + fjxm + '\'' +
                ", fjsfzh='" + fjsfzh + '\'' +
                ", fjcode='" + fjcode + '\'' +
                ", createTime=" + createTime +
                ", updatorId='" + updatorId + '\'' +
                ", updateTime=" + updateTime +
                ", del=" + del +
                ", status=" + status +
                ", type=" + type +
                ", xp='" + xp + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.sdfj);
        dest.writeString(this.xm);
        dest.writeString(this.sfzh);
        dest.writeString(this.rylx);
        dest.writeString(this.jb);
        dest.writeString(this.zrmjxm);
        dest.writeString(this.sjly);
        dest.writeString(this.cph);
        dest.writeString(this.sxsfzh);
        dest.writeString(this.jcdmc);
        dest.writeString(this.cjdjd);
        dest.writeString(this.cjdwd);
        dest.writeString(this.cjsj);
        dest.writeString(this.fjsjh);
        dest.writeString(this.fjxm);
        dest.writeString(this.fjsfzh);
        dest.writeString(this.fjcode);
        dest.writeLong(this.createTime);
        dest.writeString(this.updatorId);
        dest.writeLong(this.updateTime);
        dest.writeValue(this.del);
        dest.writeValue(this.status);
        dest.writeValue(this.type);
        dest.writeString(this.xp);
    }

    public CooperPersonInfos() {
    }

    protected CooperPersonInfos(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.sdfj = in.readString();
        this.xm = in.readString();
        this.sfzh = in.readString();
        this.rylx = in.readString();
        this.jb = in.readString();
        this.zrmjxm = in.readString();
        this.sjly = in.readString();
        this.cph = in.readString();
        this.sxsfzh = in.readString();
        this.jcdmc = in.readString();
        this.cjdjd = in.readString();
        this.cjdwd = in.readString();
        this.cjsj = in.readString();
        this.fjsjh = in.readString();
        this.fjxm = in.readString();
        this.fjsfzh = in.readString();
        this.fjcode = in.readString();
        this.createTime = in.readLong();
        this.updatorId = in.readString();
        this.updateTime = in.readLong();
        this.del = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.status = (Integer) in.readValue(Integer.class.getClassLoader());
        this.type = (Integer) in.readValue(Integer.class.getClassLoader());
        this.xp = in.readString();
    }

    public static final Parcelable.Creator<CooperPersonInfos> CREATOR = new Parcelable.Creator<CooperPersonInfos>() {
        @Override
        public CooperPersonInfos createFromParcel(Parcel source) {
            return new CooperPersonInfos(source);
        }

        @Override
        public CooperPersonInfos[] newArray(int size) {
            return new CooperPersonInfos[size];
        }
    };
}
