# Parcelables and Bundles
`Parcelable` and `Bundle` objects are intended to be used across process boundaries such as with
**IPC/Binder transactions**, between **activities with intents**, and to store **transient state across
configuration changes**.

# Sending data between activities
When an app creates an `Intent` object to use in `startActivity(Intent)` in starting 
a new Activity, the app can pass in parameters using the `putExtra(String, String)` method.

The following code snippet shows an example of how to perform this operation in **Kotlin**:
```kotlin
val intent = Intent(this, MyActivity::class.java).apply {
    putExtra("application_id", "kross_123")
    // ...
}
startActivity(intent)
```

The OS parcels the underlying `Bundle` of the intent. Then, the OS creates the new activity,
un-parcels the data, and passes the intent to new activity.

**Google recommend** that we use `Bundle` class to set primitives known to the OS on `Intent` objects.
The `Bundle` class is highly optimized for marshalling and unmarshalling using parcels.

In some cases, we may need a mechanism to **send composite or complex objects across activities**. In
such cases, the custom class should implement `Parcelable`, and provide the appropriate
`writeToParcel(Parcel, int)` method. It must also provide a **non-null** field called `CREATOR` that
implements the `Parcelable.Creator` interface, whose `createFromParcel()` method is used for
converting the `Parcel` back to the current object. See [Parcelable](https://developer.android.com/reference/android/os/Parcelable)
object for more details.

When sending data via intent, we should be careful to limit the data size to a few KB. Sending
too much data can cause the system to throw a `TransactionTooLargeException` exception

# Example
See [Android Parcelable example – Passing Objects via Bundle!](https://youtu.be/Nvz2cUehJLU)

### See [Parcelables and Bundles](https://developer.android.com/guide/components/activities/parcelables-and-bundles) for more details