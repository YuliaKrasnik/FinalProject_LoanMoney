package com.focusstart.android.finalproject.loanmoneyonline.di

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SettingsSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.SettingsRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.CheckingBearerTokenAvailabilityUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.splashScreen.ISplashScreenPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.splashScreen.SplashScreenPresenterImpl

object SplashScreenPresenterFactory {
    fun create(preferences: SharedPreferences): ISplashScreenPresenter {
        val settingsSource = SettingsSourceImpl(preferences)
        val settingsRepository = SettingsRepositoryImpl(settingsSource)
        val checkingBearerTokenAvailabilityUseCase =
            CheckingBearerTokenAvailabilityUseCase(settingsRepository)

        return SplashScreenPresenterImpl(checkingBearerTokenAvailabilityUseCase)
    }
}