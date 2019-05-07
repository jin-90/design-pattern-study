package me.ukuz.designpattern.strategy.dto;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
public enum LoginResponseEnum {
    /**
     * 登录成功
     */
    SUCCESS("000000", "登录成功"),
    /**
     * 不支持的登录方式
     */
    NOT_SUPPORT("000001", "不支持的登录方式"),
    /**
     * 登录失败
     */
    LOGIN_FAIL("000002", "登录失败"),
            ;
    private String code;
    private String msg;

    LoginResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
