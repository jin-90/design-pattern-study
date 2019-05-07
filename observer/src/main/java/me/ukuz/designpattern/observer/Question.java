package me.ukuz.designpattern.observer;

import lombok.Data;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
@Data
public class Question {

    private Label label;
    private String title;
    private String content;
    private Gper founder;

}
