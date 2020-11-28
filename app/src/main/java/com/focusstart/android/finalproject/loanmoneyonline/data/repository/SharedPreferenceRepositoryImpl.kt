package com.focusstart.android.finalproject.loanmoneyonline.data.repository

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SharedPreferenceSource
import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ISharedPreferenceRepository

class SharedPreferenceRepositoryImpl(private val sharedPreferenceSource: SharedPreferenceSource) : ISharedPreferenceRepository {

    override fun saveBearerToken(token: String) {
        sharedPreferenceSource.saveBearerToken(token)
    }

    override fun checkingBearerTokenAvailability(): Boolean {
        return sharedPreferenceSource.isTokenExists()
    }
}