# Intent

An intent is an **abstract description of an action that will execute at a later time**. For example,
it allows you to **trigger the entry points of app components** or to send messages to broadcast
receivers.

![intent-diagram](../res/intent_diagram.png)

How an implicit intent is delivered through the system to start another activity: 
* **[1]** Activity A creates an Intent with an action description and passes it to startActivity(). 
* **[2]** The Android System searches all apps for an intent filter that matches the intent. When a match 
is found, 
* **[3]** the system starts the matching activity (Activity B) by invoking its onCreate() method and 
passing it the Intent.

## Uses

According to [Android Document](https://developer.android.com/guide/components/intents-filters),
there are three fundamental use cases:
* **Starting an activity**
  
  An `Activity` represents a single screen in app. We can start an `Activity` by passing `Intent` to
  `startActivity()`. **The `Intent` describes the activity to start and carries any necessary data.**


* **Starting a service**

  A `Service` is a component that performs operations in the background without a user interface.
  With Android 5.0 (API level 21) and later, you can start a service with 
  [JobScheduler](https://developer.android.com/reference/android/app/job/JobScheduler).

  For version earlier than Android 5.0 (API level 21), you can start a service by using methods of
  the `Service` class. You can start a service to perform a one-time operation (such as downloading
  a file) by passing an `Intent` to `startService()`. **The `Intent` describes the service to start
  and carries any necessary data.**

  If the service is designed with a client-server interface, you can bind to the service from 
  another component by passing an `Intent` to `bindService()`.


* **Delivering a broadcast**

  A broadcast is a message that any app can receive. The system delivers various broadcasts for 
  system events, such as when the system boots up or the device starts charging. **You can deliver a
  broadcast to other apps by passing an `Intent` to `sendBroadcast()` or `sendOrderedBroadcast()`**

## Intent types
There are two types of intents:
* **Implicit Intents**

  Specify which application will satisfy the intent, by **supplying either the target app's package 
  name or a fully-qualified component class name**. You'll typically use an explicit intent to **start
  a component in your own app**, because you know the class name of the activity or service you want
  to start. For example, you might start a new activity within your app in response to a user
  action, or start a service to download a file in the background.


* **Implicit intents**

  do not name a specific component, but instead **declare a general action to perform, which allows a
  component from another app to handle it**. For example, if you want to show the user location on a
  map, you can use an implicit intent to request that another capable app show a specified location
  on a map.

## Intent Filters
  An `Intent Filter` is an expression in an app's manifest file that specifies the type of intents
  that the component would like to receive.

  When you create an implicit intent, the Android system finds the appropriate component to start
  by comparing the contents of the intent to the intent filters declared in the manifest file of
  other apps on the device. If the intent matches an `intent filter`, the system starts that
  component and delivers it the `Intent` object.

## Example
**AndroidManifest.xml**
```xml
<activity android:name=".HelloWorld"
        android:label="@string/app_name">
  <intent-filter>
    <action android:name="android.intent.action.VIEW"/>
    <category android:name="android.intent.category.DEFAULT"/>
    <category android:name="android.intent.category.BROWSABLE"/>
    <data android:scheme="https" android:host="google.com"/>
  </intent-filter>
</activity>
```

**Launch HelloWorld**
```kotlin
intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
startActivity(intent)
```

### Source
* https://getstream.io/blog/android-developer-roadmap-part-2/
* https://stackoverflow.com/questions/3321514/what-are-intent-filters-in-android