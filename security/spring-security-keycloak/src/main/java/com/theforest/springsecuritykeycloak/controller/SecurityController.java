package com.theforest.springsecuritykeycloak.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SecurityController implements SecurityControllerApi {

    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public String check() {
        return "OK";
    }
}
