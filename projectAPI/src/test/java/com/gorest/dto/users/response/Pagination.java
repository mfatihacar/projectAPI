package com.gorest.dto.users.response;

public class Pagination {

    private int total;
    private int pages;
    private int page;
    private int limit;

    public int getTotal() {
        return total;
    }

    public int getPages() {
        return pages;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }
}
