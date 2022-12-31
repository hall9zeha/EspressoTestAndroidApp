package com.barryzeha.couponsapp.common.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.barryzeha.couponsapp.common.entities.CouponEntity

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 28/12/2022
 * Copyright (c)  All rights reserved.
 ***/
@Database(entities = [CouponEntity::class] , version = 1)
abstract class CouponDatabase: RoomDatabase() {
    abstract fun couponDao(): CouponDAO
}