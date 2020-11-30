package com.focusstart.android.finalproject.loanmoneyonline.domain.repository

interface ITokenRepository {
    fun saveBearerToken(token: String)
    fun checkingBearerTokenAvailability(): Boolean
}