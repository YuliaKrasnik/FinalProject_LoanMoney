package com.focusstart.android.finalproject.loanmoneyonline.presentation.startWindow

interface IStartWindowPresenter {
    fun attachView(view: IStartWindowView)

    fun detachView()

    fun onRegistrationButtonClicked()

    fun onAuthenticationButtonClicked()
}