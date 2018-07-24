package com.jilin.example.ziang.tuisong;

/**
 *
 * @author huiliu
 * @date 2018/1/1
 *
 * @email liu594545591@126.com
 * @introduce
 */
public class Weather {
    private String text;
    private String code;
    private String temperature;
    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    public String getTemperature() {
        return temperature;
    }
}
