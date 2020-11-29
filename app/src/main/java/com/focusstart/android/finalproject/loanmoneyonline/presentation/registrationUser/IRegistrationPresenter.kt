package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser

import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBasePresenter

interface IRegistrationPresenter : IBasePresenter {
    fun attachView(view: IRegistrationView)

    fun detachView()

    fun clear()

    fun onRegistrationButtonClicked(username: String, password: String)
}