package com.gmail.mishakin.study.furniture.model
/*Данный класс является классом "Склад".
В данном классе отражены
1. Адрес склада (Как бы он учитывался при транспортировке "Товара" в "Магазин"
2. Площадь склада (Она нужна для размещения товара, соответсвенно нужно, что бы считал свободную,
с этой целью "Товар" должен быть наделен характеристикой площадь, причем в собранном и разобранном виде,
В разобранном для хранения на складе и транспортировки
3. Список персонала назначенного на работу в "Магазин"
4. Список "Товара" на "Складе"
5. Список "Инвентаря" на "Складе"
6. Цена всех товаров на Складе (нужно сюда или интерфейс будет считать ?)
7. Цена всего инвентаря на Складе*/
data class Stock (
    val address: String,
    val square: Double,
    val staff: List<StaffOnStock>,
    val products: List<ProductOnStock>,
    val inventory: List<InventoryOnStock>,
    val priceAllProduct: Double,
    val priceAllInventory: Double
)

class ProductOnStock (product: Product)
/* тут хочу что бы через интерфейс добавлял товар и делал из него список товаров в конкретном складе*/

class InventoryOnStock (inventory: Inventory)
/* тут хочу что бы через интерфейс добавлял инвентарь и делал из него список инвентаря в конкретном складе*/

class StaffOnStock (
    val quantityStorekeeper: Int,
    val quantityLoader: Int,

)