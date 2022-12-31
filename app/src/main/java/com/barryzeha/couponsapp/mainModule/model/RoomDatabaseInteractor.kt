package com.barryzeha.couponsapp.mainModule.model

import android.database.sqlite.SQLiteConstraintException
import com.barryzeha.couponsapp.CouponsApp
import com.barryzeha.couponsapp.common.utils.Constants
import com.barryzeha.couponsapp.common.database.CouponDAO
import com.barryzeha.couponsapp.common.database.CouponDatabase
import com.barryzeha.couponsapp.common.entities.CouponEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 28/12/2022
 * Copyright (c)  All rights reserved.
 ***/
class RoomDatabaseInteractor(db:CouponDatabase) : RoomInteractorInterface{

    private val database = db.couponDao()

    override suspend fun consultCouponByCode(code:String) = database.getCouponById(code)


    override suspend fun saveCoupon(coupon: CouponEntity) = withContext(Dispatchers.IO){
        try{
            database.addCoupon(coupon)
        }
        catch(e:Exception){
            (e as? SQLiteConstraintException)?.let{throw Exception(Constants.ERROR_EXIST)}
            throw Exception(e.message ?: Constants.ERROR_UNKNOWN)
        }
    }

}