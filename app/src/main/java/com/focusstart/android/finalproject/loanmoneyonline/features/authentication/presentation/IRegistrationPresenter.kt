package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation

import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBasePresenter

interface IRegistrationPresenter : IBasePresenter {
    fun clear()

    fun onRegistrationButtonClicked(username: String, password: String)
}