package com.jilin.example.ziang.tuisong.Utils;

/**
 * Created by huiliu on 2017/10/19.
 *
 * @email liu594545591@126.com
 * @introduce
 */
public class StationUtil {
    /**
     * VNP 北京南站   TJP 天津站
     * BJP 北京站           JKP 天津北
     * BOP 北京东           TSP 天津站
     */
    public static String getStation(String code) {
        if (code == null) {
            return "无";
        }
        switch (code) {
            case "VNP":
                code = "北京南站";
                break;
            case "BJP":
                code = "北京站";
                break;
            case "BOP":
                code = "北京东站";
                break;
            case "WWP":
                code = "武清站";
                break;
            case "TJP":
                code = "天津站";
                break;
            case "JKP":
                code = "天津北";
                break;
            case "TSP":
                code = "天津站";
                break;
            case "QTP":
                code = "秦皇岛";
                break;
            case "VAB":
                code = "哈尔滨";
                break;
            case "UDP":
                code = "滦河";
                break;
            case "SJP":
                code = "石家庄";
                break;
            case "DIP":
                code = "德州东";
                break;
            case "UUH":
                code = "徐州东";
                break;
            default:
                break;
        }

        return code;
    }

}
