package com.krossmanzs.appdesignpattern.dependencyinjection

class DarkKnight(private val weapon: Weapon) {
    fun setEquip(): String = "DarkKnights fighting with ${weapon.spear()}"
}