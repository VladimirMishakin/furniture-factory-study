package com.gmail.mishakin.study.garage

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class GarageServiceForCarTest {

    private lateinit var garageServiceForCars: GarageServiceForCars

    @BeforeEach
    fun setUp() {
        garageServiceForCars = GarageServiceForCars()
    }

    @Test
    fun `Negative pass - check size of vehicle`() {
        val car = Car("", "", 1990, 3.0, 2.0, 3.0)
        assertThat(garageServiceForCars.checkSizeVehicle(car)).isEqualTo(false)
    }

    @Test
    fun `Happy pass - check size of vehicle`() {
        val car = Car("", "", 1990, 2.4, 1.8, 1.5)
        assertThat(garageServiceForCars.checkSizeVehicle(car)).isEqualTo(true)
    }

    @Test
    fun `Happy pass - open the door`() {
        garageServiceForCars.openDoor()
    }

    @Test
    fun closeDoor() {
        garageServiceForCars.closeDoor()
    }

    @Test
    fun addVehicle() {
        val car = Car("WV", "Passat", 1990, 2.4, 1.8, 1.5)
        garageServiceForCars.addVehicle(car)
        assertThat(garageServiceForCars.takeAllVehicle().size).isEqualTo(1)
        assertThat(garageServiceForCars.takeAllVehicle().first()).isEqualTo(car)
    }

    @Test
    fun takeAllVehicle() {
        val car = Car("WV", "Passat", 1990, 2.4, 1.8, 1.5)
        val car2 = Car("WV", "PassatCC", 1990, 2.4, 1.8, 1.5)
        garageServiceForCars.addVehicle(car)
        garageServiceForCars.addVehicle(car2)
        assertThat(garageServiceForCars.takeAllVehicle().size).isEqualTo(2)
        assertThat(garageServiceForCars.takeAllVehicle().first()).isEqualTo(car)
        assertThat(garageServiceForCars.takeAllVehicle().last()).isEqualTo(car2)
    }

    @Test
    fun deleteVehicle() {
        val car = Car("WV", "Passat", 1990, 2.4, 1.8, 1.5)
        garageServiceForCars.addVehicle(car)
        assertThat(garageServiceForCars.takeAllVehicle().size).isEqualTo(1)
        garageServiceForCars.deleteVehicle(car)
        assertThat(garageServiceForCars.takeAllVehicle().size).isEqualTo(0)
    }
}