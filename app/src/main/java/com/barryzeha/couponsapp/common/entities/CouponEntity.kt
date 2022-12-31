package com.barryzeha.couponsapp.common.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 28/12/2022
 * Copyright (c)  All rights reserved.
 ***/
@Entity(tableName = "CouponEntity", indices = [Index(value =["code"], unique = true)])
data class CouponEntity (
    @PrimaryKey (autoGenerate = true)var id:Long=0,
    var code:String="",
    var description:String="",
    var isActive:Boolean=true
)