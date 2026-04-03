//ATE/4355/14
package com.shopwave.dto;

import java.math.BigDecimal;

public class OrderItemResponse {

    private String productName;
    private int quantity;
    private BigDecimal unitPrice;

    // getters & setters

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
