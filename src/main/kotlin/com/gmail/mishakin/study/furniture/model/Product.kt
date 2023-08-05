package com.gmail.mishakin.study.furniture.model

/*Данный класс является классом "Товар".
В данном классе отражены
1. Список для выбора типа "Товара"
(В зависимости от типа мы можем выбрать модель)
2. Модель "Товара" которая содержит конечное перечисление моделей в зависимости от типа "Товара"
3. Список из конечного перечисления цветов "Товаров"
4. Цена "Товара"
5. Площадь в разобранном виде
6. Площадь в упаковке(нам не достаточно площади нужно длину ширину и высоту, это надо реализовтаь в каждом модуле)
Вопрос здесь также должно быть дальнейшее разделение "Товара" на модули и фасады
те в свою очередь бывают разные, как это лучше реализовать.
* */
data class Product(
    val productTypes: ProductType,
    val models: Model,
    val colors: ColorType,
    val price: Double,
    val square: Double,
    val squareInPocket: Double
)

enum class Model(private val models: List<String>) {
    KITCHEN(listOf("Мария", "Яна", "Елена")),
    LIVINGROOM(listOf("Фантазия", "Нежность")),
    HALLWAY(listOf("Гость", "Наоми")),
    BEDROOM(listOf("Модель1", "Модель2"));

    fun getModels(): List<String> {
        return models
    }
}

enum class ProductType {
    KITCHEN, LIVINGROOM, HALLWAY, BEDROOM
}

enum class ColorType {
    ASH, OAK, WALNUT
}

