package com.gmail.mishakin.study.furniture.model

import java.time.LocalDateTime
/* Данный класс является классом "Заказ".
В данном классе отражены
1. Характеристики покупателя,
2. Список товаров в заказе,
3. Номер заказа (должна быть функция? для генерации номера заказа или нет),
4. Дата заказа (сюда нужно добавить срок выполнения заказа).
* */
data class Order(
    val buyers: Buyer,
    val orderProducts: List<Product>,
    val orderId: Int,
    val dataOrder: LocalDateTime,
    val priceOrder: Double
)

/*
Данный класс является классом "Покупатель".
Тип покупателя "Оптовый" и "Розничный"
Адрес покупателя (должно интегрироваться с доставкой)
Наименование покупателя если "Оптовый"
Имя фамилия дата рождения, если "Розничный" (Хотелось бы что бы были уведомления о Д.Р.
* */

class Buyer(
    val buyersType: TypeBuyer,
    val buyerAddress: String,
    val buyerName: String?,
    val name: String?,
    val surname: String?,
    val birthday: String?
) {
    /* Это мне чат помог, расскажи что это такое объект компаньон*/
    companion object {
        fun createBuyer(
            buyersType: TypeBuyer,
            buyerAddress: String,
            buyerName: String?,
            name: String?,
            surname: String?,
            birthday: String?
        ): Buyer {
            return when (buyersType) {
                TypeBuyer.WHOLESALE -> Buyer(buyersType, buyerAddress, buyerName, null, null, null)
                TypeBuyer.RETAIL -> Buyer(buyersType, buyerAddress,null, name, surname, birthday)
            }
        }
    }
}

enum class TypeBuyer {
    WHOLESALE, RETAIL
}
