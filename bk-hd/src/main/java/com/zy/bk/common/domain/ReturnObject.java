package com.zy.bk.common.domain;

public class ReturnObject {
    private String code;//处理成功获取失败的标记：1---成功,0---失败
    private String message;//提示信息
    private Object data;//其它数据

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}