package com.retailhub.retailhubbff.service.rest.client;

import com.retailhub.retailhubbff.domain.dto.CartDetailsDTO;
import com.retailhub.retailhubbff.domain.dto.UserDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class OrderManagementServiceClient {

    private final RestTemplate restTemplate;
    private final String baseUri;

    private final String GET_ORDER_DETAILS_URL = "/order-management-service/order/details";
    private final String ADD_TO_CART_URL = "/order-management-service/order/add-to-cart";
    private final String CART_DETAILS_URL = "/order-management-service/order/cart-details";
    private final String DELETE_PRODUCT_FROM_CART_URL = "/order-management-service/order/delete-order/{orderId}?productId={productId}";
    private final String SUBMIT_ORDER_URL = "/order-management-service/order/submit-order";

    public OrderManagementServiceClient(RestTemplate restTemplate, @Value("${order.management.service.base.uri}") String baseUri) {
        this.restTemplate = restTemplate;
        this.baseUri = baseUri;
    }
    public List<CartDetailsDTO> retrieveOrderDetails(int userId) {
        String url = getGET_ORDER_DETAILS_URL() + "?userId=" + userId;
        ResponseEntity<CartDetailsDTO[]> responseEntity = restTemplate.getForEntity(url, CartDetailsDTO[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    public ResponseEntity<Void> sendCartDetails(CartDetailsDTO cartDetailsDTO) {
        HttpEntity<CartDetailsDTO> requestEntity = new HttpEntity<>(cartDetailsDTO);
        ResponseEntity<Void> responseEntity = restTemplate.exchange(getADD_TO_CART_URL(), HttpMethod.POST, requestEntity, Void.class);
        return responseEntity;
    }

    public ResponseEntity<Void> submitOrderDetails(CartDetailsDTO cartDetailsDTO) {
        HttpEntity<CartDetailsDTO> requestEntity = new HttpEntity<>(cartDetailsDTO);
        ResponseEntity<Void> responseEntity = restTemplate.exchange(getSUBMIT_ORDER_URL(), HttpMethod.POST, requestEntity, Void.class);
        return responseEntity;
    }

    public List<CartDetailsDTO> retrieveCartDetails(int userId) {
        String url = getCART_DETAILS_URL() + "?userId=" + userId;
        ResponseEntity<CartDetailsDTO[]> responseEntity = restTemplate.getForEntity(url, CartDetailsDTO[].class);
        return Arrays.asList(responseEntity.getBody());
    }

//    public ResponseEntity<Void>  deleteProductFromUser(int orderId, int productId) {
//         restTemplate.delete(getDELETE_PRODUCT_FROM_CART_URL(), orderId, productId);
//
//    }
public ResponseEntity<Void> deleteOrderProduct(int orderId, int productId) {

    ResponseEntity<Void> responseEntity = restTemplate.exchange(
            getDELETE_PRODUCT_FROM_CART_URL(),
            HttpMethod.DELETE,
            null,
            Void.class,
            orderId,
            productId
    );

    return responseEntity;
}

    protected String getGET_ORDER_DETAILS_URL() {
        return baseUri + GET_ORDER_DETAILS_URL;
    }
    protected String getADD_TO_CART_URL(){ return baseUri + ADD_TO_CART_URL; }
    protected String getCART_DETAILS_URL(){ return baseUri + CART_DETAILS_URL; }
    protected String getDELETE_PRODUCT_FROM_CART_URL(){ return baseUri + DELETE_PRODUCT_FROM_CART_URL;}
    protected String getSUBMIT_ORDER_URL(){ return baseUri + SUBMIT_ORDER_URL;}
}
