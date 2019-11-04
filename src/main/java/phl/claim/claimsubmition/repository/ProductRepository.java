
package phl.claim.claimsubmition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import phl.claim.claimsubmition.models.*;
@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{
    
}