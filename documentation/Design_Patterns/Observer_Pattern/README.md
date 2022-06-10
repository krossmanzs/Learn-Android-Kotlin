# Observer Pattern
The **Observer** pattern defines a **one-to-many dependency between objects**. When one object changes
state, **its dependents get a notification and updates automatically**. Anytime the state of one of
the objects (the "subject" or "observable") changes, all of the other objects ("observers") that
depend on it are notified.

This pattern is versatile. You can use it for operations of indeterminate time, such as API calls. 
You can also use it respond to user input.

## Benefits
* The subject knows little about its observers. The only thing it knows is that the observers implement
    or agree to a certain contract or interface.
* Subjects can be reused without involving their observers, and the same goes for observers too.
* No modification is done to the subject to accomodate a new observer. The new observer just needs
    to implement an interface that the subject is aware of and then register to the subject.
* An observer can be registered to more than one subject it's registered to.

## Example
Let's use the example of users that have subscribed to receive offers from **Envato Market** via email.
The users in this case are observers. Anytime there is an offer from **Envato Market**, they get 
notified about it via email. Each user can then either buy into the offer or decide that they might 
not be really interested in it at that moment. A user (an observer) can also subscribe to receive
offers from another e-commerce marketplace if they want and might later completely unsubscribe from
receiving offers from any of them.

It was originally popularized by the RxAndroid framework, also known as Reactive Android. This library
lets you implement this pattern throughout your app:

```kotlin
apiService.getData(someData)
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe( /* an Observer */ )
```

In short, you define `Observable` objects that will _emit_ values. These values can emit all at once
, as a continuous stream or at any rate and duration.

`Subcriber` objects will _listen_ these values and react to them as they arrive. For example, you 
can open a subscription when you make an API call, listen to the server's response and react
accordingly.

## Note
_Based on [this article](https://stackoverflow.com/questions/70069830/how-to-implement-observer-pattern-in-android-studio)_
, we cannot observe objects in different activities. All we can do is pass the data between activities
using Intents.

In Android, the observer pattern is implemented by using the **class ViewModel and the class LiveData/
StateFlow**. If we want to have 3 different screens that observe a single object for changes. **We need to
have 3 Fragments that share the same Activity and the same ViewModel**.

### Sources
* [Android Design Patterns: The Observer Pattern](https://code.tutsplus.com/tutorials/android-design-patterns-the-observer-pattern--cms-28963)
* [Common Design Patterns and App Architectures for Android](https://www.raywenderlich.com/18409174-common-design-patterns-and-app-architectures-for-android#toc-anchor-014)