package com.gmail.mishakin.study.garage

import com.gmail.mishakin.study.wash.*
import com.gmail.mishakin.study.wash.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CarWashServiceTest {

    private lateinit var carWashService: CarWashService

        @BeforeEach
        fun setup() {
            val washSize = SizeWash(width = 2.5, length = 4.0, height = 2.0)
            val washPrice = mapOf(
                TypeCar.CAR to 100.0,
                TypeCar.CROSSOVER to 200.0,
                TypeCar.JEEP to 300.0
            )
            carWashService = CarWashService(washSize, washPrice)
        }

        @Test
        fun testCheckTypeAutomobileCarReturnsTrue() {
            val car = Car(TypeCar.CAR, 1.8, 3.8, 1.5)
            assertThat(carWashService.checkTypeAutomobile(car)).isEqualTo(true)
        }

        @Test
        fun testCheckTypeAutomobileTruckReturnsFalse() {
            val car = Car(TypeCar.TRUCK, 2.8, 5.0, 2.5)
            assertThat(carWashService.checkTypeAutomobile(car)).isEqualTo(false)
        }

        @Test
        fun testWashCarReturnsCorrectShampooAmount() {
            val car = Car(TypeCar.CAR, 1.8, 3.8, 1.5)
            val shampooAmount = carWashService.wash(car)
            assertEquals("100 milliliters shampoo", shampooAmount)
        }

        @Test
        fun testWash_CrossOver_ReturnsCorrectShampooAmount() {
            val crossover = Car(TypeCar.CROSSOVER, 2.0, 4.2, 1.6)
            val shampooAmount = carWashService.wash(crossover)
            assertEquals("200 milliliters shampoo", shampooAmount)
        }

        @Test
        fun testTakeMoneyForWashCarExpressReturnsCorrectAmount() {
            val amount = carWashService.takeMoneyForWash(TypeCar.JEEP, TypeWash.EXPRESS)
            assertEquals(300.0, amount)
        }
}




