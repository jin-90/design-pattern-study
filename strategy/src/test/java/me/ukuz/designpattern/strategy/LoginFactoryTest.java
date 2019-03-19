package me.ukuz.designpattern.strategy;

import me.ukuz.designpattern.strategy.dto.LoginResponseEnum;
import me.ukuz.designpattern.strategy.dto.QQLoginRequest;
import me.ukuz.designpattern.strategy.dto.WechatLoginRequest;
import org.junit.Assert;
import org.junit.Test;


public class LoginFactoryTest {

    @Test
    public void testLogin() {
        QQLoginRequest qqLogin = new QQLoginRequest();
        qqLogin.setUserName("aaaaa");
        qqLogin.setPassword("123456");
        Assert.assertEquals(LoginResponseEnum.SUCCESS, LoginFactory.getInstance().login(qqLogin));

        WechatLoginRequest wechatLogin = new WechatLoginRequest();
        wechatLogin.setCode("12312313");
        Assert.assertEquals(LoginResponseEnum.SUCCESS, LoginFactory.getInstance().login(wechatLogin));
    }

}