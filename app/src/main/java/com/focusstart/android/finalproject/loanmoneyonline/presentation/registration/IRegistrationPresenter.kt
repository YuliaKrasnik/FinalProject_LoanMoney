package com.focusstart.android.finalproject.loanmoneyonline.presentation.registration

interface IRegistrationPresenter {
    fun attachView(view: IRegistrationView)

    fun detachView()

    fun clear()

    fun onRegistrationButtonClicked(username: String, password: String)
}