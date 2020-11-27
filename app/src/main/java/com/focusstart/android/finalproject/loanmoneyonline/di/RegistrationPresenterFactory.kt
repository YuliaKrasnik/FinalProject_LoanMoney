package com.focusstart.android.finalproject.loanmoneyonline.di

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SharedPreferenceSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.SharedPreferenceRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.domain.RegistrationInAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.domain.SaveBearerTokenInPreferencesUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser.IRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser.RegistrationPresenterImpl

object RegistrationPresenterFactory {
    fun create(preferences: SharedPreferences): IRegistrationPresenter {
        val loginDataSource = LoginDataSourceImpl()
        val loginRepository = LoginRepositoryImpl(loginDataSource)

        val sharedPreferenceSource = SharedPreferenceSourceImpl(preferences)
        val sharedPreferenceRepository = SharedPreferenceRepositoryImpl(sharedPreferenceSource)

        val registrationInAppUseCase = RegistrationInAppUseCase(loginRepository)
        val authenticationUseCase = AuthenticationUseCase(loginRepository)
        val saveBearerTokenInPreferencesUseCase = SaveBearerTokenInPreferencesUseCase(sharedPreferenceRepository)

        return RegistrationPresenterImpl(registrationInAppUseCase, authenticationUseCase, saveBearerTokenInPreferencesUseCase)
    }
}