package me.ukuz.designpattern.observer;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
public class QuestionDemo {

    public static void main(String[] args) {
        Questioner a = new Questioner("小A");

        Questioner b = new Questioner("小B");
        b.interest(Label.DESIGN_PATTERN);

        Question question1 = new Question();
        question1.setLabel(Label.DESIGN_PATTERN);
        question1.setTitle("设计模式的疑问");
        question1.setContent("装饰者模式和适配器模式的根本区别");
        a.send(question1);

    }

}
