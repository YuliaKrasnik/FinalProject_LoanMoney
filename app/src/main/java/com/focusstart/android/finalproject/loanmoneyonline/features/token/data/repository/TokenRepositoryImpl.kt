package com.focusstart.android.finalproject.loanmoneyonline.features.token.data.repository

import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.datasource.ITokenDataSource
import com.focusstart.android.finalproject.loanmoneyonline.features.token.domain.repository.ITokenRepository

class TokenRepositoryImpl(private val tokenDataSource: ITokenDataSource) : ITokenRepository {

    override fun saveBearerToken(token: String) {
        tokenDataSource.saveBearerToken(token)
    }

    override fun checkingBearerTokenAvailability(): Boolean {
        return tokenDataSource.isTokenExists()
    }
}