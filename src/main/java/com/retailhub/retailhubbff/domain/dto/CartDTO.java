package com.retailhub.retailhubbff.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {
    private OrderHeaderDTO orderHeader;
    private List<OrderDetailsDTO> orderDetailsList;
}