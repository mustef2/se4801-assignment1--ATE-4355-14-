//ATE/4355/14
package com.shopwave.dto;

import java.util.List;

public class OrderRequest {

    private List<OrderItemRequest> items;

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}