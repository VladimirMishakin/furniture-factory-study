package com.gmail.mishakin.study.furniture.stock

import com.gmail.mishakin.study.furniture.model.Inventory

interface InventoryService {
    fun addInventory(inventory: Inventory): Inventory
    fun deleteInventory(id: Long): Boolean
    fun takeAllInventory(): List<Inventory>
    fun editInventory(inventory: Inventory): Boolean
    fun checkStatusInventory(inventory: Inventory): Boolean
    fun getTotalPriceInventory(): Double
}