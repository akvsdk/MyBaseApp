package com.ep.joy.mybaseapp.entity;

/**
 * author   Joy
 * Date:  2016/4/18.
 * version:  V1.0
 * Description:
 */
public class Result<T> {

    /**
     * success : true
     * msg : 操作成功
     * record :
     * errorCode : 0
     */

    public boolean success;
    public String msg;
    public String errorCode;
    public T record;

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
