package me.ukuz.designpattern.strategy.dto;

import lombok.Data;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-20 02:04
 */
@Data
public class QQLoginRequest implements LoginRequest {

    private String userName;
    private String password;

}
