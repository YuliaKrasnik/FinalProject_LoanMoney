package com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication

import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBaseView

interface IAuthenticationView : IBaseView {
    fun navigateToListOfLoansFragment()

    fun navigateToExplanationAfterRegistrationFragment()

    fun showPassedValues(username: String, password: String)

    fun showToast(message: String)
}