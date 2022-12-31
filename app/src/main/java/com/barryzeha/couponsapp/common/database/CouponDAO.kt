package com.barryzeha.couponsapp.common.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.barryzeha.couponsapp.common.entities.CouponEntity

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 28/12/2022
 * Copyright (c)  All rights reserved.
 ***/
@Dao
interface CouponDAO {
    @Query("select * from CouponEntity where code = :code")
    suspend fun getCouponById(code:String): CouponEntity?

    @Insert
    suspend fun addCoupon(coupon: CouponEntity):Long
}