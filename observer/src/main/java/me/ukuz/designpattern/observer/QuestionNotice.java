package me.ukuz.designpattern.observer;

import com.google.common.eventbus.Subscribe;
import lombok.Data;

/**
 * @description:
 * @author: ukuz90(171282084 @ qq.com)
 * @create: 2019-03-20 01:06
 */
@Data
public class QuestionNotice {

    private Gper owner;

    @Subscribe
    public void notice(Question question) {
        //自己的发的问题，自己不接收
        if (question.getFounder() == this) {
            return;
        }
        //不感兴趣的标签对应的问题不接收
        if (!this.owner.hasInterest(question.getLabel())) {
            return;
        }
        String description = this.getOwner().getName() + "收到提问来自 [" + question.getFounder().getName() + "] 的提问\n" +
                "标题: " + question.getTitle() + "\n" +
                "内容: " + question.getContent() + "\n";
        System.out.println(description);
    }

}
