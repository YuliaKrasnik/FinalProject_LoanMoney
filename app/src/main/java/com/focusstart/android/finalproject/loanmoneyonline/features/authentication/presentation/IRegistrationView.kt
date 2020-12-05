package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBaseView

interface IRegistrationView : IBaseView {

    fun showToast(message: String)

    fun showUserNameError(message: String)

    fun navigateToAuthenticationFragment(bundle: Bundle)
}