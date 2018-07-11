package com.roy.tools.constant;

/**
 * @Description: 信息码
 * @Date: Created in 9:39 2018/4/10
 */
public enum StatusCode {

	SYSTEM_ERROR(500, "系统错误"),
	PARAMETER_CHECK_ERROR(400, "参数校验错误"),
    AUTH_VALID_ERROR(401, "用户权限不足"),

    //大于6开头的数字是自定义信息以及错误
    LOGIN_ERROR(6001, "用户名或密码错误"),
    UNLOGIN_ERROR(6002, "用户未登录或登录状态超时失效"),
    VCODE_ERROR(6003, "验证码错误"),
    LOGIN_UNKNOW_ERROR(6099, "用户登录未知错误"),

    REGISTER_OK(7000,"注册成功"),
	REGISTER_FAIL(7001,"注册失败"),
    REGISTER_EXIST(7002,"该用户已注册"),

    SYSTEM_UNKNOW_ERROR(9999,"系统错误码未知错误"),

    ;
    private final Integer value;
    private final String message;

    StatusCode(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public String getCode() {
        return value.toString();
    }

    public static StatusCode getByCode(Integer value) {
        for (StatusCode _enum : values()) {
            if (_enum.getValue() == value) {
                return _enum;
            }
        }
        return null;
    }

    public static StatusCode getByCodeStr(String codeStr) {
        int code = SYSTEM_UNKNOW_ERROR.value;
        try {
            code = Integer.parseInt(codeStr);
        } catch (Exception e) {
        }
        return getByCode(code);
    }

}