# Android Architecture Patterns
When developers work on a real mobile application whose nature is dynamic and will expand its
features according to the user's need, then it is not possible to write core logic in activities
or fragments. To structure the project's code and to give it a modular design(separated code parts),
architecture patterns are applied to separate the concerns.

In this learning path I'll cover those patterns:
* [MVVM (Model-View-ViewModel)](MVVM)
* [MVP (Model-View-Presenter)](MVP)
* [MVI (Model-View-Intent)](MVI)
* MVC (Model-View-Controller)
* Clean Architecture

The main idea of all these patterns is to organize the project in a proper way so that all the codes
get covered in the Unit Testing. Moreover, it is very helpful in the maintenance of the software,
to add and remove features and developers can keep a track of various crucial logic parts.

## What should I use?
* **MVC**: If you're talking about using just plain and simple Activities and Fragments in your App,
    without Dagger, without any DI, without layers, its not recommended at any point. Unless our App
    is just one Activity and one screen, we should always use an architecture that splits our App
    into layers. The old-school Android MVC architecture build just with the classes from the SDK
    isn't fit unless we're building a **really really small project**.


* **MVP**: Nowadays the MVp architecture is one of the most stable architectures out there, there's
    not much second guessing when implementing it, it's already well defined everywhere. **In a nutshell
    we just need our UI (Fragment/Activity), the View interface that is going to be implemented in
    that UI and the one that is going to be used as callback from the Presenter, the Presenter's
    interface, the Presenter's implementation, the Repositories, the Repositories interfaces, and
    the UseCases or Interactors**. Everything in a MVP architecture is very well defined, all the layers
    are separated one from another and the communication mechanism is usually done through callback
    interfaces.


* **MVVM**: It's definitely the architecture that is gonna be used by default in the future. We got
    rid of a lot of boilerplate code with the MVVM architecture. The communication between layers
    is much more simple by using LiveData. There's no need to define 500 components when creating
    new screen, like in the MVP.


* **Multi module architecture** vs **single module architecture**: Both MVVM and MVP can implement
    multi module architectures or single module architectures. Let's say we have a social network
    App of some kind, then we should use a multi module architecture, this is going to allow us to 
    keep the features separated into modules, the building time(if the module references and the
    dependency injection is properly done) is going to be linear-ish and It's going to help us to 
    work comfortably with our team.

More details on what pattern should I implement check on
[Android - How to decide which architecture fits better the application requirements](https://stackoverflow.com/questions/51224607/android-how-to-decide-which-architecture-fits-better-the-application-requireme)

### Source
* [Android Architecture Patterns](https://www.geeksforgeeks.org/android-architecture-patterns/)