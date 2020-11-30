package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan

import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBaseView

interface ILoanRegistrationView : IBaseView {
    fun navigateToExplanationAfterRegisterLoanFragment()

    fun showToast(message: String)

    fun showImmutableConditions(percent: Double, period: Int)

    fun setMaxInSeekBar(maxValue: Int)
}