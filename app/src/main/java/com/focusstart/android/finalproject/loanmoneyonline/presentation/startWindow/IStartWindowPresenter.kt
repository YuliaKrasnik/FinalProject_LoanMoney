package com.focusstart.android.finalproject.loanmoneyonline.presentation.startWindow

import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBasePresenter

interface IStartWindowPresenter : IBasePresenter {
    fun onRegistrationButtonClicked()

    fun onAuthenticationButtonClicked()
}