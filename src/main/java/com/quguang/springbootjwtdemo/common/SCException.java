package com.quguang.springbootjwtdemo.common;

import lombok.Data;

/**
 * Created by 瞿广 on 2018/11/17 0017.
 */
@Data
public class SCException extends RuntimeException {
    private BaseErrorType errorType;
    private String msg;
    private Object data;

    public SCException(BaseErrorType errorType, String msg) {
        this.errorType = errorType;
        this.msg = msg;
    }

    public SCException(String msg, BaseErrorType errorType) {
        this.errorType = errorType;
        this.msg = msg;
    }

    public SCException(Object data, BaseErrorType errorType, String msg) {
        this.errorType = errorType;
        this.msg = msg;
        this.data = data;
    }



}
