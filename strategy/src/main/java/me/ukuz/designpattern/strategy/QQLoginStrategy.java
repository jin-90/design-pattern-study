package me.ukuz.designpattern.strategy;

import me.ukuz.designpattern.strategy.dto.LoginRequest;
import me.ukuz.designpattern.strategy.dto.LoginResponseEnum;
import me.ukuz.designpattern.strategy.dto.QQLoginRequest;
import me.ukuz.designpattern.strategy.dto.WechatLoginRequest;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
public class QQLoginStrategy implements LoginStrategy<QQLoginRequest> {

    @Override
    public boolean support(LoginRequest request) {
        return request instanceof QQLoginRequest;
    }

    @Override
    public LoginResponseEnum login(QQLoginRequest request) {
        System.out.println("使用QQ登录: UserName[" + request.getUserName() + "], Password[" + request.getPassword() + "]");
        return LoginResponseEnum.SUCCESS;
    }
}
