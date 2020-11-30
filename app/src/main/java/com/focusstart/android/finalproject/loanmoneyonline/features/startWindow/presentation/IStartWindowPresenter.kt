package com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.presentation

import com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common.IBasePresenter

interface IStartWindowPresenter : IBasePresenter {
    fun onRegistrationButtonClicked()

    fun onAuthenticationButtonClicked()
}