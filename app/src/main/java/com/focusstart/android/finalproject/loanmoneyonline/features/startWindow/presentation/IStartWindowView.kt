package com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.presentation

import com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common.IBaseView

interface IStartWindowView : IBaseView {
    fun navigateToAuthenticationFragment()

    fun navigateToRegistrationFragment()
}

