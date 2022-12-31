package com.barryzeha.couponsapp.mainModule.model

import com.barryzeha.couponsapp.common.utils.Constants
import com.barryzeha.couponsapp.common.utils.validateTextCode
import com.barryzeha.couponsapp.common.entities.CouponEntity

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 28/12/2022
 * Copyright (c)  All rights reserved.
 ***/
class MainRepository(private val roomInteractor:RoomInteractorInterface):MainRepositoryInterface {

    override suspend fun consultCouponByCode(code:String)=roomInteractor.consultCouponByCode(code)

    override suspend fun saveCoupon(coupon: CouponEntity){
        if(validateTextCode(coupon.code)){
            roomInteractor.saveCoupon(coupon)
        }else{
            throw  Exception(Constants.ERROR_EXIST)
        }
    }
}