package com.theforest.springsecuritykeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;


public interface SecurityControllerApi {


    @GetMapping("/check")
    String check();
}
