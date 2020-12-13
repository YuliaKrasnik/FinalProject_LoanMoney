package com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.presentation

import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBaseView

interface IStartWindowView : IBaseView {
    fun navigateToAuthenticationFragment()

    fun navigateToRegistrationFragment()
}

