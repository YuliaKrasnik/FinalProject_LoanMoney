package com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.presentation

import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBaseView

interface ISplashScreenView : IBaseView {
    fun navigateToStartFragment()

    fun navigateToListOfLoansFragment()
}