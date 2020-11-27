package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser

interface IRegistrationPresenter {
    fun attachView(view: IRegistrationView)

    fun detachView()

    fun clear()

    fun onRegistrationButtonClicked(username: String, password: String)
}