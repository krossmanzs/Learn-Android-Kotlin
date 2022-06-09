# Factory Pattern
As the name suggests, Factory **takes care of all the object creation logic**. In this pattern,
a **factory class controls which object to instantiate**. Factory pattern comes in handy when dealing
with many common objects. You can use it where you might now want to specify a concrete class.

Factory Pattern uses factory methods to handle the problem of having to **create multiple objects
without specifying the exact class of object that will be created**. In Android(Kotlin/Java), this is
achieved by implementing a common interface in classes and providing access to the class objects
through a Factory method.

Code example:

```kotlin
// 1
interface HostingPackageInterface {
    fun getServices(): List<String>
}

//2 
enum class HostingPackageType {
    STANDARD,
    PREMIUM
}

// 3
class StandardHostingPackage: HostingPackageInterface {
    override fun getServices(): List<String>{
        return ...    
    }
}

// 4
class PremiumHostingPackage: HostingPackageInterface {
    override fun getServices(): List<String>{
        return ...    
    }
}

//5 
object HostingPackageFactory {
    // 6
    fun getHostingFrom(type: HostingPackageType): HostingPackageInterface {
        return when (type) {
            HostingPackageType.STANDARD -> {
                StandardHostingPackage()
            }
            HostingPackageType.PREMIUM -> {
                PremiumHostingPackage()
            }
        }
    }
}

```

Here's a walk through the code:
1. This is a basic interface for all the hosting plans.
2. This enum specifies all the hosting package types.
3. `StandardHostingPackage` and `PremiumHostingPackage` conforms to the interface and implements 
     the required method to list all the services.
4. `HostingPackageFactory` is a singleton class with a helper method.
5. `getHostingFrom` inside `HostingPackageFactory` is responsible for creating all the objects.

You can use it like this:

```kotlin
val standardPackage = HostingPackageFactory.getHostingFrom(HostingPackageType.STANDARD)
```

**It helps to keep all object creation in one class**. If used inappropriately, a factory class can get 
bloated due to excessive objects. Testing can also become difficult as the factory itself is
responsible for all the objects.

## Singleton
By using the keyword `object` in your app, you're defining a **singleton**. A singleton is a design
pattern in which a given class has only one single instance inside the entire app. A singleton's two
most common use cases are:
1. To share data between two otherwise unrelated areas of your project.
2. To share logic that doesn't have associated state throughout the app.

Keep in mind that singletons are not a data persistence solution. Data in singletons live only
as logn as your app is in memory. _[source](https://www.raywenderlich.com/23623842-object-in-kotlin-and-the-singleton-pattern#toc-anchor-002)_

### Source
* [Introduction to Factory Pattern on Android](https://www.codementor.io/@devmike01/factory-pattern-here-is-how-its-done-on-android-t0jghhfof)
* [Common Design Patterns and App Architectures for Android](https://www.raywenderlich.com/18409174-common-design-patterns-and-app-architectures-for-android#toc-anchor-006)
* [Object in Kotlin and the Singleton Pattern](https://www.raywenderlich.com/23623842-object-in-kotlin-and-the-singleton-pattern#toc-anchor-002)