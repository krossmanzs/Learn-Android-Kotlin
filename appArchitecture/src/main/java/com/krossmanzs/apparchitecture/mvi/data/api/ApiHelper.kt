package com.krossmanzs.apparchitecture.mvi.data.api

import com.krossmanzs.apparchitecture.mvi.data.model.User

interface ApiHelper {
    // we use suspend keyword to support Coroutines so that we can call it
    // from a Coroutine or another suspend function.
    suspend fun getUsers(): List<User>
}