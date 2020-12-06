package com.focusstart.android.finalproject.loanmoneyonline.core.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.core.data.provider.SettingsProviderImpl
import com.focusstart.android.finalproject.loanmoneyonline.core.di.scope.ApplicationScope
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.provider.TokenProviderImpl
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.APP_PREFERENCES
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

    @Provides
    @ApplicationScope
    fun settingsProvider(sharedPreferences: SharedPreferences): SettingsProviderImpl = SettingsProviderImpl(sharedPreferences)

}