package jms.ee;

import jms.ee.Service.WebService;

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
public class Listener implements MessageListener {
    private static final String DO_UPDATE = "doUpdate";

    @Inject
    private  WebService webService;

    @Override
    public void onMessage(Message message) {
        try {
            if(message.getBody(String.class).equals(DO_UPDATE)){
            webService.getProductsFromMainApp();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
