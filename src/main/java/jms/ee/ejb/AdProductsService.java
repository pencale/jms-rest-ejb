package jms.ee.ejb;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apenchukov on 5/4/2017.
 */
@Stateful
public class AdProductsService {

    private List<AdProduct> products = new ArrayList<>();
    public void getProductsFromMainApp(){
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/productslist");
        ClientResponse resp = webResource.accept("application/json").get(ClientResponse.class);
        String out = resp.getEntity(String.class);

        System.out.println(out);
    }
}
