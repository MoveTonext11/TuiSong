package com.jilin.example.ziang.tuisong.Bean;

import com.jilin.example.ziang.tuisong.Page;

import java.util.List;

/**
 *
 * @author huiliu
 * @date 2017/10/14
 *
 * @email liu594545591@126.com
 * @introduce
 */
public class MessageInfo {
    private Page page;

    private List<AdmComparingInfo> rows;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<AdmComparingInfo> getRows() {
        return rows;
    }

    public void setRows(List<AdmComparingInfo> rows) {
        this.rows = rows;
    }
}
