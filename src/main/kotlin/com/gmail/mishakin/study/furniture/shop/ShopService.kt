package com.gmail.mishakin.study.furniture.shop

import com.gmail.mishakin.study.furniture.model.Shop
/* Данный интерфейс отображает действия с магазином */
interface ShopService {
    fun addShop(shop: Shop): Shop
    fun deleteShop(id: Long): Boolean
    fun takeAllShop(): List<Shop>
    fun editShop(shop: Shop): Boolean
    fun checkStatus(shop: Shop): Boolean
}

