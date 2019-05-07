package me.ukuz.designpattern.observer;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
public enum Label {
    /**
     * 设计模式
     */
    DESIGN_PATTERN("设计模式"),
    /**
     * JAVA编程
     */
    JAVA_PROGRAMING("JAVA编程");
    private String desc;

    private Label(String desc){
        this.desc = desc;
    }
}
