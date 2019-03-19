package me.ukuz.designpattern.strategy;

import me.ukuz.designpattern.strategy.dto.LoginRequest;
import me.ukuz.designpattern.strategy.dto.LoginResponseEnum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.stream.Stream;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-20 02:05
 */
public enum LoginFactory {

    INSTANCE;

    private ServiceLoader<LoginStrategy> serviceLoaders = ServiceLoader.load(LoginStrategy.class);

    public static LoginFactory getInstance() {
        return INSTANCE;
    }

    public LoginResponseEnum login(LoginRequest loginRequest) {
        Iterator<LoginStrategy> iter = serviceLoaders.iterator();
        while (iter.hasNext()) {
            LoginStrategy loginStrategy = iter.next();
            if (loginStrategy.support(loginRequest)) {
                return loginStrategy.login(loginRequest);
            }
        }
        return LoginResponseEnum.NOT_SUPPORT;
    }


}
