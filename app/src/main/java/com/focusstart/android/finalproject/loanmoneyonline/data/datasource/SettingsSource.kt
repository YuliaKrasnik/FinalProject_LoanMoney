package com.focusstart.android.finalproject.loanmoneyonline.data.datasource

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.Constants

interface ISettingsSource {
    fun saveBearerToken(token: String)
    fun getBearerToken(): String?
    fun isTokenExists(): Boolean
}

class SettingsSourceImpl(private val preferences: SharedPreferences) : ISettingsSource {
    override fun saveBearerToken(token: String) {
        val editor = preferences.edit()
        editor.putString(Constants.APP_PREFERENCES_TOKEN, token)
        editor.apply()
    }

    override fun getBearerToken(): String? {
        var token: String? = null
        if (preferences.contains(Constants.APP_PREFERENCES_TOKEN)) {
            token = preferences.getString(Constants.APP_PREFERENCES_TOKEN, "")
        }

        return token
    }

    override fun isTokenExists(): Boolean {
        val token = getBearerToken()
        return  token != "" && token!=null
    }


}
