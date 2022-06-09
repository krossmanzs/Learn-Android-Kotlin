package com.krossmanzs.appdesignpattern.builder

import android.content.Context
import android.widget.Toast

class PopUp private constructor(builder: Builder) {
    // set up default value parameters
    private var message = "Default Message"
    private var length = Toast.LENGTH_SHORT
    private var context: Context? = null

    class Builder(private val context: Context) {
        private var message: String? = null
        private var length = 0

        fun setMessage(message: String) = apply { this.message = message }
        fun setLength(length: Int) = apply { this.length = length }
        fun build() = PopUp(this)

        fun getMessage() = message
        fun getLength() = length
        fun getContext() = context
    }

    init {
        if (builder.getMessage() != null) {
            message = builder.getMessage() as String
        }

        if (builder.getLength() != 0) {
            length = builder.getLength()
        }

        context = builder.getContext()
    }

    fun show() {
        Toast.makeText(context, message, length).show()
    }
}