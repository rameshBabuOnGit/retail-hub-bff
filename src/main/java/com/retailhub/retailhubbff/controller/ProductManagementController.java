package com.retailhub.retailhubbff.controller;

import com.retailhub.retailhubbff.domain.dto.ProductDetailDTO;
import com.retailhub.retailhubbff.service.ProductManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductManagementController {

    private final ProductManagementService productManagementService;

    public ProductManagementController(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    @GetMapping(value = "/product-details")
    public ResponseEntity<List<ProductDetailDTO>> retrieveProductDetails() {
        return new ResponseEntity<>(productManagementService.retrieveProductDetails(), HttpStatus.OK);
    }
}
