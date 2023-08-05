package com.gmail.mishakin.study.garage

import com.gmail.mishakin.study.wash.*
import com.gmail.mishakin.study.wash.Truck
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class TruckWashServiceTests {

    private lateinit var truckWashService: TruckWashService

    @BeforeEach
    fun setup() {
        val washSize = SizeWash(width = 3.0, length = 6.0, height = 3.0)
        val washPrice = mapOf(
            TypeCar.TRUCK to 400.0,
            TypeCar.BUS to 500.0
        )
        truckWashService = TruckWashService(washSize, washPrice)
    }

    @Test
    fun testCheckTypeAutomobile_Truck_ReturnsTrue() {
        val truck = Truck(TypeCar.TRUCK, 2.8, 5.0, 2.5)
        Assertions.assertThat(truckWashService.checkTypeAutomobile(truck)).isEqualTo(true)
    }

        @Test
        fun testCheckTypeAutomobile_Car_ReturnsFalse() {
            val truck = Truck(TypeCar.CAR, 1.8, 3.8, 1.5)
            assertThat(truckWashService.checkTypeAutomobile(truck)).isEqualTo(false)
        }

    @Test
    fun testWashBusReturnsCorrectShampooAndLadderAmount() {
        val bus = Truck(TypeCar.BUS, 3.5, 8.0, 3.2)
        val shampooAndLadderAmount = truckWashService.wash(bus)
        org.junit.jupiter.api.Assertions.assertEquals("500 milliliters shampoo and ladder", shampooAndLadderAmount)
    }

    @Test
    fun testWashTruckReturnsCorrectShampooAndLadderAmount() {
        val truck = Truck(TypeCar.TRUCK, 3.0, 6.5, 3.0)
        val shampooAndLadderAmount = truckWashService.wash(truck)
        org.junit.jupiter.api.Assertions.assertEquals("400 milliliters shampoo and ladder", shampooAndLadderAmount)
    }

    @Test
    fun testTakeMoneyForWashBusAllInclusiveReturnsCorrectAmount() {
        val amount = truckWashService.takeMoneyForWash(TypeCar.BUS, TypeWash.ALL_INCLUSIVE)
        org.junit.jupiter.api.Assertions.assertEquals(1000.0, amount)
    }
}