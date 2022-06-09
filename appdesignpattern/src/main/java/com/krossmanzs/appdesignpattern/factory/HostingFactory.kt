package com.krossmanzs.appdesignpattern.factory

interface HostingPackage {
    fun getService(): String
}

enum class HostingType {
    PREMIUM,
    STANDARD
}

class Standard : HostingPackage {
    override fun getService(): String {
        return "Standard"
    }
}

class Premium : HostingPackage {
    override fun getService(): String {
        return "Premium"
    }
}

object HostingFactory {
    fun getHostingFrom(type: HostingType): HostingPackage {
        return when (type) {
            HostingType.PREMIUM -> Premium()
            HostingType.STANDARD -> Standard()
        }
    }
}


