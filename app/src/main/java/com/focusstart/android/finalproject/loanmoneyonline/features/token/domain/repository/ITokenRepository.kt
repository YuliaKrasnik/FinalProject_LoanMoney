package com.focusstart.android.finalproject.loanmoneyonline.features.token.domain.repository

interface ITokenRepository {
    fun saveBearerToken(token: String)
    fun checkingBearerTokenAvailability(): Boolean
}