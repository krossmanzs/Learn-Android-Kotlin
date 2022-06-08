package com.krossmanzs.appdesignpattern

import com.krossmanzs.appdesignpattern.builder.Component
import junit.framework.Assert.assertEquals
import org.junit.Test

class ComponentTest {
    @Test
    fun builderTest() {
        val component = Component.Builder()
            .setParam1("Halo")
            .setParam3(true)
            .build()

        assertEquals(component.param1, "Halo")
        assertEquals(component.param2, null)
        assertEquals(component.param3, true)
    }
}