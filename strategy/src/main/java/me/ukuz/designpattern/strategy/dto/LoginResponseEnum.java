package me.ukuz.designpattern.strategy.dto;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-20 01:49
 */
public enum LoginResponseEnum {
    SUCCESS("000000", "登录成功"),
    NOT_SUPPORT("000001", "不支持的登录方式"),
    LOGIN_FAIL("000002", "登录失败"),
            ;
    private String code;
    private String msg;

    LoginResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
