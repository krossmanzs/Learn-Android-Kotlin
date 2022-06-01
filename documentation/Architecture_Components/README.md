# App Architecture
App architecture design is an important consideration for ensuring that your apps are robust,
testable, and maintainable. Android provides a set of libraries and components to help our app
according to best practices

## [Guide to app architecture](../App_Architecture/README.md#recommended-app-architecture)

## Android Jetpack
Google supports a suite of libraries to achieve the app architecture defined under 
[Android Jetpack](https://developer.android.com/jetpack). Let's see the most used libraries in
Android Jetpack for each layer:

### UI Layer Libraries
Android Jetpack supports the following useful UI-related libraries to help in creating the right
app architecture:
* **ViewBinding**: generates a binding class for each XML layout file, which contains direct
    references to all views that have an ID in the corresponding layout.
* **DataBinding**: [Data Binding](https://developer.android.com/topic/libraries/data-binding) lets
    you generate a binding class for XML layouts that includes a `layout` tag based on the
    annotation processor. Data binding is an essential part of the MVVM architecture that links the
    View and ViewModel with observer patterns, properties, and event callbacks.
* **ViewModel**: [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) 
    is a state holder to store and manage UI-related data in configuration changes.
* **LiveData**: [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) is
    a lifecycle-aware data holder, which can be observed by multiple [Observer](https://developer.android.com/reference/androidx/lifecycle/Observer)
    . The observers are notified of data changes depending on state of the [LifecycleOwner](https://developer.android.com/reference/androidx/lifecycle/LifecycleOwner).

* **Lifecycle**: Jetpack's [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)
    allows you to build independent components, which observe the lifecycle changes of lifecycle 
    owners such as activities and fragments. 

### Data Layer Libraries
Android Jetpack supports data layer libraries that handle tasks like persisting data to the
database or performing background tasks:
* **DataStore**: [DataSource](https://developer.android.com/topic/libraries/architecture/datastore)
    is a storage library that allows you to store lightweight key-value pairs in local storage.
* **Room**: Room persistence provides an abstraction layer over [SQLite Databases](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase)
    that simplifies querying and accessing the database without complicated SQL statements.
* **WorkManager**: WorkManager is a background processing API, which runs deferrable, guaranteed
    background work by scheduling [work](https://developer.android.com/topic/libraries/architecture/workmanager/how-to/define-work).

More details on:
* [The 2022 Android Developer Roadmap: Part 3](https://getstream.io/blog/android-developer-roadmap-part-3/#architecture-components)
* [Guide to app architecture](https://developer.android.com/topic/architecture)