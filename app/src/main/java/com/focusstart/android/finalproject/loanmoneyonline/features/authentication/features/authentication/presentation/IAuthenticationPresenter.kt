package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.authentication.presentation

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common.IBasePresenter

interface IAuthenticationPresenter : IBasePresenter {
    fun clear()

    fun onAuthenticationButtonClicked(username: String, password: String)

    fun onResume(arguments: Bundle?)
}