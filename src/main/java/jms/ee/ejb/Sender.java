package jms.ee.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;


@Stateless
public class Sender {

    @Inject
    private JMSContext context;

    @Resource(mappedName = "java:/jms/queue/linusq")
    private Queue queue;

    public void sendMessage(String text) {
        System.out.println("Sending " + text);
        context.createProducer().send(queue, text);
    }

}
