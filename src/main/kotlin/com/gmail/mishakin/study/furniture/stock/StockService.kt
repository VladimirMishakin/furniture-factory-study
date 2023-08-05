package com.gmail.mishakin.study.furniture.stock

import com.gmail.mishakin.study.furniture.model.Stock

interface StockService {
    fun addStock(stock: Stock): Stock
    fun deleteStock(id: Long): Boolean
    fun takeAllStock(): List<Stock>
    fun editStock(stock: Stock): Boolean
    fun checkStatusStock(stock: Stock): Boolean
}

