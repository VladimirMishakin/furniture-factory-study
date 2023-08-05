package com.gmail.mishakin.study.furniture.procurement

import com.gmail.mishakin.study.furniture.model.OrderFurniture

/* Данный интерфейс отображает действия с заказом у поставщика мебели*/

interface OrderFurnitureSuppliersService {
    fun addOrderFurniture(orderFurniture: OrderFurniture): OrderFurniture
    fun delete(id: Long): Boolean
    fun takeAllOrderFurniture(): List<OrderFurniture>
    fun editOrderFurniture(orderFurniture: OrderFurniture): Boolean
    fun checkStatusOrderFurniture(orderFurniture: OrderFurniture): Boolean
    fun approveOrderFurniture(orderFurniture: OrderFurniture): Boolean

}

