package com.retailhub.retailhubbff.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailDTO {
    private int productId;
    private String productName;
    private BigDecimal productPrice;
    private String productDescription;
    private String productCategory;
    private int productStockQuantity;
}
