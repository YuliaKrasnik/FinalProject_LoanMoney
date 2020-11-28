package com.focusstart.android.finalproject.loanmoneyonline.di

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SharedPreferenceSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.SharedPreferenceRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.CheckingBearerTokenAvailabilityUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.splashScreen.ISplashScreenPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.splashScreen.SplashScreenPresenterImpl

object SplashScreenPresenterFactory {
    fun create(preferences: SharedPreferences): ISplashScreenPresenter {
        val sharedPreferenceSource = SharedPreferenceSourceImpl(preferences)
        val sharedPreferenceRepository = SharedPreferenceRepositoryImpl(sharedPreferenceSource)
        val checkingBearerTokenAvailabilityUseCase =
            CheckingBearerTokenAvailabilityUseCase(sharedPreferenceRepository)

        return SplashScreenPresenterImpl(checkingBearerTokenAvailabilityUseCase)
    }
}