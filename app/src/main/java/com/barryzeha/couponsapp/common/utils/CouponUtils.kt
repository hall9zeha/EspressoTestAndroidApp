package com.barryzeha.couponsapp.common.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.barryzeha.couponsapp.R

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 28/12/2022
 * Copyright (c)  All rights reserved.
 ***/
fun validateTextCode(code:String):Boolean{
    return !(code.length<5 || code.length>10)
}

fun getMsgErrorByCode(errorCode:String?):Int = when(errorCode){
    Constants.ERROR_EXIST -> R.string.error_unique_code
    Constants.ERROR_LENGTH -> R.string.error_length_code
    else -> R.string.error_code_unknown
}

fun hideKeyboard(context:Context, view: View){
    val inn = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    inn?.hideSoftInputFromWindow(view.windowToken,0)
}