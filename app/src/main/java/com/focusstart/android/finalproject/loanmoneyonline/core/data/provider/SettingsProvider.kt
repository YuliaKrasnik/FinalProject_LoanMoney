package com.focusstart.android.finalproject.loanmoneyonline.core.data.provider

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants

interface ISettingsProvider {
    fun setFlagFirstLaunchApp(flag: Boolean)
    fun getFlagFirstLaunchApp(): Boolean
}

class SettingsProviderImpl(private val preferences: SharedPreferences) : ISettingsProvider {
    override fun setFlagFirstLaunchApp(flag: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(Constants.APP_PREFERENCES_FIRST_LAUNCH, flag)
        editor.apply()
    }

    override fun getFlagFirstLaunchApp(): Boolean {
        var flag = false
        if (preferences.contains(Constants.APP_PREFERENCES_FIRST_LAUNCH)) {
            flag = preferences.getBoolean(Constants.APP_PREFERENCES_FIRST_LAUNCH, false)
        }
        return flag
    }

}

