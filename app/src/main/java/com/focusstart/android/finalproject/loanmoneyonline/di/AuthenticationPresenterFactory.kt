package com.focusstart.android.finalproject.loanmoneyonline.di

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication.AuthenticationPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication.IAuthenticationPresenter

object AuthenticationPresenterFactory {
    fun create(): IAuthenticationPresenter {
        val loginDataSource = LoginDataSourceImpl()
        val loginRepository = LoginRepositoryImpl(loginDataSource)
        val authenticationInAppUseCase = AuthenticationUseCase(loginRepository)

        return AuthenticationPresenterImpl(authenticationInAppUseCase)
    }
}