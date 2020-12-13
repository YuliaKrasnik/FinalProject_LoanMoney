package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation

import android.content.res.Resources
import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBaseView

interface IAuthenticationView : IBaseView {
    fun navigateToListOfLoansFragment()

    fun navigateToExplanationAfterRegistrationFragment()

    fun showPassedValues(username: String, password: String)

    fun showToast(message: String)

    fun returnResources(): Resources
}