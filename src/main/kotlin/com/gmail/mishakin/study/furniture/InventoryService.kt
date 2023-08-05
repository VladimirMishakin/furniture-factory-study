package com.gmail.mishakin.study.furniture

import com.gmail.mishakin.study.furniture.model.Inventory

interface InventoryService<S, I> {
    fun addInventory(subject: S, inventory: I): I
    fun deleteInventory(subject: S, id: Long): Boolean
    fun takeAllInventory(): List<I>
    fun editInventory(subject: S, inventory: I): Boolean
    fun checkStatusInventory(subject: S, inventory: I): Boolean
    fun getTotalPriceInventory(): Double
}
