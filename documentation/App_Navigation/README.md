# App Navigation
Navigation refers to the interactions that **allow users to navigate across, into, and back out from
the different pieces of content within our app**. Android Jetpack's Navigation component helps to
implement navigation, from **simple button clicks to more complex patterns**, such as app bars and the
navigation drawer. The navigation component also ensures a consistent and predictable user 
experience by adhering to an established [set of principles](https://developer.android.com/guide/navigation/navigation-principles)

The Navigation component consists of three key parts that are described below:
* **Navigation Graph**: An XML resource that contains all navigation-related information in one
  centralized location.
* `NavHost`: An empty container that displays destinations from our navigation graph.
* `NavController`: An object that manages app navigation within `NavHost`.

As we navigate through our app, we tell the `NavController` that you want to navigate either along
a specific path in our navigation graph or directly to a specific destination. The `NavController`
then shows the appropriate destination in the `NavHost`.

The Navigation component provides a number of other benefits, including the following:
* Handling fragment transactions
* Handling Up and Back actions correctly by default
* Providing standardized resources for animations and transitions
* Implementing and handling deep linking
* Including Navigation UI patterns, such as navigation drawers and bottom navigation, with minimal
    additional work
* Safe Args - a Gradle plugin that provides type safety when navigating and passing data between
    destinations
* `ViewModel` support - we can scope a `ViewModel` to a navigation graph to share UI-related data
    between the graph's destinations.

In addition, you can use Android Studio's [Navigation Editor](https://developer.android.com/guide/navigation/navigation-getting-started) 
to view and edit your navigation graphs.

**More details at [Navigation](https://developer.android.com/guide/navigation)**