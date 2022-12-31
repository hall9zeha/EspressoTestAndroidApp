package com.barryzeha.couponsapp.mainModule.model

import com.barryzeha.couponsapp.common.entities.CouponEntity

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 29/12/2022
 * Copyright (c)  All rights reserved.
 ***/
interface RoomInteractorInterface {
    suspend fun consultCouponByCode(code:String):CouponEntity?
    suspend fun saveCoupon(coupon: CouponEntity):Long
}