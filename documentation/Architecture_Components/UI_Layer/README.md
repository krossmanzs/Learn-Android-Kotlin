# UI Layer
The role of the UI is to display the application data on the screen and also to serve as the
primary point of user interaction. Whenever the data changes, either due to user interaction (like
pressing a button) or external input (like a network responses), the UI should update to reflect
those changes. _Effectively_, the UI is a visual _representation of the application state as retrieved
from the data layer_.

However, the application data you get from the data layer is usually in a different format than the
information you need to display. For example, you might only need part of the data for the UI, or 
you might need to merge two different data sources to present information that is relevant to the user.
Regardless of the logic you apply, you need to pass the UI all the information it needs to render
fully. The UI layer is _the pipeline that converts application data changes to a form that the UI can
present and then displays it_

![UI Layer's role in app architecture](../res/mad-arch-ui-overview.png)

## UI Layer Architecture
The term UI refers to UI elements such as activities and fragments that display the data, independent
of what APIs they use to do this (Views or Jetpack Compose). Because the role of the data layer is
to hold, manage, and provide access to the app data, the **UI layer must perform the following steps**:
1. Consume **app data** and transform it into data the UI can easily render.
2. Consume **UI-renderable data** and transform it into UI elements for presentation to the user.
3. Consume **user input events** from those assembled UI elements and reflect their effects in thee UI
    data as needed
4. Repeat steps 1 through 3 for as long as necessary

## Define UI state
If the UI is what the user sees, the UI state is what the app says they should see. Like two sides
of the same coin, the UI is the visual representation of the UI state. Any changes to the UI state
are immediately reflected in the UI

![UI = UI Elements + UI State](../res/mad-arch-ui-elements-state.png)

## UI Layer Libraries
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

**More details on [UI Layer](https://developer.android.com/topic/architecture/ui-layer)**