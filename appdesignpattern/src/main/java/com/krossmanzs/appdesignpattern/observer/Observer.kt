package com.krossmanzs.appdesignpattern.observer

import java.io.File

enum class EventType {
    SAVE,
    OPEN
}

// Learn it from here
// https://youtu.be/5WIS-GydJmw

interface EventListener {
    fun update(eventType: EventType, file: File?)
}

class EventManager(vararg operations: EventType) {
    val listeners = hashMapOf<EventType, ArrayList<EventListener>>()

    init {
        // create empty list for each operations
        for (operation in operations) {
            listeners[operation] = ArrayList<EventListener>()
        }
    }

    fun subscribe(eventType: EventType, listener: EventListener) {
        val users = listeners[eventType]
        users?.add(listener)
    }

    fun unsubscribe(eventType: EventType, listener: EventListener) {
        val users = listeners[eventType]
        users?.remove(listener)
    }

    fun notify(eventType: EventType, file: File?) {
        val users = listeners[eventType]
        users?.let {
            for (listener in it) {
                listener.update(eventType, file)
            }
        }
    }
}

class Editor {
    var events: EventManager = EventManager(EventType.OPEN, EventType.SAVE)
    private var file: File? = null

    fun openFile(filePath: String) {
        file = File(filePath)
        events.notify(EventType.OPEN, file)
    }

    fun saveFile() {
        file?.let {
            events.notify(EventType.SAVE, file)
        }
    }

    fun checkListener(operation: EventType) {
        println("Check listener - $operation")

        events.listeners[operation].let {
            if (it != null) {
                for (listener in it) {
                    println(it)
                }
            }
        }

    }
}

class EmailNotificationListener(private val email: String): EventListener {
    override fun update(eventType: EventType, file: File?) {
        println("Email to $email: Someone has performed $eventType operation with the file ${file?.name}")
    }
}

class LogOpenListener(var filename: String): EventListener {
    override fun update(eventType: EventType, file: File?) {
        println("Save to log $filename: Someone has performed $eventType operation with the file ${file?.name}")
    }
}

