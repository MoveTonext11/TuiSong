package com.jilin.example.ziang.tuisong.Bean;

import java.util.List;

/**
 * Created by huiliu on 2018/3/3.
 *
 * @email liu594545591@126.com
 * @introduce
 */
public class EKongPerson {

    private EKongPage page;

    private List<EKongPersonInfos> rows;

    public EKongPage getPage() {
        return page;
    }

    public void setPage(EKongPage page) {
        this.page = page;
    }

    public List<EKongPersonInfos> getRows() {
        return rows;
    }

    public void setRows(List<EKongPersonInfos> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "EKongPerson{" +
                "page=" + page +
                ", rows=" + rows +
                '}';
    }
}
