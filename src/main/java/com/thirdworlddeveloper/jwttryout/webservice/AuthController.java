package com.thirdworlddeveloper.jwttryout.webservice;

import com.thirdworlddeveloper.jwttryout.model.JwtResponse;
import com.thirdworlddeveloper.jwttryout.model.UserAuthRequest;
import com.thirdworlddeveloper.jwttryout.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticateUser(@RequestBody UserAuthRequest userAuthRequest) throws Exception {
        log.info("The passed values for username is : "+userAuthRequest.getUsername());
        try {
            return authService.authenticateUser(userAuthRequest);
            //return new ResponseEntity<>("This is working", HttpStatus.OK);
            //throw new Exception("This is not working");
        } catch (Exception ex) {
            throw  ex;
        }
    }
}
