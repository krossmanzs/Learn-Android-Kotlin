package com.krossmanzs.apparchitecture.mvi.data.repository

import com.krossmanzs.apparchitecture.mvi.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}