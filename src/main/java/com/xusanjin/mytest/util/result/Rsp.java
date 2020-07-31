package com.xusanjin.mytest.util.result;

import com.xusanjin.mytest.common.exception.BizException;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Rsp<T> implements Serializable {

    private static final long serialVersionUID = -4577255781088498763L;

    private Object data; //服务端数据

    private int code = RspCodeUtil.SUCCESS; //状态码

    private Boolean status; // boolean 类型， 成功是 true,  失败是 false

    private String msg; //描述信息

    private String detail;//异常错误堆栈的详细信息

    ///////////////////////////兼容的方法////////////////////////////////
    public static Rsp ok() {
        return data();
    }


    public static Rsp ok(Object d) {
        return data(d);
    }

    public static Rsp fail() {
        return msg();
    }

    public static Rsp fail(String msg, Object data) {
        Rsp rsp = new Rsp();
        rsp.setCode(RspCodeUtil.FAIL);
        rsp.setStatus(false);
        rsp.setMsg(msg);
        rsp.setDetail(msg);
        rsp.setData(data);
        return rsp;
    }

    public static Rsp unAuth(String msg) {
        return new Rsp(RspCodeUtil.UN_AUTH, false, msg, msg, null);
    }

    public static Rsp paramErr(String msg) {
        return new Rsp(RspCodeUtil.PARAM_ERR, false, msg, msg, null);
    }

    public static Rsp fail(String m) {
        return msg(m);
    }

    public static Rsp fail(Throwable e) {
        return exp(e);
    }


    ///////////////////////////常用的方法////////////////////////////////

    public static Rsp data() {
        return new Rsp(null);
    }

    public static Rsp data(Object data) {
        return new Rsp(data);
    }

    public static Rsp msg() {
        return new Rsp(null);
    }


    private static Rsp msg(String msg) {
        return new Rsp(msg, msg);
    }

    private static Rsp exp(Throwable e) {
        return new Rsp(e);
    }

    public Rsp() {
    }

    ///////////////////////////基本的方法////////////////////////////////

    public Rsp(Object o) {
        if (o != null && o instanceof BizException) {
            this.code = RspCodeUtil.FAIL;
            this.status = false;
            this.msg = ((BizException) o).getMessage();
            this.detail = o != null ? ((Throwable) o).getMessage() : "";
        } else if (o != null && o instanceof Throwable) {
            this.code = RspCodeUtil.FAIL;
            this.status = false;
            this.msg = "Server Interal error";
            this.detail = o != null ? ((Throwable) o).getMessage() : "";
        } else {
            if (data != null) {
                this.status = true;
                this.code = RspCodeUtil.SUCCESS;
            } else {
                // this.status = false;
                //this.code = FAIL;
                this.status = true;
                this.code = RspCodeUtil.SUCCESS;
            }
            this.msg = status ? "success" : "fail";
            this.detail = "";
            this.data = (T) o;
        }
    }

    public Rsp(String msg, String detail) {
        this.code = RspCodeUtil.FAIL;
        this.status = false;
        this.msg = msg;
        this.detail = detail;
        this.data = null;
    }

    public Rsp(String msg, Throwable e) {
        this.code = RspCodeUtil.FAIL;
        this.status = false;
        this.msg = msg;
        this.detail = e != null ? e.toString() : "";
        this.data = null;
    }


    public Rsp(int code, Boolean status, String msg, String detail, T data) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.detail = detail;
        this.data = data;
    }

    public Rsp(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.detail = msg;
    }
}