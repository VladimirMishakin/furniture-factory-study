package com.gmail.mishakin.study.furniture.shop

import com.gmail.mishakin.study.furniture.model.Product
/* Данный интерфейс отображает действия с товаром в магазине*/

interface ProductService {
    fun addProduct(product: Product): Product
    fun deleteProduct(id: Long): Boolean
    fun takeAllProducts(): List<Product>
    fun editProduct(product: Product): Boolean
    fun getTotalPriceProduct(): Double
}

