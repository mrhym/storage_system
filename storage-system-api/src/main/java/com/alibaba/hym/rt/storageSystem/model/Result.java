package com.alibaba.hym.rt.storageSystem.model;

import com.alibaba.hym.rt.storageSystem.enums.ParamCodeEnums;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/1/30 19:14
 **/

public class Result<T> {
    private String message;
    private String retCode;
    private T data;

    private Result(T data) {
        this.retCode = ParamCodeEnums.SUCCESS.getCode();
        this.message = ParamCodeEnums.SUCCESS.getMsg();
        this.data = data;
    }

    private Result(String msg) {
        if (msg == null) {
            return;
        }
        this.message = msg;
    }

    private Result(String code, String msg) {
        if (msg == null || code == null) {
            return;
        }
        this.retCode = code;
        this.message = msg;
    }

    private Result(String code, String msg, T data) {
        if (msg == null || code == null || data == null) {
            return;
        }
        this.retCode = code;
        this.message = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }


    private void succOf(T data) {
        this.data = data;
    }

    /**
     *
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data, String msg) {
        return new Result<T>(ParamCodeEnums.SUCCESS.getCode(), msg, data);
    }

    /**
     *
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Result<T> success() {
        return (Result<T>) success("");
    }

    /**
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String msg) {
        return new Result<T>(msg);
    }

    /**
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String code, String msg) {
        return new Result<T>(code, msg);
    }



    /**
     *
     * @param data
     */
    protected void setData(T data){this.data = data;}

    /**
     *
     * @return
     */
    public T getData() {
        return data;
    }


    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @return
     */
    public String getRetCode() {
        return retCode;
    }
}
