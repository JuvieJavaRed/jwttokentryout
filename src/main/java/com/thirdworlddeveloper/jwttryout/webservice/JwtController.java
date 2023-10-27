package com.thirdworlddeveloper.jwttryout.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class JwtController {


    @GetMapping("/tryout")
    public ResponseEntity<?> getMyString() {
        log.info("This is working ........");
        return new ResponseEntity<>("This jwt has passed", HttpStatus.OK);
    }
}
