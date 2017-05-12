package jms.ee.Service;

import org.richfaces.cdi.push.Push;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Created by apenchukov on 5/12/2017.
 */
@Stateless
public class PushService {
    private static final String PUSH_CDI_TOPIC = "pushCdi";
    private String message;

    @Inject
    @Push(topic = PUSH_CDI_TOPIC)
    Event<String> pushEvent;

    public void sendMessage() {
        pushEvent.fire(message);
        message = "";
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
