package me.ukuz.designpattern.strategy;

import me.ukuz.designpattern.strategy.dto.LoginRequest;
import me.ukuz.designpattern.strategy.dto.LoginResponseEnum;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
public interface LoginStrategy<T extends LoginRequest> {

    boolean support(LoginRequest request);

    LoginResponseEnum login(T request);

}
