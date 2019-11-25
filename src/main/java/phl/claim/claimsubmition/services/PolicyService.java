package phl.claim.claimsubmition.services;

import java.util.List;

import phl.claim.claimsubmition.models.Policy;
import phl.claim.claimsubmition.models.PolicyDetail;
import phl.claim.claimsubmition.models.PolicyHistory;

public interface PolicyService {

    List<PolicyDetail> getPolicyDetail(String poNumber, String poIdNumber);

    Policy getPolicy(String poNumber, String poIdNumber);

    Policy getPolicyByPoNumber(String poNumber);

    List<PolicyHistory> getPolicyHistory(String poNumber);

}