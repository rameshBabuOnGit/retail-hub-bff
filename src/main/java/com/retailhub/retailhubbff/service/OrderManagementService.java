package com.retailhub.retailhubbff.service;

import com.retailhub.retailhubbff.domain.dto.CartDetailsDTO;
import com.retailhub.retailhubbff.service.rest.client.OrderManagementServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderManagementService {

    private final OrderManagementServiceClient orderManagementServiceClient;

    public OrderManagementService(OrderManagementServiceClient orderManagementServiceClient) {
        this.orderManagementServiceClient = orderManagementServiceClient;
    }

    public List<CartDetailsDTO> retrieveOrderDetails(int userId) {
        return orderManagementServiceClient.retrieveOrderDetails(userId);
    }

    public void insertOrderDetails(CartDetailsDTO cartDetailsDTO) {
        orderManagementServiceClient.sendCartDetails(cartDetailsDTO);
    }

    public List<CartDetailsDTO> retrieveCartDetails(int userId) {
        return orderManagementServiceClient.retrieveCartDetails(userId);
    }

    public ResponseEntity<Void> submitOrderDetails(CartDetailsDTO cartDetailsDTO) {
        return orderManagementServiceClient.submitOrderDetails(cartDetailsDTO);
    }

    public ResponseEntity<Void> deleteProductFromCart(int orderId, int productId){
        return orderManagementServiceClient.deleteOrderProduct(orderId, productId);
    }
}
