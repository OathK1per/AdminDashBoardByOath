package com.example.demo.pojo;

import java.util.List;

public class Page {

    private List<Category> categoryList;

    private int totalPage;
    private int totalCount;
    private int currentPage;
    private final int CURRENT_COUNT=10;

    public Page() {
        super();
    }

    public Page(List categoryList, int totalPage, int totalCount, int currentPage) {
        this.categoryList = categoryList;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List categoryList) {
        this.categoryList = categoryList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCURRENT_COUNT() {
        return CURRENT_COUNT;
    }
}
