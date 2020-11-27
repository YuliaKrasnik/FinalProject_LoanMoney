package com.focusstart.android.finalproject.loanmoneyonline.presentation.startWindow

import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser.IRegistrationView

interface IStartWindowPresenter {
    fun attachView(view: IStartWindowView)

    fun detachView()

    fun onRegistrationButtonClicked()

    fun onAuthenticationButtonClicked()
}