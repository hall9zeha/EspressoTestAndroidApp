package com.barryzeha.couponsapp.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.barryzeha.couponsapp.BR
import com.barryzeha.couponsapp.R
import com.barryzeha.couponsapp.common.utils.hideKeyboard
import com.barryzeha.couponsapp.databinding.ActivityMainBinding
import com.barryzeha.couponsapp.common.entities.CouponEntity
import com.barryzeha.couponsapp.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.channels.BroadcastChannel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var bind:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)


        setUpViewModel()
        setUpObservers()

    }

    private fun setUpViewModel(){
        val vm:MainViewModel by viewModels()

        bind.lifecycleOwner=this
        bind.setVariable(BR.viewModel,vm)
    }

    private fun setUpObservers() {
        bind.viewModel?.let{
             it.coupon.observe(this@MainActivity){coupon->
            bind.isActive = coupon !=null && coupon.isActive
       }
            it.getMessage().observe(this@MainActivity){msg->
                Snackbar.make(bind.root,msg,Snackbar.LENGTH_SHORT ).show()

            }
            it.hideKeyboard.observe(this@MainActivity){isHide->
                if(isHide) hideKeyboard(this@MainActivity, bind.root)
            }
        }

    }


}