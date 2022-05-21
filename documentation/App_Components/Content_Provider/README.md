# Content Providers
![img.png](../res/content_provider_diagram.jpg)

A content provider manages a **shared set of app data that you can store in the file system**, in a 
SQLite database, on the web, or on any other persistent storage location that your app can access. 
Through the content provider, **other apps can query or modify the data if the content provider allows 
it**. For example, the Android system provides a content provider that manages the user's contact 
information. As such, any app with the proper permissions can query the content provider, such as 
`ContactsContract.Data`, to read and write information about a particular person. It is tempting to 
think of a content provider as an abstraction on a database, because there is a lot of API and 
support built in to them for that common case.

Content providers let you **centralize content in one place** and have many different applications 
access it as needed. A content provider behaves very much like **a database where you can query it**, 
edit its content, as well as add or delete content using `insert()`, `update()`, `delete()`, and `query()` 
methods. In most cases this data is stored in an **SQlite** database.

## Content URIs
To query a content provider, you specify the query string in the form of a 
URI which has following format −

```xml
<prefix>://<authority>/<data_type>/<id>
```

Here is the detail of various parts of the URI −

|No.  |  Part           | Description                                                              | 
|:---:|:---------------:|:------------------------------------------------------------------------:|
|  1  |     `prefix`      | This is always set to content://                                         |
|  2  |    `authority`    | This specifies the name of the content provider, for example contacts, browser etc. For third-party content providers, this could be the fully qualified name, such as `com.tutorialspoint.statusprovider`   |
|  3  |    `data_type`    | This indicates the type of data that this particular provider provides. For example, if you are getting all the contacts from the Contacts content provider, then the data path would be people and URI would look like `thiscontent://contacts/people` |
|  4  |      `id`         | This specifies the specific record requested. For example, if you are looking for contact number 5 in the Contacts content provider then URI would look like this `content://contacts/people/5`. |

### Source
* https://developer.android.com/guide/components/fundamentals
* https://www.tutorialspoint.com/android/android_content_providers.htm