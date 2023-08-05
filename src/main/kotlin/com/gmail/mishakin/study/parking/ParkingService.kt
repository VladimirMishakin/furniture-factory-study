package com.gmail.mishakin.study.parking

import java.time.LocalDateTime

interface ParkingService<V : Vehicle, P : ParkingPlace> {
    fun determineType(vehicle: V): CarSizeType
    fun addVehicle(vehicle: V): V
    fun deleteVehicle(vehicle: V): Boolean
    fun takeAllVehicle(): List<V>
    fun addPlaceParking(parkingPlace: P): P
    fun deletePlaceParking(parkingPlace: P): Boolean
    fun takeAllPlaceParking(): List<P>
    fun takeNumberFreePlace(vehicle: V, parkingPlaces: List<P>): P?
    fun takeAllFreePlace(parkingPlaces: List<P>): List<P>
    fun billForParking(vehicle: V): Double
}

open class Vehicle(
    val licensePlate: String,
    val width: Double,
    val length: Double,
    val height: Double,
    val hoursParked: Int,
    val typesVehicle: CarSizeType
)

open class ParkingPlace(
    val width: Double,
    val length: Double,
    val height: Double,
    val number: Int,
    var isFree: Boolean = true,
    val vehicle: Vehicle,
    val payment: Payment = Payment()
) {
    fun occupy() {
        isFree = false
    }

    fun release() {
        isFree = true
    }
}

class SmallParkingPlace(
    width: Double,
    length: Double,
    height: Double,
    number: Int
) : ParkingPlace(width, length, height, number)

class BigParkingPlace(
    width: Double,
    length: Double,
    height: Double,
    number: Int
) : ParkingPlace(width, length, height, number)

data class Payment(
    var id: Long? = null,
    val startDateTime: LocalDateTime = LocalDateTime.now(),
    var endTime: LocalDateTime? = null,
    val price: Double,
    var amount: Double = 0.0
)

class ParkingServiceImpl(
    val allVehicles: MutableList<Vehicle> = mutableListOf(),
    val allParkingPlaces: MutableList<ParkingPlace> = mutableListOf(),
    val heightParking: Double = 7.0,
    val lengthParking: Double = 10.0,
    val prices: Map<CarSizeType, Double> = mapOf(CarSizeType.BIG to 100.0, CarSizeType.SMALL to 50.0)
) : ParkingService<Vehicle, ParkingPlace> {

    override fun determineType(vehicle: Vehicle): CarSizeType {
        if (heightParking < vehicle.height || lengthParking < vehicle.length) {
            throw IllegalArgumentException("Транспортное средство не подходит для данной парковки")
        }

        val totalSize = vehicle.width * vehicle.length
        return if (totalSize <= 20) {
            CarSizeType.SMALL
        } else {
            CarSizeType.BIG
        }
    }

    override fun addVehicle(vehicle: Vehicle): Vehicle {
        allVehicles.add(vehicle)
        return vehicle
    }

    override fun deleteVehicle(vehicle: Vehicle): Boolean {
        return allVehicles.remove(vehicle)
    }

    override fun takeAllVehicle(): List<Vehicle> {
        return allVehicles
    }

    override fun addPlaceParking(parkingPlace: ParkingPlace): ParkingPlace {
        allParkingPlaces.add(parkingPlace)
        return parkingPlace
    }

    override fun deletePlaceParking(parkingPlace: ParkingPlace): Boolean {
        val foundIndex = allParkingPlaces.indexOfFirst { it.number == parkingPlace.number }

        if (foundIndex >= 0) {
            allParkingPlaces.removeAt(foundIndex)
            return true
        } else {
            return false
        }
    }

    override fun takeAllPlaceParking(): List<ParkingPlace> {
        return allParkingPlaces
    }

    override fun takeNumberFreePlace(vehicle: Vehicle, parkingPlaces: List<ParkingPlace>): ParkingPlace? {
        val availablePlace = parkingPlaces.find { it.isFree && it.vehicle.typesVehicle == determineType(vehicle) }
        availablePlace?.occupy()
        return availablePlace
    }

    override fun takeAllFreePlace(parkingPlaces: List<ParkingPlace>): List<ParkingPlace> {
        return parkingPlaces.filter { it.isFree }
    }

    override fun billForParking(vehicle: Vehicle): Double {
        val hourlyRate = prices[vehicle.typesVehicle] ?: 0.0

        val hoursParked = vehicle.hoursParked
        return hourlyRate * hoursParked
    }
}



