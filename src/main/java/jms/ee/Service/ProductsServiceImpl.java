package jms.ee.Service;


import jms.ee.AdProduct;
import org.richfaces.cdi.push.Push;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apenchukov on 5/4/2017.
 */
@Stateless(name = "productService")
public class ProductsServiceImpl implements ProductsService {
    private static final String DO_UPDATE = "doUpdate";

    @Inject
    private PushService pushService;

    private static List<AdProduct> products;

    @Override
    public void updateProductsList(AdProduct[] productsList) {
        products = Arrays.asList(productsList);
        pushService.setMessage(DO_UPDATE);
        pushService.sendMessage();
    }

    @Override
    public List<AdProduct> getAll() {
        return products;
    }

}
