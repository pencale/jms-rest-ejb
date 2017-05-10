package jms.ee.ejb.Service;


import jms.ee.ejb.AdProduct;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apenchukov on 5/4/2017.
 */
@Stateless(name = "productService")
public class ProductsServiceImpl implements ProductsService {
    private static List<AdProduct> products;

    @Override
    public void updateProductsList(AdProduct[] productsList) {
        products = Arrays.asList(productsList);
        products.forEach(System.out::println);
    }

    @Override
    public List<AdProduct> getAll() {
        return products;
    }
}
