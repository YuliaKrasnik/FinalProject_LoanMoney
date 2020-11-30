package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.registration.presentation

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common.IBaseView

interface IRegistrationView : IBaseView {

    fun showToast(message: String)

    fun showUserNameError(message: String)

    fun navigateToAuthenticationFragment(bundle: Bundle)
}