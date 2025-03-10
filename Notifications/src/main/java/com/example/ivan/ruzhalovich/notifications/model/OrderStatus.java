package com.example.ivan.ruzhalovich.notifications.model;

public enum OrderStatus {
    NEW("Новый заказ"),
    AWAITING_PAYMENT("Заказ обработан и ожидает оплаты"),
    PAYMENT("Заказ оплачен"),
    PACKAGE("Заказ упакован и передан в доставку"),
    DELIVERED("Заказ доставлен клиенту"),
    CANCELLED("Заказ отменен по техническим причинам!");

    private final String status;

    OrderStatus(String status){
        this.status = status;
    }

    public String getOrderStatus(){
        return status;
    }
}
