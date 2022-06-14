package com.krossmanzs.apparchitecture.mvi.data.api

import com.krossmanzs.apparchitecture.mvi.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}