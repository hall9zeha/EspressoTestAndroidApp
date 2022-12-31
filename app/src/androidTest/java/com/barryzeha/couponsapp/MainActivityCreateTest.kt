package com.barryzeha.couponsapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.barryzeha.couponsapp.mainModule.view.MainActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/****
 * Project CouponsApp
 * Created by Barry Zea H. on 31/12/2022
 * Copyright (c)  All rights reserved.
 ***/
@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityCreateTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)//para tener acceso a la main activity en este caso

    @Test
    fun createCouponTest(){
        //accedemos al editText edtConsult para verificar que esté vacío al iniciar la actividad
        val edtConsult = onView(withId(R.id.edtConsult))
        edtConsult.check(matches(withText("")))
        //hacemos click en el edtConsult para insertarle una cadena de texto
        edtConsult.perform(click())
        edtConsult.perform(replaceText("CuponTest01"))


        //Ahora accedemos al botón de consultar
        val btnConsult = onView(withId(R.id.btnConsult))
        //hacemos click en el botón para consultar si el cupón existe
        btnConsult.perform(click())

        //accedemos al botón crear cupón
        val btnCreate = onView(withId(R.id.btnCreate))
        //consultamos si es visible o no
        btnCreate.check(matches(isDisplayed()))

        //Una vez habilitado el btnCreate procedemos a insertar la descripción en el edtDescription
        val edtDescription = onView(withId(R.id.edtDescription))
        edtDescription.perform(replaceText("Descripción test de cupónText01"))

        //le pondremos un nombre de cupón que ya existe para generar el error de cupón existetente
        edtConsult.perform(replaceText("cupon02"))//-> cambiar el nombre del cupón para evitar el error de cupón existente
        btnCreate.perform(click())

        //accedemos al mensaje que el snackbar muestra cuando presionamos en btnCreate
        //En caso de que el cupón exista el mensaje sera de error y el test no pasará
        val snackbarMsg=onView(withId(com.google.android.material.R.id.snackbar_text))
        snackbarMsg.check(matches(withText(R.string.save_coupon_msg)))


    }
    /*
    * Corrobora que el btnCreate no es visible
    * */

    @Test
    fun couponExistsTest(){
        //accedemos al editText edtConsult para verificar que esté vacío al iniciar la actividad
        val edtConsult = onView(withId(R.id.edtConsult))
        edtConsult.check(matches(withText("")))
        //hacemos click en el edtConsult para insertarle una cadena de texto
        edtConsult.perform(click())
        //ponemos el nobre de un cupón existente
        edtConsult.perform(replaceText("cupon01"))


        //Ahora accedemos al botón de consultar
        val btnConsult = onView(withId(R.id.btnConsult))
        //hacemos click en el botón para consultar si el cupón existe
        btnConsult.perform(click())

        //accedemos al botón crear cupón
        val btnCreate = onView(withId(R.id.btnCreate))
        //si el cupón ya existe este botón no será visible
        btnCreate.check(matches(not(isDisplayed())))
    }
    /*
    * Verifica que un cupón ya existe y no se puede crear uno con el nombre duplicado
    * */
    @Test
    fun couponDuplicateCodeTest(){
        //accedemos al editText edtConsult para verificar que esté vacío al iniciar la actividad
        val edtConsult = onView(withId(R.id.edtConsult))
        edtConsult.check(matches(withText("")))
        //hacemos click en el edtConsult para insertarle una cadena de texto que no existe
        // y habilite el editText de descripción
        edtConsult.perform(click())
        edtConsult.perform(replaceText("CuponTest01"))


        //Ahora accedemos al botón de consultar
        val btnConsult = onView(withId(R.id.btnConsult))
        //hacemos click en el botón para consultar si el cupón existe
        btnConsult.perform(click())

        //accedemos al botón crear cupón
        val btnCreate = onView(withId(R.id.btnCreate))
        //consultamos si es visible o no
        btnCreate.check(matches(isDisplayed()))

        //Una vez habilitado el btnCreate procedemos a insertar la descripción en el edtDescription
        val edtDescription = onView(withId(R.id.edtDescription))
        edtDescription.perform(replaceText("Descripción test de cupón duplicado"))

        //le pondremos un nombre de cupón que ya existe para generar el error de cupón existetente
        edtConsult.perform(replaceText("cupon02"))
        btnCreate.perform(click())

        //accedemos al mensaje que el snackbar muestra cuando presionamos en btnCreate
        //En caso de que el cupón exista el mensaje sera de "El cupón ya existe" y el test pasará
        //porque es el error que esperamos
        val snackbarMsg=onView(withId(com.google.android.material.R.id.snackbar_text))
        snackbarMsg.check(matches(withText(R.string.error_unique_code)))
    }
}