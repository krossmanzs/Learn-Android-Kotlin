package com.krossmanzs.appdesignpattern.factory

// Learn it from
// https://youtu.be/qUeHnjXSCMg
// https://medium.com/dot-intern/penggunaan-kotlin-sealed-class-untuk-state-management-pada-mvvm-pattern-android-68829863362e

sealed class Country {
    object China: Country()
}

object Indonesia: Country()
class Singapore(val someProperty: String): Country()
data class USA(val someProperty: String): Country()
//class Poland: Country()

class Currency(val code: String)

object CurrencyFactory {
    fun currencyForCountry(country: Country): Currency =
        when(country) { // exhaustive
            is Indonesia -> Currency("IDR")
            is Singapore -> Currency("SGD")
            is USA -> Currency("USD")
            is Country.China -> Currency("CNY")
        }
}