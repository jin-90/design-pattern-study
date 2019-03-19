package me.ukuz.designpattern.observer;

public enum Label {
    DESIGN_PATTERN("设计模式"),
    JAVA_PROGRAMING("JAVA编程");
    private String desc;

    private Label(String desc){
        this.desc = desc;
    }
}
