package com.barryzeha.couponsapp.di

import android.app.Application
import androidx.room.Room
import com.barryzeha.couponsapp.common.database.CouponDatabase
import com.barryzeha.couponsapp.mainModule.model.MainRepository
import com.barryzeha.couponsapp.mainModule.model.MainRepositoryInterface
import com.barryzeha.couponsapp.mainModule.model.RoomDatabaseInteractor
import com.barryzeha.couponsapp.mainModule.model.RoomInteractorInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 29/12/2022
 * Copyright (c)  All rights reserved.
 ***/
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun dataBaseProvider(app:Application) = Room.databaseBuilder(
        app,
        CouponDatabase::class.java,
        "CouponDatabase"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun roomInteractorProvider(db:CouponDatabase):RoomInteractorInterface= RoomDatabaseInteractor(db)

    @Provides
    fun couponRepositoryProvider(roomInteractor:RoomInteractorInterface):MainRepositoryInterface = MainRepository(roomInteractor)


}