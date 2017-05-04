package jms.ee.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "Listener1", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/linusq"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class FirstListener implements MessageListener {
    @Inject
    AdProductsService adProductsService;
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(getClass().getSimpleName() + " >>>>>>>> " + message.getBody(String.class));
            adProductsService.getProductsFromMainApp();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
