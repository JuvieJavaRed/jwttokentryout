package com.thirdworlddeveloper.jwttryout.service;

import com.thirdworlddeveloper.jwttryout.model.JwtResponse;
import com.thirdworlddeveloper.jwttryout.model.UserAuthRequest;
import com.thirdworlddeveloper.jwttryout.utility.JwtUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    private final JwtUtility jwtUtility;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    @Autowired
    public AuthService(JwtUtility jwtUtility, AuthenticationManager authenticationManager, UserService userService) {
        this.jwtUtility = jwtUtility;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    public JwtResponse authenticateUser(UserAuthRequest userAuthRequest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthRequest.getUsername(), userAuthRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception("INVALID CREDENTIALS EXCEPTION", ex);
        }

        final UserDetails userDetails = userService.loadUserByUsername(userAuthRequest.getUsername());

        final String jwtToken = jwtUtility.generateToken(userDetails);

        JwtResponse jwtResponse = new JwtResponse(jwtToken);
        log.info("The generated token is "+jwtResponse.getJwtToken());
        return jwtResponse;

    }


}
