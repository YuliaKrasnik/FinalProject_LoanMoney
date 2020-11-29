package com.focusstart.android.finalproject.loanmoneyonline.di

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SettingsSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.SettingsRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.SaveBearerTokenUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication.AuthenticationPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication.IAuthenticationPresenter

object AuthenticationPresenterFactory {
    fun create(preferences: SharedPreferences): IAuthenticationPresenter {
        val loginDataSource = LoginDataSourceImpl()
        val loginRepository = LoginRepositoryImpl(loginDataSource)

        val settingsSource = SettingsSourceImpl(preferences)
        val settingsRepository = SettingsRepositoryImpl(settingsSource)

        val authenticationInAppUseCase = AuthenticationUseCase(loginRepository)
        val saveBearerTokenInPreferencesUseCase = SaveBearerTokenUseCase(settingsRepository)

        return AuthenticationPresenterImpl(authenticationInAppUseCase, saveBearerTokenInPreferencesUseCase)
    }
}