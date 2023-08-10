package com.retailhub.retailhubbff.service;

import com.retailhub.retailhubbff.domain.dto.ProductDetailDTO;
import com.retailhub.retailhubbff.service.rest.client.ProductManagementServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductManagementService {

    private final ProductManagementServiceClient productManagementServiceClient;

    public ProductManagementService(ProductManagementServiceClient productManagementServiceClient) {
        this.productManagementServiceClient = productManagementServiceClient;
    }

    public List<ProductDetailDTO> retrieveProductDetails() {
        log.info("ProductManagementService Invoked");
        return productManagementServiceClient.retrieveProductDetails();
    }
}
