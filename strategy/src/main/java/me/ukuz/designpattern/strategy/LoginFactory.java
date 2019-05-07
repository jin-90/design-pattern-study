package me.ukuz.designpattern.strategy;

import me.ukuz.designpattern.strategy.dto.LoginRequest;
import me.ukuz.designpattern.strategy.dto.LoginResponseEnum;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
public enum LoginFactory {

    /**
     * 枚举式单例
     */
    INSTANCE;

    private ServiceLoader<LoginStrategy> serviceLoaders = ServiceLoader.load(LoginStrategy.class);

    public static LoginFactory getInstance() {
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
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
