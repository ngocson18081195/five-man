package fm.security.service;

import base.service.base.BaseService;
import fm.entity.Product.Product;
import org.springframework.stereotype.Service;

/**
 * Create by ngocson on 27/01/2019
 */
@Service
public class securityService extends BaseService {

    @Override
    public void create() {
        Product product = new Product();
        product.setName("asdasd");
    }
}
