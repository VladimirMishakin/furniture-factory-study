package com.gmail.mishakin.study.wash

interface AutomobileWashService<A : Automobile> {
    fun checkSizeAutomobile(automobile: A): Boolean
    fun checkTypeAutomobile(automobile: A): Boolean
    fun addAutomobile(automobile: A): A
    fun deleteAutomobile(automobile: A): Boolean
    fun takeMoneyForWash(typesCar: TypeCar, typeWash: TypeWash): Double
    fun addTypeWash(typesWash: TypeWash): TypeWash
    fun deleteTypeWash(typesWash: TypeWash): Boolean
    fun wash(automobile: A): String
}

open class Automobile(
    val typesCar: TypeCar,
    val width: Double,
    val length: Double,
    val height: Double
)

class Car(
    typesCar: TypeCar,
    width: Double,
    length: Double,
    height: Double
) : Automobile(typesCar, width, length, height)

class Truck(
    typesCar: TypeCar,
    width: Double,
    length: Double,
    height: Double
) : Automobile(typesCar, width, length, height)

enum class TypeCar { CAR, CROSSOVER, JEEP, TRUCK, BUS }

data class SizeWash(
    val width: Double,
    val length: Double,
    val height: Double
) {
    fun canGoThrough(automobile: Automobile): Boolean =
        (automobile.width < this.width && automobile.length < this.length && automobile.height < this.height)
}

enum class TypeWash(val coefficient: Double) {
    EXPRESS(1.0),
    ALL_INCLUSIVE(2.0)
}

abstract class GeneralCarWash<A : Automobile>(
    open val washSize: SizeWash,
    open val washPrice: Map<TypeCar, Double>
) : AutomobileWashService<A> {

    val automobiles: MutableList<A> = mutableListOf()
    val newWash: MutableList<TypeWash> = mutableListOf()

    override fun checkSizeAutomobile(automobile: A): Boolean {
        return if (washSize.canGoThrough(automobile)) {
            println("Let's go")
            true
        } else {
            false
        }
    }

    override fun takeMoneyForWash(typesCar: TypeCar, typeWash: TypeWash): Double {
        val priceWash = washPrice[typesCar]
        return if (priceWash != null) {
            priceWash * typeWash.coefficient
        } else {
            0.0
        }
    }

    override fun addTypeWash(typesWash: TypeWash): TypeWash {
        newWash.add(typesWash)
        return typesWash
    }

    override fun deleteTypeWash(typesWash: TypeWash): Boolean {
        return newWash.remove(typesWash)
    }

    override fun deleteAutomobile(automobile: A): Boolean {
        return automobiles.remove(automobile)
    }

    override fun addAutomobile(automobile: A): A {
        automobiles.add(automobile)
        return automobile
    }
}

class CarWashService(
    washSize: SizeWash,
    washPrice: Map<TypeCar, Double>
) : GeneralCarWash<Car>(washSize, washPrice) {
    override fun checkTypeAutomobile(automobile: Car): Boolean {
        return when (automobile.typesCar) {
            TypeCar.CAR, TypeCar.CROSSOVER, TypeCar.JEEP -> {
                println("Good Type")
                true
            }

            else -> false
        }
    }

    override fun wash(automobile: Car): String {
        return when (automobile.typesCar) {
            TypeCar.CAR -> {
                "100 milliliters shampoo"
            }

            TypeCar.CROSSOVER -> {
                "200 milliliters shampoo"
            }

            TypeCar.JEEP -> {
                "300 milliliters shampoo"
            }

            else -> {
                "Unknown type of car."
            }
        }
    }
}


class TruckWashService(
    washSize: SizeWash,
    washPrice: Map<TypeCar, Double>
) : GeneralCarWash<Truck>(washSize, washPrice) {
    override fun checkTypeAutomobile(automobile: Truck): Boolean {
        return when (automobile.typesCar) {
            TypeCar.TRUCK, TypeCar.BUS -> {
                println("Good Type")
                true
            }

            else -> false
        }
    }

    override fun wash(automobile: Truck): String {
        return when (automobile.typesCar) {
            TypeCar.BUS -> {
                "500 milliliters shampoo and ladder"
            }

            TypeCar.TRUCK -> {
                "400 milliliters shampoo and ladder"
            }

            else -> {
                "Unknown type of car."
            }
        }
    }

}

