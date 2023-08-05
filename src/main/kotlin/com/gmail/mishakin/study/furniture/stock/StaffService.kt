package com.gmail.mishakin.study.furniture.stock

import com.gmail.mishakin.study.furniture.model.Staff
/* Стафф сервис на складе и в магазине идентичен, по факту содержит разные реализации, нужно ли менять название
или вообще сделать один интерфейс
 */
interface StaffService {
        fun addStaff(staff: Staff): Staff
        fun deleteStaff(id: Long): Boolean
        fun takeAllStaff(): List<Staff>
        fun editStaff(staff: Staff): Boolean
        fun checkStatus(staff: Staff): Boolean
    }