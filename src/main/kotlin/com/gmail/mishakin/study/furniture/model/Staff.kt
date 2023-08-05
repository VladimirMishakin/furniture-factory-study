package com.gmail.mishakin.study.furniture.model

import java.util.Date

/* Данный класс является классом "Персонал".
В данном классе отражены
1. "Должность сотрудника" (Должности нужно разбить по направлениям ?)
2. "Имя"
3. "Отчество"
4. "Фамилия"
5. "Пол" (кого будем поздравлять на 8 марта, кого на 23)
6. "Дата рождения" (как будет считать возраст?)
7. "Дата принятия на работу" (соответсвенно надо считать стаж)
* */
data class Staff(
    val еmployeesPosition: PositionType,
    val name: String,
    val soname: String,
    val lastName: String,
    val male: MaleType,
    val birthDay: Date,
    val startWorkDay: Date
)

class PositionType (
    val engineers: Engineer,
    val managers: Manager,
)


class Engineer(
    val engineerTypes: EngineerType
) {
    val priceForHour: Int
        get() = when (engineerTypes) {
            EngineerType.ELECTRICIAN -> 100
            EngineerType.MECHANIC -> 120
            EngineerType.PRODUCTION -> 90
        }
}

enum class EngineerType {
    ELECTRICIAN, MECHANIC, PRODUCTION
}

enum class MaleType{
    MALE, FEMALE
}

class Manager(
        val managerTypes: ManagerType
){
    val priceForHour: Int
        get() = when (managerTypes) {
            ManagerType.SALES -> 100
            ManagerType.PURCHASING -> 120
        }
}

enum class ManagerType {
    SALES, PURCHASING,
}