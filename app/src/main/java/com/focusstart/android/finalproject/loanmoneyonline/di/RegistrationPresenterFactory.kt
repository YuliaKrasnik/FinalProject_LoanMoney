package com.focusstart.android.finalproject.loanmoneyonline.di

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.domain.RegistrationInAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser.IRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser.RegistrationPresenterImpl

object RegistrationPresenterFactory {
    fun create(): IRegistrationPresenter {
        val loginDataSource = LoginDataSourceImpl()
        val loginRepository = LoginRepositoryImpl(loginDataSource)
        val registrationInAppUseCase = RegistrationInAppUseCase(loginRepository)
        val authenticationUseCase = AuthenticationUseCase(loginRepository)

        return RegistrationPresenterImpl(registrationInAppUseCase, authenticationUseCase)
    }
}