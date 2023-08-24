package com.retailhub.retailhubbff.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderHeaderDTO {
    private int orderId;
    private int userId;
    private int totalOrderValue;
    private String orderStatus;
}