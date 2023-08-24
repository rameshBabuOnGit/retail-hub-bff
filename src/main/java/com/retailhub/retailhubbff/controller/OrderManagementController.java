package com.retailhub.retailhubbff.controller;

import com.retailhub.retailhubbff.domain.dto.CartDetailsDTO;
import com.retailhub.retailhubbff.service.OrderManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderManagementController {

    private final OrderManagementService orderManagementService;

    public OrderManagementController(OrderManagementService orderManagementService) {
        this.orderManagementService = orderManagementService;
    }

    @GetMapping(value = "/order-details")
    public ResponseEntity<List<CartDetailsDTO>> retrieveProductDetails(@RequestParam int userId) {
        return new ResponseEntity<>(orderManagementService.retrieveOrderDetails(userId), HttpStatus.OK);
    }

    @PostMapping(value = "/add-to-cart")
    public ResponseEntity<Void> insertOrderDetails(@RequestBody CartDetailsDTO cartDetailsDTO) {
        orderManagementService.insertOrderDetails(cartDetailsDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping(value = "/submit-order")
    public ResponseEntity<Void> submitOrderDetails(@RequestBody CartDetailsDTO cartDetailsDTO) {
        orderManagementService.submitOrderDetails(cartDetailsDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/cart-details")
    public ResponseEntity<List<CartDetailsDTO>> retrieveCartDetails(@RequestParam int userId) {
        return new ResponseEntity<>(orderManagementService.retrieveCartDetails(userId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-order/{orderId}")
    public ResponseEntity<Void> deleteOrderFromCart(@PathVariable int orderId, @RequestParam int productId) {
        orderManagementService.deleteProductFromCart(orderId, productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
