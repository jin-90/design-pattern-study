package me.ukuz.designpattern.strategy;

import me.ukuz.designpattern.strategy.dto.LoginRequest;
import me.ukuz.designpattern.strategy.dto.LoginResponseEnum;

public interface LoginStrategy<T extends LoginRequest> {

    boolean support(LoginRequest request);

    LoginResponseEnum login(T request);

}
