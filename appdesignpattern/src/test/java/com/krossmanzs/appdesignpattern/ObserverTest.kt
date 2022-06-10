package com.krossmanzs.appdesignpattern

import com.krossmanzs.appdesignpattern.observer.Editor
import com.krossmanzs.appdesignpattern.observer.EmailNotificationListener
import com.krossmanzs.appdesignpattern.observer.EventType
import com.krossmanzs.appdesignpattern.observer.LogOpenListener
import org.junit.Test

class ObserverTest {
    @Test
    fun testObserver() {
        val editor = Editor()

        val logOpenListener = LogOpenListener("path/to/log/file.txt")
        val emailNotificationListener = EmailNotificationListener("path/to/log/file.txt")

        editor.events.subscribe(EventType.OPEN, logOpenListener)
        editor.events.subscribe(EventType.OPEN, emailNotificationListener)
        editor.events.subscribe(EventType.SAVE, logOpenListener)
        editor.events.subscribe(EventType.SAVE, emailNotificationListener)


        editor.checkListener(EventType.OPEN)
        editor.checkListener(EventType.SAVE)

        println()
        editor.openFile("test.txt")
        editor.saveFile()
    }
}