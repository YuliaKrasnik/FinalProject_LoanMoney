package com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBasePresenter

interface IAuthenticationPresenter : IBasePresenter {
    fun clear()

    fun onAuthenticationButtonClicked(username: String, password: String)

    fun onResume(arguments: Bundle?)
}