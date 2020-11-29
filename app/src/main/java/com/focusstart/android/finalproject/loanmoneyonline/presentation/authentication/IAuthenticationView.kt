package com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication

interface IAuthenticationView {
    fun navigateToListOfLoansFragment()

    fun navigateToExplanationAfterRegistrationFragment()

    fun showPassedValues(username: String, password: String)

    fun showToast(message: String)
}