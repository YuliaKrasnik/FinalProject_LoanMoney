package com.focusstart.android.finalproject.loanmoneyonline.domain.repository

interface ISettingsRepository {
    fun saveBearerToken(token:String)
    fun checkingBearerTokenAvailability(): Boolean
}