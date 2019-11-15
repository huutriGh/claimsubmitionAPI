package phl.claim.claimsubmition.models;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class PolicyHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "TRANNO")
    Integer tranno;
    @Column(name = "POLICY_NUMBER")
    String policyNumber;
    @Column(name = "COMPONENT_NAME")
    String componentName;
    @Column(name = "CLM_STATUS")
    String claimHistory;
    @Column(name = "CLM_SUBMIT_DATE")
    String clmSubmitDate;
    @Column(name = "CLM_OCCUR_DATE")
    String clmOccurDate;

    public PolicyHistory() {

    }

    public Integer getTranno() {
        return this.tranno;
    }

    public void setTranno(Integer tranno) {
        this.tranno = tranno;
    }

    public String getPolicyNumber() {
        return this.policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getComponentName() {
        return this.componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getClaimHistory() {
        return this.claimHistory;
    }

    public void setClaimHistory(String claimHistory) {
        this.claimHistory = claimHistory;
    }

    public String getClmSubmitDate() {
        return this.clmSubmitDate;
    }

    public void setClmSubmitDate(String clmSubmitDate) {
        this.clmSubmitDate = clmSubmitDate;
    }

    public String getClmOccurDate() {
        return this.clmOccurDate;
    }

    public void setClmOccurDate(String clmOccurDate) {
        this.clmOccurDate = clmOccurDate;
    }

}
