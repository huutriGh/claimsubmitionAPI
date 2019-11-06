package phl.claim.claimsubmition.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import phl.claim.claimsubmition.models.Policy;

/**
 * JWTUserDetailsService implements the Spring Security UserDetailsService
 * interface. It overrides the loadUserByUsername for fetching user details from
 * the database using the username. The Spring Security Authentication Manager
 * calls this method for getting the user details from the database when
 * authenticating the user details provided by the user. Here we are getting the
 * user details from a hardcoded User List
 */

@Service
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    PolicyService policyService;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Policy policy = policyService.getPolicyByPoNumber(username);
        if (policy != null) {
            return new User(policy.getPolicyNumber(), bcryptEncoder.encode(policy.getLaIdNumber()), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public UserDetails loadUser(String username, String password) throws UsernameNotFoundException {

        Policy policy = policyService.getPolicy(username, password);
        if (policy != null) {
            return new User(policy.getPolicyNumber(), bcryptEncoder.encode(policy.getLaIdNumber()), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
