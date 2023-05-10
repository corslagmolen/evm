package com.hyparxis.evm.evmApplication.Controllers;

import com.hyparxis.evm.evmApplication.Services.AuthenticationService;
import com.hyparxis.evm.evmApplication.auth.AuthenticationRequest;
import com.hyparxis.evm.evmApplication.auth.AuthenticationResponse;
import com.hyparxis.evm.evmApplication.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        LOGGER.info("Inside Register of AuthenticationController");
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        LOGGER.info("Inside Authenticate of AuthenticationController" + request);
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }


}
