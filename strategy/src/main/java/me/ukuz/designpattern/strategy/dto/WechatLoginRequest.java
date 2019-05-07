package me.ukuz.designpattern.strategy.dto;

import lombok.Data;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
@Data
public class WechatLoginRequest implements LoginRequest {

    private String code;

}
