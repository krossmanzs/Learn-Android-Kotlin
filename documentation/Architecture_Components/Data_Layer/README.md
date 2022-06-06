# Data Layer
While the UI Layer contains UI-related state and UI logic, the data layer contains _application data
and business logic_. The business logic is what gives value yo your app. It's made of real-world
business rules **that determine how application data must be created, stored, and changed**.

This separation of concerns allows the data layer to be used on multiple screens, share information
between different parts of the app, and reproduce business logic outside of the UI for unit testing.

## Data Layer Architecture
The data layer is made of repositories that each can contain zero to many data sources. You should
create a repository class for each different type of data you handle in your app. For example, you
might create a MoviesRepository class for data related movies or a PaymentsRepository class for
data related to payments.

![Data Layer Diagram](../res/mad-arch-data-overview.png)

Repository classes are responsible for the following tasks:
* Exposing data to the rest of the app.
* Centralizing changes to the data
* Resolving conflicts between multiple data sources.
* Abstracting sourcees of data from the rest of the app.
* Containing business logic.

The data exposed by this layer should be immutable so that it cannot be tampered with by other
classes, which would risk putting its values in an inconsistent state. Immutable data can also
be safely handled by multiple threads.

Following dependency injection best practices, the repository takes data sources as dependencies in
its constructor:

```kotlin
class ExampleRepository(
    private val exampleRemoteDataSource: ExampleRemoteDataSource, // network
    private val exampleLocalDataSource: ExampleLocalDataSource // database
) { /* ... */ }
```

## Expose APIs
Classes in the data layer generally expose functions to perform one-shot Create, Read, Update and
Delete (CRUD) calls ot to be notified of data changes over time. The data layer should expose
following for each of these cases:
* **One-shot operations**: The data layer should expose `suspend functions` in Kotlin; and for the Java
    , the data layer should expose functions that provide a callback to notify the result of the
    operation, or RxJava `Single`, `Maybe`, or `Completable` types
* **To be notified of data changes over time**: The data layer should expose flows in Kotlin; and for
    the Java, the data layer should expose a callback that emits the new data, or the RxJava `Observable`
    or `Flowable` type.

## Multiple Levels of Repositories
In some cases involving more complex business requirements, a repository might need to depend on
other repositories. This could be because the data involved is an aggregation from multiple data
sources, or because the responsibility needs to be encapsulated in another repository class.

For example, a repository that handles user authentication data, `UserRepository`, could depend on
other repositories such as `LoginRepository` and `RegistrationRepository` to fullfill its requirements.

![Multiple level of repo diagram](../res/mad-arch-data-multiple-repos.png)

## Lifecycle
Instances of classes in the data layer remain in memory as long as they reachable from a garbage
collection root--usually referenced from other objects in your app.

If a class contains in-memory data--for example, a cache--you might want to reuse the same instance 
of that class for a specific period of time. This is also referred to as the _lifecycle_ of the class
instance.

If the class's responsibility is crucial for the whole application, you can scope an instance of
that class to the `Application` class. This makes it so the instance follows the application's
lifecycle. Alternatively, if you only need to reuse the same instance in a particular flow in your
app--for example, the registration or login flow--then you should scope the instance to the class
that owns the lifecycle of that flow. For example, you could scope a `RegistrationRepository` that
contains in-memory data to the RegistrationActivity or the navigation graph of the registration flow.

**More details at [Data Layer Documentation](https://developer.android.com/topic/architecture/data-layer)**

### Note
* Separation of Concerns (SoC) artinya memisahkan block-block kode berdasarkan masing-masing tujuan/
    fitur tiap kode, mengurangi keterkaitan dari masing-masing kode tersebut. Supaya suatu saat kita
    ingin melakukan perubahan terhadap kode kita hanya perlu merubah block kode yang terkait dengan
    fitur yang akan kita ubah. _[Apa pengertian istilah separation of concerns kok sering dibicarakan ketika mau membuat kode yang baik?](https://kotakode.com/pertanyaan/12100/Apa-pengertian-istilah-separation-of-concerns-kok-sering-dibicarakan-ketika-mau-membuat-kode-yang-ba)_
* Traditionally, some developers have called repository classes that depend on other repository
    classes managers--for example, **UserManager** instead of **UserRepository**. You can use this
    naming convention if you prefer.
* [Scoping in Android and Hilt](https://medium.com/androiddevelopers/scoping-in-android-and-hilt-c2e5222317c0)