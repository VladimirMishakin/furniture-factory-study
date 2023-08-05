package com.gmail.mishakin.study.furniture.model
/*Данный класс является классом "Инвентарь".
В данном классе отражены
1. Тип "Инвентаря"
2. Вид "Инвентаря"
В зависимости от типа мы можем выбрать вид
3. Номер инвентаря (должна быть функция? для генерации номера заказа или нет)
Вопрос как сделать что бы вид инвентаря был не конечным перечислением, а классом, что бы в каждом виде
был конкрентный инвентарь и его можно было наделять конкретными характеристиками
* */


enum class InventoryType {
    SHOP, STOCK, PRODUCTION,
}

enum class InventoryKind {
    TRADE, CLEANING, ACCOUNTING, STOCK, MOV
}

// class InventoryKind(private val kinds: List<InventoryKind>) {
//    SHOP(listOf(
//        TradeInventory,
//        CleaningInventory,
//        AccountingInventory)),
//    STOCK(listOf(
//        StoakInventory,
//        MoveInventory,
//        AccountingInventory)),
//    PRODUCTION(listOf(
//        ProductionInventory,
//        StoakInventory,
//        MoveInventory,
//        AccountingInventory,
//        CleaningInventory
//        )
//    )
//
//}


enum class TradeInventory {
    SHOWCASE, COUNTER,
}


open class Inventory(
    val name: String,
    val type: InventoryType,
    val kind: InventoryKind,
    val height: Long,
    val width: Long,
    val length: Long
)


//val shopInventory = Inventory("Kassa", InventoryType.SHOP, InventoryKind.ACCOUNTING)
open class ShopInventory(
    name: String,
    type: InventoryType,
    kind: InventoryKind,
    height: Long,
    width: Long,
    length: Long
) : Inventory(name, type, kind, height, width, length)

