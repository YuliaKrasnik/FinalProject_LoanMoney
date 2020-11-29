package com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication

import android.os.Bundle

interface IAuthenticationPresenter {
    fun attachView(view: IAuthenticationView)

    fun detachView()

    fun clear()

    fun onAuthenticationButtonClicked(username: String, password: String)

    fun onResume(arguments: Bundle?)
}