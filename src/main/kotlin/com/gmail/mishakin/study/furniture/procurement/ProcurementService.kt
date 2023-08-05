package com.gmail.mishakin.study.furniture.procurement

import com.gmail.mishakin.study.furniture.model.FurnitureSupplier

/* Данный интерфейс отображает действия с поставщиком мебели*/

interface ProcurementService {
    fun addFurnitureSupplier (furnitureSupplier: FurnitureSupplier): FurnitureSupplier
    fun deleteFurnitureSupplier(id: Long): Boolean
    fun takeFurnitureSupplier(): List<FurnitureSupplier>
    fun editFurnitureSupplierI(furnitureSupplier: FurnitureSupplier): Boolean
    fun checkStatusFurnitureSupplier(furnitureSupplier: FurnitureSupplier): Boolean
    }

