package me.ukuz.designpattern.strategy;

import me.ukuz.designpattern.strategy.dto.LoginRequest;
import me.ukuz.designpattern.strategy.dto.LoginResponseEnum;
import me.ukuz.designpattern.strategy.dto.WechatLoginRequest;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-20 01:58
 */
public class WechatLoginStrategy implements LoginStrategy<WechatLoginRequest> {

    @Override
    public boolean support(LoginRequest request) {
        return request instanceof WechatLoginRequest;
    }

    @Override
    public LoginResponseEnum login(WechatLoginRequest request) {
        System.out.println("使用微信登录: code[" + request.getCode() + "]");
        return LoginResponseEnum.SUCCESS;
    }
}
