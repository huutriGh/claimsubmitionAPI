package phl.claim.claimsubmition.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PolicyDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ID")
    Integer id;

    @Column(name = "POLICY_NUMBER")
    String policyNumber;

    @Column(name = "PO_NAME")
    String poName;

    @Column(name = "PO_IDNUMBER")
    String poIdNumber;

    @Column(name = "PO_NUMBER")
    String poNumber;

    @Column(name = "PO_DOB")
    Date poDob;

    @Column(name = "PRODUCT_CODE")
    String productCode;

    @Column(name = "RISK_COMMENCEMENT_DATE")
    Date riskCommencementDate;

    @Column(name = "SUM_ASSURED")
    Double sumAssured;

    @Column(name = "REINS_DATE")
    Date reinsDate;

    @Column(name = "FLUP_CODES")
    String flupCode;

    @Column(name = "PAID_TO_DATE")
    Date paidToDate;

    @Column(name = "POLICY_STATUS")
    String policyStatus;

    @Column(name = "LOAN_STATUS")
    Integer loanStatus;

    @Column(name = "LA_NAME")
    String laName;

    @Column(name = "LA_IDNUMBER")
    String laIdNumber;

    @Column(name = "LA_CLIENT_NUMBER")
    String laClientNumber;

    @Column(name = "LA_DOB")
    Date laDOB;

    @Column(name = "LA_SEX")
    String laSex;

    @Column(name = "AGENT_CHANNEL")
    String agentChannel;

    @Column(name = "AGENT_NUMBER")
    String agentNumber;

    @Column(name = "AGENT_NAME")
    String agentName;

    @Column(name = "SALES_UNIT")
    String salesUnit;

    @Column(name = "AREA_NAME")
    String areaName;

    @Column(name = "BENEF_NAME")
    String benefName;

    @Column(name = "BENEF_IDNUM")
    String benefIdNum;

    @Column(name = "BENEF_IDDATE")
    Date benefIdDate;

    @Column(name = "BENEF_ADDRESS")
    String benefAddress;

    @Column(name = "LIFE_IDNUM")
    String lifeIdNum;

    @Column(name = "COMPONENT_CODE")
    String componentCode;
    @Id
    @Column(name = "LIFE")
    String life;
    @Id
    @Column(name = "COVERAGE")
    String coverage;
    @Id
    @Column(name = "RIDER")
    String rider;
    @Column(name = "COMPONENT_NAME")
    String componentName;

    public PolicyDetail() {
    }

    public PolicyDetail(Integer id, String policyNumber, String poName, String poIdNumber, String poNumber, Date poDob,
            String productCode, Date riskCommencementDate, Double sumAssured, Date reinsDate, String flupCode,
            Date paidToDate, String policyStatus, Integer loanStatus, String laName, String laIdNumber,
            String laClientNumber, Date laDOB, String laSex, String agentChannel, String agentNumber, String agentName,
            String salesUnit, String areaName, String benefName, String benefIdNum, Date benefIdDate,
            String benefAddress, String lifeIdNum, String componentCode, String life, String coverage, String rider,
            String componentName) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.poName = poName;
        this.poIdNumber = poIdNumber;
        this.poNumber = poNumber;
        this.poDob = poDob;
        this.productCode = productCode;
        this.riskCommencementDate = riskCommencementDate;
        this.sumAssured = sumAssured;
        this.reinsDate = reinsDate;
        this.flupCode = flupCode;
        this.paidToDate = paidToDate;
        this.policyStatus = policyStatus;
        this.loanStatus = loanStatus;
        this.laName = laName;
        this.laIdNumber = laIdNumber;
        this.laClientNumber = laClientNumber;
        this.laDOB = laDOB;
        this.laSex = laSex;
        this.agentChannel = agentChannel;
        this.agentNumber = agentNumber;
        this.agentName = agentName;
        this.salesUnit = salesUnit;
        this.areaName = areaName;
        this.benefName = benefName;
        this.benefIdNum = benefIdNum;
        this.benefIdDate = benefIdDate;
        this.benefAddress = benefAddress;
        this.lifeIdNum = lifeIdNum;
        this.componentCode = componentCode;
        this.life = life;
        this.coverage = coverage;
        this.rider = rider;
        this.componentName = componentName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setAuto(Integer id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return this.policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPoName() {
        return this.poName;
    }

    public void setPoName(String poName) {
        this.poName = poName;
    }

    public String getPoIdNumber() {
        return this.poIdNumber;
    }

    public void setPoIdNumber(String poIdNumber) {
        this.poIdNumber = poIdNumber;
    }

    public String getPoNumber() {
        return this.poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public Date getPoDob() {
        return this.poDob;
    }

    public void setPoDob(Date poDob) {
        this.poDob = poDob;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Date getRiskCommencementDate() {
        return this.riskCommencementDate;
    }

    public void setRiskCommencementDate(Date riskCommencementDate) {
        this.riskCommencementDate = riskCommencementDate;
    }

    public Double getSumAssured() {
        return this.sumAssured;
    }

    public void setSumAssured(Double sumAssured) {
        this.sumAssured = sumAssured;
    }

    public Date getReinsDate() {
        return this.reinsDate;
    }

    public void setReinsDate(Date reinsDate) {
        this.reinsDate = reinsDate;
    }

    public String getFlupCode() {
        return this.flupCode;
    }

    public void setFlupCode(String flupCode) {
        this.flupCode = flupCode;
    }

    public Date getPaidToDate() {
        return this.paidToDate;
    }

    public void setPaidToDate(Date paidToDate) {
        this.paidToDate = paidToDate;
    }

    public String getPolicyStatus() {
        return this.policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public Integer getLoanStatus() {
        return this.loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getLaName() {
        return this.laName;
    }

    public void setLaName(String laName) {
        this.laName = laName;
    }

    public String getLaIdNumber() {
        return this.laIdNumber;
    }

    public void setLaIdNumber(String laIdNumber) {
        this.laIdNumber = laIdNumber;
    }

    public String getLaClientNumber() {
        return this.laClientNumber;
    }

    public void setLaClientNumber(String laClientNumber) {
        this.laClientNumber = laClientNumber;
    }

    public Date getLaDOB() {
        return this.laDOB;
    }

    public void setLaDOB(Date laDOB) {
        this.laDOB = laDOB;
    }

    public String getLaSex() {
        return this.laSex;
    }

    public void setLaSex(String laSex) {
        this.laSex = laSex;
    }

    public String getAgentChannel() {
        return this.agentChannel;
    }

    public void setAgentChannel(String agentChannel) {
        this.agentChannel = agentChannel;
    }

    public String getAgentNumber() {
        return this.agentNumber;
    }

    public void setAgentNumber(String agentNumber) {
        this.agentNumber = agentNumber;
    }

    public String getAgentName() {
        return this.agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getSalesUnit() {
        return this.salesUnit;
    }

    public void setSalesUnit(String salesUnit) {
        this.salesUnit = salesUnit;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBenefName() {
        return this.benefName;
    }

    public void setBenefName(String benefName) {
        this.benefName = benefName;
    }

    public String getBenefIdNum() {
        return this.benefIdNum;
    }

    public void setBenefIdNum(String benefIdNum) {
        this.benefIdNum = benefIdNum;
    }

    public Date getBenefIdDate() {
        return this.benefIdDate;
    }

    public void setBenefIdDate(Date benefIdDate) {
        this.benefIdDate = benefIdDate;
    }

    public String getBenefAddress() {
        return this.benefAddress;
    }

    public void setBenefAddress(String benefAddress) {
        this.benefAddress = benefAddress;
    }

    public String getLifeIdNum() {
        return this.lifeIdNum;
    }

    public void setLifeIdNum(String lifeIdNum) {
        this.lifeIdNum = lifeIdNum;
    }

    public String getComponentCode() {
        return this.componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getLife() {
        return this.life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public String getCoverage() {
        return this.coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getRider() {
        return this.rider;
    }

    public void setRider(String rider) {
        this.rider = rider;
    }

    public String getComponentName() {
        return this.componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

}
