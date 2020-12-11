package com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository

interface ITokenRepository {
    fun saveBearerToken(token: String)
    fun checkingBearerTokenAvailability(): Boolean
    fun deleteToken()
}