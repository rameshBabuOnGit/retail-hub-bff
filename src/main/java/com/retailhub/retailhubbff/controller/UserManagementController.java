package com.retailhub.retailhubbff.controller;

import com.retailhub.retailhubbff.service.ProductManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserManagementController {

    private final ProductManagementService productManagementService;

    public UserManagementController(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    @GetMapping(value = "/authentication/{userName}")
    public ResponseEntity<String> authenticateUser(@PathVariable String userName, @RequestParam String password) {
        return new ResponseEntity<>(productManagementService.authenticateUser(userName, password), HttpStatus.OK);
    }
}
