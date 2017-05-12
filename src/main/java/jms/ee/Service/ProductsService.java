package jms.ee.Service;

import jms.ee.AdProduct;

import java.util.List;

/**
 * Created by alexpench on 05.05.17.
 */
public interface ProductsService {

    void updateProductsList(AdProduct[] productsList);
    List<AdProduct> getAll();

}
