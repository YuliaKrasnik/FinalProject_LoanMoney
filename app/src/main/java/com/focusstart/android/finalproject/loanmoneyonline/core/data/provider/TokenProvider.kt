package com.focusstart.android.finalproject.loanmoneyonline.core.data.provider

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants

interface ITokenProvider {
    fun saveBearerToken(token: String)
    fun getBearerToken(): String?
    fun isTokenExists(): Boolean
    fun deleteToken()
}

class TokenProviderImpl(private val preferences: SharedPreferences) : ITokenProvider {
    override fun saveBearerToken(token: String) {
        val editor = preferences.edit()
        editor.putString(Constants.APP_PREFERENCES_TOKEN, token)
        editor.apply()
    }

    override fun getBearerToken(): String? {
        var token: String? = null
        if (preferences.contains(Constants.APP_PREFERENCES_TOKEN)) {
            token = preferences.getString(Constants.APP_PREFERENCES_TOKEN, null)
        }

        return token
    }

    override fun isTokenExists(): Boolean {
        val token = getBearerToken()
        return  token != "" && token!=null
    }

    override fun deleteToken() {
        val editor = preferences.edit()
        editor.remove(Constants.APP_PREFERENCES_TOKEN)
        editor.apply()
    }

}