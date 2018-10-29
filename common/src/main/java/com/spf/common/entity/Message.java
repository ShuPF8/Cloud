package com.spf.common.entity;

/**
 * @author ShuPF
 * @类说明：
 * @date 2018-10-29 10:21
 */
public class Message<T> {
    /***
     * code: 1 成功 0 失败
     */
    private int code;

    /**
     * msg: 错误信息
     */
    private String msg;

    /**
     * data: 数据
     */
    private T data;

    public Message success(T data){
        this.code = 1;
        this.data = data;
        return this;
    }

    public Message fail(String msg) {
        this.code = 0;
        this.msg = msg;
        return  this;
    }

    public Message fail(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return  this;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
