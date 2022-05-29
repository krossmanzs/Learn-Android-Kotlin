# Fragments
A `Fragment` represents a reusable portion of our app's UI. A fragment **defines and manages its own
layout, has its own lifecycle, and can handle its own input events**. Fragments **cannot live on their
own**--they **must be _hosted_ by an activity or another fragment**. The fragment's view hierarchy
becomes part of, or _attaches to_, the host's view hierarchy.

# Modularity
Fragments introduce modularity and reuseability into our activity's UI by allowing to divide the UI
into discrete chunks. Activities are an ideal place to put global elements around our app's UI, such
as a navigation drawer. Conversely, fragments are better suited to define and manage the UI of a
single screen or portion of screen.

Consider an app that responds to various screen sizes. On larger screens, the app should display a
static navigation drawer and list in a grid layout. On smaller screens, the app should display a
bottom navigation bar and a list in a linear layout. Managing all of these variations in the 
activity can be unwieldy. Separating the navigation elements from the content can make this process
more manageable. The activity is then responsible for displaying the correct navigation UI while
the fragment displays the list with the proper layout.

![fragment and activity chunks](res/fragment-screen-sizes.png)

**More details at [Fragments](https://developer.android.com/guide/fragments)**