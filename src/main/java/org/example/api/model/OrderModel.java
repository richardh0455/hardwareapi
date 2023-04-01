package org.example.api.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderModel {

    private Integer id;
    private Integer customerId;

    private List<OrderItemModel> orderItems;

    public OrderModel(Integer id, Integer customerId) {
        this(id, customerId, new ArrayList<>());
    }

    public OrderModel(Integer id, Integer customerId, List<OrderItemModel> orderItems) {
        this.id = id;
        this.customerId = customerId;
        this.orderItems = orderItems;
    }

    public void addOrderItems(OrderItemModel... orderItems) {
        this.orderItems.addAll(Arrays.asList(orderItems));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemModel> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemModel> orderItems) {
        this.orderItems = orderItems;
    }
}
