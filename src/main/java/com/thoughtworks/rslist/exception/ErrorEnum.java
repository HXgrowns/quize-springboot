package com.thoughtworks.rslist.exception;

public enum ErrorEnum {
    UNKNOWN_ERROR(-1, "未知错误"),
    BUSSINESS_ERROR(1, "业务错误")
    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
