package com.focusstart.android.finalproject.loanmoneyonline.presentation.startWindow

import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBaseView

interface IStartWindowView : IBaseView {
    fun navigateToAuthenticationFragment()

    fun navigateToRegistrationFragment()
}

