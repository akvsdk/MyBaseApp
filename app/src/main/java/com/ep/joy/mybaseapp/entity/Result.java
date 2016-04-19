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
     * record : {"newsList":[{"id":33,"title":"重庆盛泰雪铁龙首礼贺岁","subtitle":"红旗河沟店","dianjishu":181,"img":"http://222.177.210.200/mxqc/news/1454739216980.jpg","release_time":1454739241000,"releaseTime":"2016-02-06 14:14:01","cname":"导购","userName":"系统管理员","interval_str":"2016-02-06"}]}
     * errorCode : 0
     */

    private boolean success;
    private String msg;
    private String errorCode;

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
