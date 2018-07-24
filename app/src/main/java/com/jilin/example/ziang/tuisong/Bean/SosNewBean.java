package com.jilin.example.ziang.tuisong.Bean;

import java.util.List;

/**
 *
 * @author huiliu
 * @date 2018/1/23
 *
 * @email liu594545591@126.com
 * @introduce
 */
public class SosNewBean {
    private List<String> limits ;

    private String position;

    private String id;

    private String sex;

    private String police;

    private String name;

    private String depid;

    private String code;

    private String identifier;

    private String depcode;

    private String effectivedate;

    private String mobile;

    private String orgName;

    public List<String> getLimits() {
        return limits;
    }

    public void setLimits(List<String> limits) {
        this.limits = limits;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode;
    }

    public String getEffectivedate() {
        return effectivedate;
    }

    public void setEffectivedate(String effectivedate) {
        this.effectivedate = effectivedate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "SosNewBean{" +
                "limits=" + limits +
                ", position='" + position + '\'' +
                ", id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                ", police='" + police + '\'' +
                ", name='" + name + '\'' +
                ", depid='" + depid + '\'' +
                ", code='" + code + '\'' +
                ", identifier='" + identifier + '\'' +
                ", depcode='" + depcode + '\'' +
                ", effectivedate='" + effectivedate + '\'' +
                ", mobile='" + mobile + '\'' +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}
