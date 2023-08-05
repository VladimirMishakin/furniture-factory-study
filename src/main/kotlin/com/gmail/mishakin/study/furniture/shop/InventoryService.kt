package com.gmail.mishakin.study.furniture.shop

import com.gmail.mishakin.study.furniture.model.Inventory
/* Данный интерфейс отображает действия с инвентарем в магазине*/

interface InventoryService {
    fun addInventory(inventory: Inventory): Inventory
    fun deleteInventory(id: Long): Boolean
    fun takeAllInventory(): List<Inventory>
    fun editInventory(inventory: Inventory): Boolean
    fun checkStatusInventory(inventory: Inventory): Boolean
    fun getTotalPriceInventory(): Double
}

