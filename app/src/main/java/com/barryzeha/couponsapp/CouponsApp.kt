package com.barryzeha.couponsapp

import android.app.Application
import androidx.room.Room
import com.barryzeha.couponsapp.common.database.CouponDatabase
import dagger.hilt.android.HiltAndroidApp

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 28/12/2022
 * Copyright (c)  All rights reserved.
 ***/
@HiltAndroidApp
class CouponsApp:Application() {
   /* companion object{
        lateinit var database: CouponDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database= Room.databaseBuilder(this, CouponDatabase::class.java,"CouponDatabase")
            .build()
    }*/
}