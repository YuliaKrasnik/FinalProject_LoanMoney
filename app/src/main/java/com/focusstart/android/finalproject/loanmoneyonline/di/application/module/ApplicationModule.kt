package com.focusstart.android.finalproject.loanmoneyonline.di.application.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.di.application.scope.ApplicationScope
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.APP_PREFERENCES
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.provider.TokenProviderImpl
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val app: Application) {
    @Provides
    @ApplicationScope
    fun applicationContext(): Application = app

    @Provides
    @ApplicationScope
    fun sharedPreferences(): SharedPreferences =
        app.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

    @Provides
    @ApplicationScope
    fun tokenProvider(sharedPreferences: SharedPreferences): TokenProviderImpl = TokenProviderImpl(sharedPreferences)
}