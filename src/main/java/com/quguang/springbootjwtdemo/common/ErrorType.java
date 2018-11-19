package com.quguang.springbootjwtdemo.common;

public class ErrorType extends BaseErrorType{
    public static ErrorType USERNAME_NULL_ERROR = new ErrorType("00001", "用户名不能为空");



    static{
        BaseErrorType.prefix = "PRE";
    }
    private ErrorType(String code, String msg){
        super(code, msg);
    }
}
