package com.focusstart.android.finalproject.loanmoneyonline.data.datasource

import com.focusstart.android.finalproject.loanmoneyonline.data.network.TokenProviderImpl

interface ITokenDataSource {
    fun saveBearerToken(token: String)
    fun getBearerToken(): String?
    fun isTokenExists(): Boolean
}

class TokenDataSourceImpl(private val tokenProvider: TokenProviderImpl) : ITokenDataSource {
    override fun saveBearerToken(token: String) = tokenProvider.saveBearerToken(token)

    override fun getBearerToken() = tokenProvider.getBearerToken()

    override fun isTokenExists() = tokenProvider.isTokenExists()
}
