package com.hillel.homework.hw10;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private OrderStatus orderStatus;
    private int orderNumber;
    private LocalDateTime orderAccepted;
    private LocalDateTime orderChanged;

    public Order(OrderStatus orderStatus, int orderNumber, LocalDateTime orderAccepted) {
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
        this.orderAccepted = orderAccepted;
    }

    @Override
    public String toString() {
        return "Order:" +
                "status=" + orderStatus +
                ", number=" + orderNumber +
                ", accepted=" + orderAccepted +
                ", changed=" + orderChanged + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber && orderStatus == order.orderStatus && Objects.equals(orderAccepted, order.orderAccepted) && Objects.equals(orderChanged, order.orderChanged);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderStatus, orderNumber, orderAccepted, orderChanged);
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getOrderAccepted() {
        return orderAccepted;
    }

    public void setOrderAccepted(LocalDateTime orderAccepted) {
        this.orderAccepted = orderAccepted;
    }

    public LocalDateTime getOrderChanged() {
        return orderChanged;
    }

    public void setOrderChanged(LocalDateTime orderChanged) {
        this.orderChanged = orderChanged;
    }
}
