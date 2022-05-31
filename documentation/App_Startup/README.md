# App Startup (Jetpack)
The _App Startup library_ provides a straightforward, performant way to initialize components at
application startup. Both library developers and app developers can use App Startup to streamline
startup sequences and explicitly set the order of initialization.

Instead of defining separate content providers for each component you need to initialize, App Startup
allows you to define component initializers that share a single content provider. This can
significantly improvce app startup time.

**More details onn [App Startup](https://developer.android.com/topic/libraries/app-startup)**