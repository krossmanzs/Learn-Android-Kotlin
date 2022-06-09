package com.krossmanzs.appdesignpattern.dependencyinjection

class Weapon(
        private val spearName: String,
        private val swordName: String
    ) {
    fun spear(): String = spearName
    fun sword(): String = swordName
}