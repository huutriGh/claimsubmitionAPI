
package phl.claim.claimsubmition.services;

import phl.claim.claimsubmition.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAlProducts();

    Optional<Product> findById(Integer id);

    void save(Product product);

    void remove(Product product);
}