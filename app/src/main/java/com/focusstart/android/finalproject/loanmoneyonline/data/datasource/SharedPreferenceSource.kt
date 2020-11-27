package com.focusstart.android.finalproject.loanmoneyonline.data.datasource

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.focusstart.android.finalproject.loanmoneyonline.Constants

interface SharedPreferenceSource {
    fun saveBearerToken(token: String)

    fun getBearerToken(): String
}

class SharedPreferenceSourceImpl(private val preferences: SharedPreferences) : SharedPreferenceSource {
    override fun saveBearerToken(token: String) {
        val editor = preferences.edit()
        editor.putString(Constants.APP_PREFERENCES_TOKEN, token)
        editor.apply()
    }

    override fun getBearerToken(): String {
        var token: String? = null
        if (preferences.contains(Constants.APP_PREFERENCES_TOKEN)) {
            token = preferences.getString(Constants.APP_PREFERENCES_TOKEN, "")
        }

        return token.toString()
    }

}
