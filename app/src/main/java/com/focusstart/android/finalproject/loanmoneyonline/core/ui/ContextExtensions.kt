package com.focusstart.android.finalproject.loanmoneyonline.core.ui

import android.content.Context
import android.content.res.Configuration
import com.focusstart.android.finalproject.loanmoneyonline.core.data.provider.ISettingsProvider
import com.focusstart.android.finalproject.loanmoneyonline.core.data.provider.SettingsProviderImpl
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants
import java.util.*

fun Context.createContextWithChangedLanguage(): Context {
    val settingsProvider: ISettingsProvider = SettingsProviderImpl((this.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE)))
    val localeString = settingsProvider.getLanguage()
    var locale: Locale = Locale.getDefault()
    if (localeString != null) locale = Locale(localeString)

    val newConfiguration = Configuration(this.resources.configuration)
    Locale.setDefault(locale)
    newConfiguration.setLocale(locale)
    return this.createConfigurationContext(newConfiguration)
}