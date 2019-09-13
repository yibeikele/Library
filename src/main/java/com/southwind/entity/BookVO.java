package com.southwind.entity;

import java.util.List;


public class BookVO {
    private int code;
    private String msg;
    private int count;
    private List<Book> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Book> getData() {
        return data;
    }

    public void setData(List<Book> data) {
        this.data = data;
    }

    public BookVO(int code, String msg, int count, List<Book> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public BookVO() {
    }

    @Override
    public String toString() {
        return "BookVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
