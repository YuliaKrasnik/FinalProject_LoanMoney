package com.focusstart.android.finalproject.loanmoneyonline.di

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.RegistrationInAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.IRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.RegistrationPresenterImpl

object RegistrationPresenterFactory {
    fun create(): IRegistrationPresenter {
        val loginDataSource = LoginDataSourceImpl()
        val loginRepository = LoginRepositoryImpl(loginDataSource)
        val registrationInAppUseCase = RegistrationInAppUseCase(loginRepository)

        return RegistrationPresenterImpl(registrationInAppUseCase)
    }
}