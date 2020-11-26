package com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication

interface IAuthenticationPresenter {
    fun attachView(view: IAuthenticationView)

    fun detachView()

    fun clear()

    fun onAuthenticationButtonClicked(username: String, password: String)
}