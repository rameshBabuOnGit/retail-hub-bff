package com.retailhub.retailhubbff.service;

import com.retailhub.retailhubbff.domain.dto.ProductDetailDTO;
import com.retailhub.retailhubbff.domain.dto.UserDetailDTO;
import com.retailhub.retailhubbff.exception.InvalidUserException;
import com.retailhub.retailhubbff.service.rest.client.ProductManagementServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

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

    public UserDetailDTO authenticateUser(String userName, String password) {
        try {
            validateUserName(userName);
            return productManagementServiceClient.authenticateUser(userName, password);
        } catch (HttpStatusCodeException httpStatusCodeException) {
            log.info(httpStatusCodeException.getResponseBodyAsString());
            throw new InvalidUserException("Invalid Username or password");
        }
    }

    private void validateUserName(String userName) {
        if(!userName.matches("^[a-zA-Z0-9_-]{3,16}$")) {
            throw new InvalidUserException("Invalid Username");
        }
    }
}
