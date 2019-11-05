package phl.claim.claimsubmition.services;

import java.util.List;

import phl.claim.claimsubmition.models.Policy;
import phl.claim.claimsubmition.models.PolicyDetail;

public interface PolicyService {
    Policy getPolicy(String poNumber, String laIdNumber);

    List<PolicyDetail> getPoObject(String poNumber, String laIdNumber);

}