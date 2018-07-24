package com.jilin.example.ziang.tuisong.Bean;

/**
 * Created by huiliu on 2018/3/3.
 *
 * @email liu594545591@126.com
 * @introduce
 */
public class EKongPage {
    private int pageSize;

    private int page;

    private int totalCount;

    private int totalPage;

    private String sort;

    private String order;

    private String orderByClause;

    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }
    public int getPageSize(){
        return this.pageSize;
    }
    public void setPage(int page){
        this.page = page;
    }
    public int getPage(){
        return this.page;
    }
    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
    }
    public int getTotalCount(){
        return this.totalCount;
    }
    public void setTotalPage(int totalPage){
        this.totalPage = totalPage;
    }
    public int getTotalPage(){
        return this.totalPage;
    }
    public void setSort(String sort){
        this.sort = sort;
    }
    public String getSort(){
        return this.sort;
    }
    public void setOrder(String order){
        this.order = order;
    }
    public String getOrder(){
        return this.order;
    }
    public void setOrderByClause(String orderByClause){
        this.orderByClause = orderByClause;
    }
    public String getOrderByClause(){
        return this.orderByClause;
    }

    @Override
    public String toString() {
        return "EKongPage{" +
                "pageSize=" + pageSize +
                ", page=" + page +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", orderByClause='" + orderByClause + '\'' +
                '}';
    }
}
