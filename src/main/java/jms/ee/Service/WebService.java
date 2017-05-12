package jms.ee.Service;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import jms.ee.AdProduct;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by alexpench on 05.05.17.
 */
@Stateless(name = "webService")
public class WebService {
    @Inject
    private ProductsService productsService;


    public void getProductsFromMainApp() {
        DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
        defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
        Client client = Client.create(defaultClientConfig);
        WebResource webResource = client.resource("http://localhost:8080/productslist");
        ClientResponse resp = webResource.accept("application/json").get(ClientResponse.class);
        AdProduct[] productsList = resp.getEntity(AdProduct[].class);
        System.out.println(productsList);
        updatePromoProductsList(productsList);
    }

    private void updatePromoProductsList(AdProduct[] productsList) {
        productsService.updateProductsList(productsList);
    }
}
