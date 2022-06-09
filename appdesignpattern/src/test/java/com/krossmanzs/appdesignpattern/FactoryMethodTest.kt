package com.krossmanzs.appdesignpattern

import com.krossmanzs.appdesignpattern.factory.CurrencyFactory
import com.krossmanzs.appdesignpattern.factory.Indonesia
import com.krossmanzs.appdesignpattern.factory.USA
import org.junit.Assert
import org.junit.Test

class FactoryMethodTest {
    @Test
    fun currencyTest() {
        val indonesiaCurrency = CurrencyFactory.currencyForCountry(Indonesia).code
        println("Indonesia currency: $indonesiaCurrency")

        val usaCurrency = CurrencyFactory.currencyForCountry(USA("")).code
        println("USA currency: $usaCurrency")

        Assert.assertEquals(indonesiaCurrency,"IDR")
    }
}