package phl.claim.claimsubmition.services;

import java.util.List;

import phl.claim.claimsubmition.models.PolicyDetail;

public interface PolicyService {

    List<PolicyDetail> getPoObject(String poNumber, String laIdNumber);

}