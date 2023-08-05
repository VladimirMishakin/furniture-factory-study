package com.gmail.mishakin.study.furniture.shop

import com.gmail.mishakin.study.furniture.model.Order
/* Данный интерфейс отображает действия с заказом в магазине */

interface OrderService {
    fun addOrder(order: Order): Order
    fun delete(id: Long): Boolean
    fun takeAllOrder(): List<Order>
    fun editOrder(order: Order): Boolean
    fun checkStatusOrder(order: Order): Boolean

}

