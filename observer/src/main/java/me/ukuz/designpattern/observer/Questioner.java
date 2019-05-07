package me.ukuz.designpattern.observer;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author ukuz90
 * @date 2019-03-20
 */
@Data
public class Questioner implements Gper {

    static EventBus eventBus;
    static {
        AtomicInteger threadCount = new AtomicInteger();
        ThreadFactory threadFactory = r -> new Thread("my-event-bus" + threadCount.incrementAndGet());
        Executor threadPool = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), threadFactory);

        eventBus = new AsyncEventBus(threadPool);
    }

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
        labels.addAll(Arrays.asList(label));
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
