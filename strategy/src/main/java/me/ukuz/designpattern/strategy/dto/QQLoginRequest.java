package me.ukuz.designpattern.strategy.dto;

import lombok.Data;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
@Data
public class QQLoginRequest implements LoginRequest {

    private String userName;
    private String password;

}
