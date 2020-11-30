package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.registration.presentation

import com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common.IBasePresenter

interface IRegistrationPresenter : IBasePresenter {
    fun clear()

    fun onRegistrationButtonClicked(username: String, password: String)
}