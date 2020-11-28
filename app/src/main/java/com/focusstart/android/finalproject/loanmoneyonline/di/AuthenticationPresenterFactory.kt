package com.focusstart.android.finalproject.loanmoneyonline.di

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SharedPreferenceSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.SharedPreferenceRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.SaveBearerTokenInPreferencesUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication.AuthenticationPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication.IAuthenticationPresenter

object AuthenticationPresenterFactory {
    fun create(preferences: SharedPreferences): IAuthenticationPresenter {
        val loginDataSource = LoginDataSourceImpl()
        val loginRepository = LoginRepositoryImpl(loginDataSource)

        val sharedPreferenceSource = SharedPreferenceSourceImpl(preferences)
        val sharedPreferenceRepository = SharedPreferenceRepositoryImpl(sharedPreferenceSource)

        val authenticationInAppUseCase = AuthenticationUseCase(loginRepository)
        val saveBearerTokenInPreferencesUseCase = SaveBearerTokenInPreferencesUseCase(sharedPreferenceRepository)

        return AuthenticationPresenterImpl(authenticationInAppUseCase, saveBearerTokenInPreferencesUseCase)
    }
}