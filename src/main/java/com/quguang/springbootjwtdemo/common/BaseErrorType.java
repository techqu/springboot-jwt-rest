package com.quguang.springbootjwtdemo.common;

/**
 * Created by 瞿广 on 2018/11/17 0017.
 */
public class BaseErrorType {
    public static BaseErrorType PARAM_NULL_ERROR = new BaseErrorType("D0001", "参数为空");
    public static BaseErrorType CLIENT_INVOKE_ERROR = new BaseErrorType("D0002", "获取流水号失败");
    public static BaseErrorType CONFIG_NULL_ERROR = new BaseErrorType("D0003", "配置对象为空");
    public static BaseErrorType SAVE_ERROR = new BaseErrorType("D0004", "保存失败");
    public static BaseErrorType OBJECT_NOT_EXISTS_ERROR = new BaseErrorType("D0005", "数据不存在");
    public static BaseErrorType OBJECT_EXISTS_ERROR = new BaseErrorType("D0006", "数据已存在");
    public static BaseErrorType CONFIG_ERROR = new BaseErrorType("D0007", "配置不正确");
    public static BaseErrorType HTTP_REST_ERROR = new BaseErrorType("D0008", "调用远程rest接口异常");
    public static BaseErrorType OPERATE_ERROR = new BaseErrorType("D0100", "操作异常");
    public static BaseErrorType USER_INFO_NULL_ERROR = new BaseErrorType("D0101", "您的帐号，无数据权限，请联系管理员。");
    public static BaseErrorType NO_AUTHENTICATION = new BaseErrorType("D0102", "您的帐号，无数据权限，请联系管理员。");
    private String code;
    private String message;
    public static String prefix = "DEF";

    protected BaseErrorType() {
    }

    public BaseErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return prefix + this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return "BaseErrorType{code='" + this.code + '\'' + ", message='" + this.message + '\'' + '}';
    }
}
