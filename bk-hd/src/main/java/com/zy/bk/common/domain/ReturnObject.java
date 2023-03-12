package com.zy.bk.common.domain;

public class ReturnObject {
    private Integer code;//处理成功获取失败的标记：1---成功,0---失败
    private String message;//提示信息
    private Object data;//其它数据

    private boolean success;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
