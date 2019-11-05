package phl.claim.claimsubmition.controllers;

import java.util.List;

//import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import phl.claim.claimsubmition.models.PolicyDetail;
import phl.claim.claimsubmition.services.PolicyService;

@RestController
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @RequestMapping(value = "/policy/{poNumber}/{cardId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findPolicy(@PathVariable("poNumber") String poNumber,
            @PathVariable("cardId") String cardId) {

        List<PolicyDetail> policyDetail = policyService.getPoObject(poNumber, cardId);
        if (policyDetail == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(policyDetail, HttpStatus.OK);

    }

}