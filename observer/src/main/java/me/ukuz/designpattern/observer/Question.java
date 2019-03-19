package me.ukuz.designpattern.observer;

import lombok.Data;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-20 00:28
 */
@Data
public class Question {

    private Label label;
    private String title;
    private String content;
    private Gper founder;

}
