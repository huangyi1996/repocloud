package com.huang.aaa;

public class Payment {
    private long id;
    private String detail;

    public long getId() {
        return id;
    }

    public Payment(long id, String detail) {
        this.id = id;
        this.detail = detail;
    }

    public Payment(String detail) {
        this.detail = detail;
    }

    public Payment() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
