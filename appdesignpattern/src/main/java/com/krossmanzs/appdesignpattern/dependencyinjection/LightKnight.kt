package com.krossmanzs.appdesignpattern.dependencyinjection

class LightKnight(private val weapon: Weapon) {
    fun setEquip(): String = "LightKnights fighting with ${weapon.sword()}"
}