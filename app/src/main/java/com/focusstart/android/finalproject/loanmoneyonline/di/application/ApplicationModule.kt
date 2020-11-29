package com.focusstart.android.finalproject.loanmoneyonline.di.application

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.Constants.APP_PREFERENCES
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: Application) {
    @Provides
    @Singleton
    fun applicationContext(): Application = app

    @Provides
    @Singleton
    fun sharedPreferences(): SharedPreferences =
        app.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
}