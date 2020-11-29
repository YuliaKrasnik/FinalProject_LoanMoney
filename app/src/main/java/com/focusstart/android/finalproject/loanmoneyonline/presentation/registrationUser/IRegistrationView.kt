package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBaseView

interface IRegistrationView : IBaseView {

    fun showToast(message: String)

    fun showUserNameError(message: String)

    fun navigateToAuthenticationFragment(bundle: Bundle)
}