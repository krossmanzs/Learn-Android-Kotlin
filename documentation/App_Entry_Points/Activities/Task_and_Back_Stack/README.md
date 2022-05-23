# Task and Back Stack
**A task is a collection of activities that users interact with when trying to do something in your 
app**. These activities are arranged in a **_stack—the back stack—in_** the order in which each activity is 
opened. For example, an email app might have one activity to show a list of new messages. When the 
user selects a message, a new activity opens to view that message. This new `activity` is **added to the 
back stack**. Then, if the user presses or gestures `Back`, that new `activity` is **finished and popped 
off the stack**.

## Lifecycle of a task and its back stack

The device Home screen is the starting place for most tasks. When a user touches the icon for an app
or shortcut in the app launcher (or on the Home screen), that app's task comes to the foreground.
If no task exists for the app (the app has not been used recently), then a new task is created and
the main activity for that app opens as the root activity in the stack.

When the current activity starts another, the new activity is pushed on the top of the stack and
takes focus. The previous activity remains in the stack, but is stopped. When an activity stops,
the system retains the current state of its user interface. When the user performs the back action,
the current activity is popped from the top of the stack (the activity is destroyed) and the
previous activity resumes (the previous state of its UI is restored).

![back_stack_diagram](../res/diagram_backstack.png)

_A representation of how each new activity in a task adds an item to the back stack. When the user 
presses or gestures Back, the current activity is destroyed and the previous activity resumes._

If the user continues to press or gesture `Back`, then each activity in the stack is **popped off** to 
**reveal the previous one**, until the user **returns to the Home screen** (or to whichever activity was 
running when the task began). When all activities are removed from the stack, the task **no longer 
exists**.

**More details on [Tasks and the back stack](https://developer.android.com/guide/components/activities/tasks-and-back-stack)**

Useful video: [Tasks and the Back Stack (Android Development Patterns)](https://youtu.be/MvIlVsXxXmY)