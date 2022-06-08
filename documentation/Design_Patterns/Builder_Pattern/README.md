# Builder Pattern
At a certain restaurant, you create your own sandwich: you choose the bread, ingredients and condiments
you'd like on your sandwich from a checklist on a slip of paper. Even though the checklist instructs
you to _build your own_ sandwich, you only fill out the form and hand it over the counter. You don't
build the sandwich, just customize and consume it.

Similarly, the **Builder** pattern simplifies the creation of objects, like slicing bread and stacking
pickles, from its representation, a yummy sandwich. Thus, the same construction process can create
objects of the same class with different properties.

In Android, an example of the Builder pattern is `AlertDialog.Builder`:
```kotlin
AlertDialog.Builder(this)
    .setTitle("Sandwich Dialog")
    .setMessage("Please use the spicy mustard.")
    .setNegativeButton("No Thanks") {dialogInterface, i -> 
        // "No thanks" action
    }
    .setPositiveButton("OK") {dialogInterface, i ->
        // "OK" action
    }
    .show()
```

Output:

![Dialog-Builder](../res/sandwich-dialog-builder.png)

This builder proceeds **step-by-step** and lets you specify only the parts of `AlertDialog` that you need
to specify.

## Advantages
1. When you initialize your object, you do not need to have all the data to pass it to your object.
    As a result, it could be helpful to control over construction process.
2. It implements a clear separation between the construction and representation of an object.
    Furthermore, it hides internal representation of the objects from the client.
3. It handles the changes in the internal representation of objects.
4. It can improve the flexibility and readability of source codes.
5. It avoids the _Telescoping Constructor Pattern_. For instance:

```kotlin

class Pizza(
    private size:Int
){
    constructor(
    private size:Int,
    private cheese:Boolean
    ){ /* ... */ }

    constructor(
    size:Int,
    cheese:Boolean,
    meat:Boolean
    ){ /* ... */ }

    constructor(
    size:Int,
    cheese:Boolean,
    meat:Boolean,
    bacon:Boolean
    ){ /* ... */ }
}

```

## Conclusion
Design Patterns play key roles in having a high quality Android apps and following clean code 
principles. In this essay, using Builder Design Pattern was considered in Android Development. Also
some advantages were explained, such as providing flexibility and readability of codes. However, the
number of lines of code increase at least to double in builder pattern.

### Source
* [Builder Design Pattern in Android](https://medium.com/kayvan-kaseb/builder-design-pattern-in-android-a38dccb75485)
* [Common Design Patterns and App Architectures for Android](https://www.raywenderlich.com/18409174-common-design-patterns-and-app-architectures-for-android#toc-anchor-003)