package com.gmail.mishakin.study.garage

interface GarageService<V> {
    fun checkSizeVehicle(vehicle: V): Boolean
    fun openDoor()
    fun closeDoor()
    fun addVehicle(vehicle: V): V
    fun deleteVehicle(vehicle: V): Boolean
    fun takeAllVehicle(): List<V>
}

open class Vehicle(
    val make: String,
    val model: String,
    val year: Int,
    val width: Double,
    val length: Double,
    val height: Double
)

class Car(
    make: String,
    model: String,
    year: Int,
    width: Double,
    length: Double,
    height: Double
) : Vehicle(make, model, year, width, length, height)

class Truck(
    make: String,
    model: String,
    year: Int,
    width: Double,
    length: Double,
    height: Double
) : Vehicle(make, model, year, width, length, height)

data class Door(
    val width: Double,
    val length: Double,
    val height: Double
) {
    fun canGoThrow(vehicle: Vehicle): Boolean =
    (vehicle.width < this.width && vehicle.length < this.length && vehicle.height < this.height)
}


class GarageServiceForCars : GarageService<Car> {
    private val garageDoor = Door(2.5, 2.0, 1.8)
    private val cars: MutableList<Car> = mutableListOf()

    override fun checkSizeVehicle(vehicle: Car): Boolean {

        return if (garageDoor.canGoThrow(vehicle)) {
            println("Let`s go")
            true
        } else {
            false
        }
    }

    override fun openDoor() {
        println("Дверь открыта")
    }

    override fun closeDoor() {
        println("Дверь закрыта")
    }

    override fun addVehicle(vehicle: Car): Car {
        cars.add(vehicle)
        return vehicle
    }

    override fun takeAllVehicle(): List<Car> {
        return cars.toList()
    }

    override fun deleteVehicle(vehicle: Car): Boolean {
        return cars.remove(vehicle)
    }
}


class GarageServiceForTrucks : GarageService<Truck> {
    private val garageDoor = Door(3.0, 3.0, 2.5)
    private val truck: MutableList<Truck> = mutableListOf()

    override fun checkSizeVehicle(vehicle: Truck): Boolean {
        return if (garageDoor.canGoThrow(vehicle)) {
            println("Let`s go")
            true
        } else {
            println("Check is fail")
            false
        }
    }

    override fun openDoor() {
        println("Дверь открыта")
    }

    override fun closeDoor() {
        println("Дверь закрыта")
    }

    override fun addVehicle(vehicle: Truck): Truck {
        truck.add(vehicle)
        return vehicle
    }

    override fun takeAllVehicle(): List<Truck> {
        return truck.toList()
    }

    override fun deleteVehicle(vehicle: Truck): Boolean {
        return truck.remove(vehicle)
    }
}