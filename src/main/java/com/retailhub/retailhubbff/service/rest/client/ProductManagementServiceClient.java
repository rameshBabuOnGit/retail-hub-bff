package com.retailhub.retailhubbff.service.rest.client;

import com.retailhub.retailhubbff.domain.dto.ProductDetailDTO;
import com.retailhub.retailhubbff.domain.dto.UserDetailDTO;
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
    private final String USER_AUTH_URL = "/product-management-service/user/authentication/{userName}?password={password}";

    public ProductManagementServiceClient(RestTemplate restTemplate, @Value("${product.management.service.base.uri}") String baseUri) {
        this.restTemplate = restTemplate;
        this.baseUri = baseUri;
    }

    public List<ProductDetailDTO> retrieveProductDetails() {
        log.info("ProductManagementServiceClient Invoked");
        ResponseEntity<ProductDetailDTO[]> responseEntity = restTemplate.getForEntity(getProductDetailsUrl(), ProductDetailDTO[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    public UserDetailDTO authenticateUser(String userName, String password) {
        return restTemplate.getForObject(getUserAuthUrl(), UserDetailDTO.class, userName, password);
    }

    protected String getProductDetailsUrl() {
        return baseUri + GET_PRODUCT_DETAILS_URL;
    }

    protected String getUserAuthUrl() {
        return baseUri + USER_AUTH_URL;
    }
}
