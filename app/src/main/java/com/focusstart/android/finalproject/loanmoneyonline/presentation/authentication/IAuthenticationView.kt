package com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication

interface IAuthenticationView {
    fun saveBearerToken(token: String)
    fun navigateToListOfLoansFragment()
}