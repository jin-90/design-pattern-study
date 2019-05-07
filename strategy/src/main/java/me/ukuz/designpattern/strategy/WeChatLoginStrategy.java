package me.ukuz.designpattern.strategy;

import me.ukuz.designpattern.strategy.dto.LoginRequest;
import me.ukuz.designpattern.strategy.dto.LoginResponseEnum;
import me.ukuz.designpattern.strategy.dto.WechatLoginRequest;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
public class WeChatLoginStrategy implements LoginStrategy<WechatLoginRequest> {

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
