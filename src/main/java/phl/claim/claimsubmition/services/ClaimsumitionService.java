
package phl.claim.claimsubmition.services;

import java.util.List;

import phl.claim.claimsubmition.models.ClaimSubmition;

public interface ClaimsumitionService {
    List<ClaimSubmition> findAll(String poNumber, String laIdNumber);

    ClaimSubmition findById(Integer id);

    void save(ClaimSubmition claim);

    void remove(ClaimSubmition claim);
}