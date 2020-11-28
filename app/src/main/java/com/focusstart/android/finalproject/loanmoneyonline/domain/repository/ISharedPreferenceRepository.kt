package com.focusstart.android.finalproject.loanmoneyonline.domain.repository

interface ISharedPreferenceRepository {
    fun saveBearerToken(token:String)
    fun checkingBearerTokenAvailability(): Boolean
}