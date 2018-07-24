package com.jilin.example.ziang.tuisong.Bean;


import com.jilin.example.ziang.tuisong.Weather;

/**
 * @author huiliu
 * @date 2017/10/10
 * @email liu594545591@126.com
 * @introduce 信大统一认证返回信息
 */
public class SosBean {
    /**
     * {
     * "status":0,
     * "data":{
     * "position":"28",
     * "limits":[
     * ],
     * "sex":"1",
     * "attentionPower":true,
     * "code":"150194",
     * "att_url":"http://20.3.2.47:90null",
     * "depcode":"120000200800",
     * "id":"4028b8815c8144cd015c8652b1320052",
     * "police":"22",
     * "name":"陈绪",
     * "grade":"5",
     * "depid":"b20b34ae5aec4e9d8f2e07578218eba3",
     * "identifier":"120104197909061818",
     * "mobile":"13803018890",
     * "effectivedate":"1514639093831"
     * },
     * "msg":"统一认证服务票据验证通过"
     * }
     * "
     */
    private String sex;

    private boolean attentionPower;

    private String code;

    private String att_url;

    private String depcode;

    private String id;

    private String police;

    private String name;

    private String grade;

    private String depid;

    private String identifier;

    private String mobile;

    private String effectivedate;

    private String onlineTime;//在线时间

    private String completeTask;//完成任务

    private String orgName;//单位名称

    private Weather now;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isAttentionPower() {
        return attentionPower;
    }

    public void setAttentionPower(boolean attentionPower) {
        this.attentionPower = attentionPower;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAtt_url() {
        return att_url;
    }

    public void setAtt_url(String att_url) {
        this.att_url = att_url;
    }

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPolice() {
        return police;
    }

    public void setPolice(String police) {
        this.police = police;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEffectivedate() {
        return effectivedate;
    }

    public void setEffectivedate(String effectivedate) {
        this.effectivedate = effectivedate;
    }

    public Weather getNow() {
        return now;
    }

    public void setNow(Weather now) {
        this.now = now;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getCompleteTask() {
        return completeTask;
    }

    public void setCompleteTask(String completeTask) {
        this.completeTask = completeTask;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "SosBean{" +
                "sex='" + sex + '\'' +
                ", attentionPower=" + attentionPower +
                ", code='" + code + '\'' +
                ", att_url='" + att_url + '\'' +
                ", depcode='" + depcode + '\'' +
                ", id='" + id + '\'' +
                ", police='" + police + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", depid='" + depid + '\'' +
                ", identifier='" + identifier + '\'' +
                ", mobile='" + mobile + '\'' +
                ", effectivedate='" + effectivedate + '\'' +
                ", onlineTime='" + onlineTime + '\'' +
                ", completeTask='" + completeTask + '\'' +
                ", orgName='" + orgName + '\'' +
                ", now=" + now +
                '}';
    }
}
