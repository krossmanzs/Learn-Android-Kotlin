package com.krossmanzs.apparchitecture.mvi.ui.main.intent

sealed class MainIntent {
    object FetchUser : MainIntent()
}