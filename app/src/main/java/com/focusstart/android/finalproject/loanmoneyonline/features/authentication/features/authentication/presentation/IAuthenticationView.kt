package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.authentication.presentation

import com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common.IBaseView

interface IAuthenticationView : IBaseView {
    fun navigateToListOfLoansFragment()

    fun navigateToExplanationAfterRegistrationFragment()

    fun showPassedValues(username: String, password: String)

    fun showToast(message: String)
}