package fm.security.repository;

import fm.entity.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by ngocson on 06/04/2019
 */
@Repository
public interface testrepository extends CrudRepository<Product, Long> {
}
