package com.barryzeha.couponsapp.common.adapters

import android.view.View
import androidx.databinding.BindingAdapter

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 28/12/2022
 * Copyright (c)  All rights reserved.
 ***/

@BindingAdapter("isGone")
fun bindIsGone(view:View, isGone:Boolean){
    view.visibility = if(isGone) View.GONE else View.VISIBLE
}