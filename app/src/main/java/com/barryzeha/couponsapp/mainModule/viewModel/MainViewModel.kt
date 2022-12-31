package com.barryzeha.couponsapp.mainModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barryzeha.couponsapp.R
import com.barryzeha.couponsapp.common.utils.getMsgErrorByCode
import com.barryzeha.couponsapp.common.utils.hideKeyboard
import com.barryzeha.couponsapp.common.entities.CouponEntity
import com.barryzeha.couponsapp.mainModule.model.MainRepository
import com.barryzeha.couponsapp.mainModule.model.MainRepositoryInterface
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 28/12/2022
 * Copyright (c)  All rights reserved.
 ***/
@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepositoryInterface):ViewModel() {

    //lo hacemos público para acceder con databinding desde el xml
    val coupon=MutableLiveData(CouponEntity())


     val hideKeyboard = MutableLiveData<Boolean>()

    private val message = MutableLiveData<Int>()
    fun getMessage() = message

    fun consultCouponByCode(){
        coupon.value?.code?.let{ code->
            viewModelScope.launch{
                hideKeyboard.value=true
              coupon.value=  mainRepository.consultCouponByCode(code)?: CouponEntity(code=code, isActive = false)
            }
        }
    }
    fun saveCoupon() {
        coupon.value?.let { coupon ->
            viewModelScope.launch {
                try {
                    coupon.isActive=true
                    mainRepository.saveCoupon(coupon)
                    consultCouponByCode()
                    message.value = R.string.save_coupon_msg
                } catch (e: Exception) {
                    message.value = getMsgErrorByCode(e.message)
                }
            }
        }
    }
}