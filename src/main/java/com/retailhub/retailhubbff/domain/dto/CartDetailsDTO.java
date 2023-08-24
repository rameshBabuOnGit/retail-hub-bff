package com.retailhub.retailhubbff.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDetailsDTO {
    private int orderId;
    private int userId;
    private BigDecimal totalOrderValue;
    private String orderStatus;
    List<CartLineDetailsDTO> cartLineDetailsDTOList;
}