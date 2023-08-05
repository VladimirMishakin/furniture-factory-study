package com.gmail.mishakin.study.furniture.model

import java.time.LocalDateTime
/*Данный класс является классом "Заказ у поставщика".
В данном классе отражены
1. Конкрентый поставщик мебели
2. Список товаров в заказе
3. Номер заказа (должна быть функция? для генерации номера заказа или нет)
4. Цена заказа
* */
data class OrderFurniture(
    val furnitureSuppliers: FurnitureSupplier,
    val orderProducts: List<Product>,
    val orderId: Int,
    val dataOrder: LocalDateTime,
    val priceOrder: Double,
)
/*Данный класс является классом "Поставщик мебели".
В данном классе отражены
1. Тип поставляемых товаров (Можеть быть должен быть список,
так как, разные поставщики могут посталвлять, как один тип так и несколько)
2. Адрес поставщика
3. Наименование поставщика
* */
class FurnitureSupplier(
    val productTypes: ProductType,
    val supplierAddress: String,
    val supplierName: String,
)