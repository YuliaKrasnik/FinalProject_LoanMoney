package com.focusstart.android.finalproject.loanmoneyonline.presentation

interface IRegistrationPresenter {
    fun attachView(view: IRegistrationView)

    fun detachView()

    fun clear()

    fun onRegistrationButtonClicked(username: String, password: String)
}