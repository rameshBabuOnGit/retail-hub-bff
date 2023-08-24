package com.retailhub.retailhubbff.controller;

import com.retailhub.retailhubbff.domain.dto.UserDetailDTO;
import com.retailhub.retailhubbff.service.ProductManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserManagementController {

    private final ProductManagementService productManagementService;

    public UserManagementController(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    @GetMapping(value = "/authentication/{userName}")
    public ResponseEntity<UserDetailDTO> authenticateUser(@PathVariable String userName, @RequestParam String password) {
        return new ResponseEntity<>(productManagementService.authenticateUser(userName, password), HttpStatus.OK);
    }
}
