package com.retailhub.retailhubbff.service.rest.client;

import com.retailhub.retailhubbff.domain.dto.ProductDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ProductManagementServiceClient {
    private final RestTemplate restTemplate;
    private final String baseUri;

    private final String GET_PRODUCT_DETAILS_URL = "/product-management-service/product/product-details";

    public ProductManagementServiceClient(RestTemplate restTemplate, @Value("${product.management.service.base.uri}") String baseUri) {
        this.restTemplate = restTemplate;
        this.baseUri = baseUri;
    }

    public List<ProductDetailDTO> retrieveProductDetails() {
        log.info("ProductManagementServiceClient Invoked");
        ResponseEntity<ProductDetailDTO[]> responseEntity = restTemplate.getForEntity(getProductDetailsUrl(), ProductDetailDTO[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    protected String getProductDetailsUrl() {
        return baseUri + GET_PRODUCT_DETAILS_URL;
    }
}
