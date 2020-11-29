package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser

import android.os.Bundle

interface IRegistrationView {

    fun showToast(message: String)

    fun showUserNameError(message: String)

    fun navigateToAuthenticationFragment(bundle: Bundle)
}