package com.krossmanzs.apparchitecture.mvi.data.api

import com.krossmanzs.apparchitecture.mvi.data.model.User

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}