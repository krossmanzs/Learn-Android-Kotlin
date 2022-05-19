# Services
A Service is an application component that can **perform long-running operations in the background**. 
It does not provide a user interface. Once started, a service might continue running for some time, 
even after the user switches to another application. Additionally, a component can bind to a service 
to interact with it and even perform interprocess communication (IPC). For example, a service can 
handle network transactions, play music, perform file I/O, or interact with a content provider, 
all from the background.

By default, Android Services run in the **same process** as the main application thread does. This kind 
of service is also known as a **local service**.

For **resource-intensive tasks**, the service executes the work on the **background thread**. 
This lets the user run actions without being disturbed. For example, if the user wants to make a 
call or check messages while updating a server, they can do so without interrupting or aborting 
the update action.

To do this, the developer needs to **create a background thread and manually specify which tasks 
should run on it** because the service doesn’t directly support the **thread implementation**.

Since an Android Service doesn’t have a user interface, it isn’t bound to the activity’s lifecycle. 
That means you can run it even when the user isn’t interacting with the app.

## Types Of Services
These are the three different types of services:
* **Foreground**

    A foreground service performs some operation that is **noticeable to the user**. For example, an audio 
app would use a foreground service to play an audio track. Foreground services must display a Notification. 
Foreground services continue running even when the user isn't interacting with the app.

    When you use a foreground service, you must display a notification so that users are actively aware 
that the service is running. This notification **cannot be dismissed** unless the service is either stopped 
or removed from the foreground. More at [foreground services](https://developer.android.com/guide/components/foreground-services).


* **Background**

  A background service performs an operation that **isn't directly noticed by the user**. 
For example, if an app used a service to compact its storage, that would usually be a background service.


* **Bound**

  A service is bound when an application component binds to it by calling `bindService()`. A bound 
service offers a **client-server interface** that allows components to **interact with the service**, 
send requests, receive results, and even do so across processes with **interprocess communication 
(IPC)**. A bound service runs only **as long as another application component is bound to it**. Multiple 
components can bind to the service at once, but when all of them unbind, the service is destroyed.

### More details at [Services overview](https://developer.android.com/guide/components/services)

### Source
* https://www.raywenderlich.com/20123726-android-services-getting-started