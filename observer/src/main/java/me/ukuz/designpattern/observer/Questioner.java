package me.ukuz.designpattern.observer;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-20 00:37
 */
@Data
public class Questioner implements Gper {

    static EventBus eventBus = new AsyncEventBus(new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>()));

    private String name;
    private Set<Label> labels;

    public Questioner(String name) {
        this.name = name;
        this.labels = new HashSet<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void interest(Label...label) {
        Stream.of(label).forEach(this.labels::add);
        QuestionNotice qn = new QuestionNotice();
        qn.setOwner(this);
        eventBus.register(qn);
    }

    @Override
    public void send(Question question) {
        question.setFounder(this);
        String description = this.getName() + "发起提问\n";
        System.out.println(description);
        eventBus.post(question);
    }

    @Override
    public boolean hasInterest(Label label) {
        return this.labels.contains(label);
    }

}
