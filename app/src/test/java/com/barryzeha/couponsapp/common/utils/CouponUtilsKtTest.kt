package com.barryzeha.couponsapp.common.utils

import org.junit.Assert.*
import org.junit.Test
import com.barryzeha.couponsapp.R
import com.barryzeha.couponsapp.common.entities.CouponEntity

/****
 * Project CouponsApp
 * Created by Barry Zea H. on 29/12/2022
 * Copyright (c)  All rights reserved.
 */
class CouponUtilsKtTest{
    /*
    * Puedes poner más de una aserción por método
    * */
    @Test
    fun validateTextCodeSuccessTest(){
        //simulamos la respuesta de nuestro método en utils validateTextCode() que devuelve un true
        //si la longitud del string es >=5 && <=10
        val code = "Martha"
        assertTrue(validateTextCode(code))
    }
    @Test
    fun validateTextCodeEmptyTest(){
        //simulamos una falla con el  método en utils validateTextCode() que devuelve un true
        //si la longitud del string es >=5 && <=10
        val code = ""
        assertFalse(validateTextCode(code))
    }

    /*
    * Simulamos la devolución de un mensaje de error "error desconocido" al pasarle un string nulo a nuestro
    * método getMessageErroBycode()
    * */
    @Test
    fun getMessageErrorByCodeNullTest(){
        val errorCode = null
        val expectedValue = R.string.error_code_unknown
        val result = getMsgErrorByCode(errorCode)

        assertEquals("Error al evaluar un null",expectedValue,result)
    }

    @Test
    fun getMessageErrorByCodeExistsTest(){
        val errorCode = Constants.ERROR_EXIST
        val expectedValue = R.string.error_unique_code
        val result = getMsgErrorByCode(errorCode)

        assertEquals("Error al evaluar un código existente",expectedValue,result)
    }

    @Test
    fun getMessageErrorByCodeLengthTest(){
        val errorCode = Constants.ERROR_LENGTH
        val expectedValue = R.string.error_length_code
        val result = getMsgErrorByCode(errorCode)

        assertEquals("Error al evaluar la longitud válida",expectedValue,result)
        assertNotEquals("El recurso no existe",-1,result)
    }

    @Test
    fun checkNotNullCoupon(){
        val coupon = CouponEntity(code="Illustrator01", description = "Aprende illustrator")
        assertNotNull("El cupón no debería ser nulo",coupon)
    }

    @Test
    fun checkIfEqualsArrays(){
        val currentArray= arrayOf("Barry", "Martha")
        val expectedArray= arrayOf("Barry", "Martha")

        assertArrayEquals("Los arreglos deberían ser iguales",expectedArray,currentArray)
    }
}