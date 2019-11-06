package phl.claim.claimsubmition.models;

import java.io.Serializable;

/**
 * This class is required for storing the username and password we recieve from
 * the client.
 */

public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;

    private String policyNumber;
    private String idNumber;

    // need default constructor for JSON Parsing
    public JwtRequest() {

    }

    public JwtRequest(String policyNumber, String idNumber) {
        this.setPolicyNumber(policyNumber);
        this.setIdNumber(idNumber);
    }

    public String getPolicyNumber() {
        return this.policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}