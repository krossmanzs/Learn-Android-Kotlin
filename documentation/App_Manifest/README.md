# App Manifest
Every Android project must have an AndroidManifest.xml file which describes essential information 
about the application such as the package name, entry points, components, permissions, and metadata.

It performs some other tasks also:

* It is responsible to protect the application to access any protected parts by providing the 
  permissions.
* It also declares the android api that the application is going to use.
* It lists the instrumentation classes. The instrumentation classes provides profiling and other 
  informations. These informations are removed just before the application is published etc.

This is the required xml file for all the android application and located inside the root directory.

A simple AndroidManifest.xml file looks like this:

```xml
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"  
        package="com.javatpoint.hello"  
        android:versionCode="1"  
        android:versionName="1.0" >  
      
        <uses-sdk  
            android:minSdkVersion="8"  
            android:targetSdkVersion="15" />  
      
        <application  
            android:icon="@drawable/ic_launcher"  
            android:label="@string/app_name"  
            android:theme="@style/AppTheme" >  
            <activity  
                android:name=".MainActivity"  
                android:label="@string/title_activity_main" >  
                <intent-filter>  
                    <action android:name="android.intent.action.MAIN" />  
      
                    <category android:name="android.intent.category.LAUNCHER" />  
                </intent-filter>  
            </activity>  
        </application>  
      
    </manifest>  
```

## Elements of the AndroidManifest.xml file

The elements used in the above xml file are described below.
* **&lt;manifest&gt;** is the root element of the AndroidManifest.xml file. It has package attribute that 
describes the package name of the activity class.


* **&lt;application&gt;** is the subelement of the manifest. It includes the namespace declaration. 
  This element contains several subelements that declares the application component such as activity 
  etc.
  
  The commonly used attributes are of this element are icon, label, theme etc.
    * **android:icon** represents the icon for all the android application components.
    * **android:label** works as the default label for all the application components.
    * **android:theme** represents a common theme for all the android activities.


* **&lt;activity&gt;** is the subelement of application and represents an activity that must be defined in the 
AndroidManifest.xml file. It has many attributes such as label, name, theme, launchMode etc.
    * **android:label** represents a label i.e. displayed on the screen.
    * **android:name** represents a name for the activity class. It is required attribute.


* **&lt;intent-filter&gt;** is the sub-element of activity that describes the type of intent to which activity, 
service or broadcast receiver can respond to.


* **&lt;action&gt;** It adds an action for the intent-filter. The intent-filter must have at least one action element.


* **&lt;category&gt;** It adds a category name to an intent-filter.

### Source
* https://www.javatpoint.com/AndroidManifest-xml-file-in-android
* https://getstream.io/blog/android-developer-roadmap/