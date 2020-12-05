package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBasePresenter

interface IAuthenticationPresenter : IBasePresenter {
    fun clear()

    fun onAuthenticationButtonClicked(username: String, password: String)

    fun onResume(arguments: Bundle?)
}