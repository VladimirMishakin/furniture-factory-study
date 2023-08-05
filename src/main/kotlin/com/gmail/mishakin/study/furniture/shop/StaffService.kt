package com.gmail.mishakin.study.furniture.shop

import com.gmail.mishakin.study.furniture.model.Staff
/* Данный интерфейс отображает действия с персоналом магазина*/

interface StaffService {
    fun addStaff(staff: Staff): Staff
    fun deleteStaff(id: Long): Boolean
    fun takeAllStaff(): List<Staff>
    fun editStaff(staff: Staff): Boolean
    fun checkStatus(staff: Staff): Boolean
}

