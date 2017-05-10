package jms.ee.ejb.ManagedBeans;

import jms.ee.ejb.AdProduct;
import jms.ee.ejb.Service.ProductsService;
import jms.ee.ejb.Service.WebService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by alexpench on 06.05.17.
 */
@ManagedBean(name = "mainBean")
@ApplicationScoped
public class MainBean {
    @Inject
    private ProductsService productsService;

    @Inject
    private WebService webService;

    @PostConstruct
    private void init(){
        webService.getProductsFromMainApp();
    }

    public List<AdProduct> getPromoProducts(){
       return productsService.getAll();
    }
}