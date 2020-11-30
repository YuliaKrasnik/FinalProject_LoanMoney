package com.focusstart.android.finalproject.loanmoneyonline.data.repository

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.ITokenDataSource
import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ITokenRepository

class TokenRepositoryImpl(private val tokenDataSource: ITokenDataSource) : ITokenRepository {

    override fun saveBearerToken(token: String) {
        tokenDataSource.saveBearerToken(token)
    }

    override fun checkingBearerTokenAvailability(): Boolean {
        return tokenDataSource.isTokenExists()
    }
}