
package phl.claim.claimsubmition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import phl.claim.claimsubmition.models.ClaimSubmition;

@Repository
public interface ClaimSubmitionRespository extends CrudRepository<ClaimSubmition, Integer> {

}