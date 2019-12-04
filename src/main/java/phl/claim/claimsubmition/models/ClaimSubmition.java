package phl.claim.claimsubmition.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "R_Claim_Submition")
public class ClaimSubmition implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    @Column(name = "PO_NUMBER")
    String poNumber;
    @Column(name = "LA_NAME")
    String laName;

    @Column(name = "LA_IDNUMBER")
    String laIdNumber;
    @Column(name = "LA_ADDRESS")
    String laAddress;

    @Column(name = "LA_PHONE")
    String laPhone;
    @Column(name = "RQ_NAME")
    String rqName;

    @Column(name = "RQ_IDNUMBER")
    String rqIdNumber;
    @Column(name = "RQ_ADDRESS")
    String rqAddress;
    @Column(name = "RQ_PHONE")
    String rqPhone;

    @Column(name = "EVENT_DATE")
    Date eventDate;
    @Column(name = "EVENT_PLACE")
    String eventPlace;
    @Column(name = "EVENT_REASON")
    String eventReason;

    @Column(name = "BENIFIT_TYPE")
    String benifitType;
    @Column(name = "HOSPITALIZED_DATE_IN")
    Date dateIn;
    @Column(name = "HOSPITALIZED_DATE_OUT")
    Date dateOut;

    @Column(name = "DIAGONOSTIC")
    String diagonostic;
    @Column(name = "HOSPITAL")
    String hospital;
    @Column(name = "DOCTOR")
    String doctor;

    @Column(name = "HOSPITAL_HEALTHINS")
    String hospitalHealthIns;
    @Column(name = "EVENT_DISCRIPTION")
    String eventDiscription;
    @Column(name = "PAYMENT_MOTHOD")
    String paymentMothod;

    @Column(name = "ACCOUNT_NAME")
    String accountName;
    @Column(name = "ACCOUNT_IDCARD_DATE")
    Date accountIdCardDate;
    @Column(name = "ACCOUNT_IDCARD")
    String accountIdCard;

    @Column(name = "ACCOUNT_NUMBER")
    String accountNumber;
    @Column(name = "ACCOUNT_HOLDER")
    String accountHolder;
    @Column(name = "ORTHER_INSURANCE")
    String ortherInsurance;

    @Column(name = "ISR1_NAME")
    String isr1Name;
    @Column(name = "ISR1_EFF_DATE")
    Date isr1EffDate;
    @Column(name = "ISR1_AMOUNT")
    String isr1Amount;

    @Column(name = "ISR2_NAME")
    String isr2Name;
    @Column(name = "ISR2_EFF_DATE")
    String isr2EffDate;
    @Column(name = "ISR2_AMOUNT")
    String isr2Amount;

    @Column(name = "DATE_SUBMIT")
    Date dateSubmit;
    @Column(name = "DATE_UPDATE")
    Date dateUpdate;
    @Column(name = "DATE_DELETE")
    Date dateDelete;
    @Column(name = "BANK")
    String bank;
    @Column(name = "STATUS")
    String status;
    @Column(name = "IMAGE_PATH")
    String imagePath;

    public String getBank() {
        return this.bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoNumber() {
        return this.poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
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

    public String getLaAddress() {
        return this.laAddress;
    }

    public void setLaAddress(String laAddress) {
        this.laAddress = laAddress;
    }

    public String getLaPhone() {
        return this.laPhone;
    }

    public void setLaPhone(String laPhone) {
        this.laPhone = laPhone;
    }

    public String getRqName() {
        return this.rqName;
    }

    public void setRqName(String rqName) {
        this.rqName = rqName;
    }

    public String getRqIdNumber() {
        return this.rqIdNumber;
    }

    public void setRqIdNumber(String rqIdNumber) {
        this.rqIdNumber = rqIdNumber;
    }

    public String getRqAddress() {
        return this.rqAddress;
    }

    public void setRqAddress(String rqAddress) {
        this.rqAddress = rqAddress;
    }

    public String getRqPhone() {
        return this.rqPhone;
    }

    public void setRqPhone(String rqPhone) {
        this.rqPhone = rqPhone;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPlace() {
        return this.eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventReason() {
        return this.eventReason;
    }

    public void setEventReason(String eventReason) {
        this.eventReason = eventReason;
    }

    public String getBenifitType() {
        return this.benifitType;
    }

    public void setBenifitType(String benifitType) {
        this.benifitType = benifitType;
    }

    public Date getDateIn() {
        return this.dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return this.dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public String getDiagonostic() {
        return this.diagonostic;
    }

    public void setDiagonostic(String diagonostic) {
        this.diagonostic = diagonostic;
    }

    public String getHospital() {
        return this.hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDoctor() {
        return this.doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getHospitalHealthIns() {
        return this.hospitalHealthIns;
    }

    public void setHospitalHealthIns(String hospitalHealthIns) {
        this.hospitalHealthIns = hospitalHealthIns;
    }

    public String getEventDiscription() {
        return this.eventDiscription;
    }

    public void setEventDiscription(String eventDiscription) {
        this.eventDiscription = eventDiscription;
    }

    public String getPaymentMothod() {
        return this.paymentMothod;
    }

    public void setPaymentMothod(String paymentMothod) {
        this.paymentMothod = paymentMothod;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getAccountIdCardDate() {
        return this.accountIdCardDate;
    }

    public void setAccountIdCardDate(Date accountIdCardDate) {
        this.accountIdCardDate = accountIdCardDate;
    }

    public String getAccountIdCard() {
        return this.accountIdCard;
    }

    public void setAccountIdCard(String accountIdCard) {
        this.accountIdCard = accountIdCard;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getOrtherInsurance() {
        return this.ortherInsurance;
    }

    public void setOrtherInsurance(String ortherInsurance) {
        this.ortherInsurance = ortherInsurance;
    }

    public String getIsr1Name() {
        return this.isr1Name;
    }

    public void setIsr1Name(String isr1Name) {
        this.isr1Name = isr1Name;
    }

    public Date getIsr1EffDate() {
        return this.isr1EffDate;
    }

    public void setIsr1EffDate(Date isr1EffDate) {
        this.isr1EffDate = isr1EffDate;
    }

    public String getIsr1Amount() {
        return this.isr1Amount;
    }

    public void setIsr1Amount(String isr1Amount) {
        this.isr1Amount = isr1Amount;
    }

    public String getIsr2Name() {
        return this.isr2Name;
    }

    public void setIsr2Name(String isr2Name) {
        this.isr2Name = isr2Name;
    }

    public String getIsr2EffDate() {
        return this.isr2EffDate;
    }

    public void setIsr2EffDate(String isr2EffDate) {
        this.isr2EffDate = isr2EffDate;
    }

    public String getIsr2Amount() {
        return this.isr2Amount;
    }

    public void setIsr2Amount(String isr2Amount) {
        this.isr2Amount = isr2Amount;
    }

    public Date getDateSubmit() {
        return this.dateSubmit;
    }

    public void setDateSubmit(Date dateSummit) {
        this.dateSubmit = dateSummit;
    }

    public Date getDateUpdate() {
        return this.dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Date getDateDelete() {
        return this.dateDelete;
    }

    public void setDateDelete(Date dateDelete) {
        this.dateDelete = dateDelete;
    }

    public ClaimSubmition() {
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClaimSubmition)) {
            return false;
        }
        ClaimSubmition claimSubmition = (ClaimSubmition) o;
        return Objects.equals(id, claimSubmition.id) && Objects.equals(poNumber, claimSubmition.poNumber)
                && Objects.equals(laName, claimSubmition.laName)
                && Objects.equals(laIdNumber, claimSubmition.laIdNumber)
                && Objects.equals(laAddress, claimSubmition.laAddress)
                && Objects.equals(laPhone, claimSubmition.laPhone) && Objects.equals(rqName, claimSubmition.rqName)
                && Objects.equals(rqIdNumber, claimSubmition.rqIdNumber)
                && Objects.equals(rqAddress, claimSubmition.rqAddress)
                && Objects.equals(rqPhone, claimSubmition.rqPhone)
                && Objects.equals(eventDate, claimSubmition.eventDate)
                && Objects.equals(eventPlace, claimSubmition.eventPlace)
                && Objects.equals(eventReason, claimSubmition.eventReason)
                && Objects.equals(benifitType, claimSubmition.benifitType)
                && Objects.equals(dateIn, claimSubmition.dateIn) && Objects.equals(dateOut, claimSubmition.dateOut)
                && Objects.equals(diagonostic, claimSubmition.diagonostic)
                && Objects.equals(hospital, claimSubmition.hospital) && Objects.equals(doctor, claimSubmition.doctor)
                && Objects.equals(hospitalHealthIns, claimSubmition.hospitalHealthIns)
                && Objects.equals(eventDiscription, claimSubmition.eventDiscription)
                && Objects.equals(paymentMothod, claimSubmition.paymentMothod)
                && Objects.equals(accountName, claimSubmition.accountName)
                && Objects.equals(accountIdCardDate, claimSubmition.accountIdCardDate)
                && Objects.equals(accountIdCard, claimSubmition.accountIdCard)
                && Objects.equals(accountNumber, claimSubmition.accountNumber)
                && Objects.equals(accountHolder, claimSubmition.accountHolder)
                && Objects.equals(ortherInsurance, claimSubmition.ortherInsurance)
                && Objects.equals(isr1Name, claimSubmition.isr1Name)
                && Objects.equals(isr1EffDate, claimSubmition.isr1EffDate)
                && Objects.equals(isr1Amount, claimSubmition.isr1Amount)
                && Objects.equals(isr2Name, claimSubmition.isr2Name)
                && Objects.equals(isr2EffDate, claimSubmition.isr2EffDate)
                && Objects.equals(isr2Amount, claimSubmition.isr2Amount)
                && Objects.equals(dateSubmit, claimSubmition.dateSubmit)
                && Objects.equals(dateUpdate, claimSubmition.dateUpdate)
                && Objects.equals(dateDelete, claimSubmition.dateDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, poNumber, laName, laIdNumber, laAddress, laPhone, rqName, rqIdNumber, rqAddress,
                rqPhone, eventDate, eventPlace, eventReason, benifitType, dateIn, dateOut, diagonostic, hospital,
                doctor, hospitalHealthIns, eventDiscription, paymentMothod, accountName, accountIdCardDate,
                accountIdCard, accountNumber, accountHolder, ortherInsurance, isr1Name, isr1EffDate, isr1Amount,
                isr2Name, isr2EffDate, isr2Amount, dateSubmit, dateUpdate, dateDelete);
    }

}