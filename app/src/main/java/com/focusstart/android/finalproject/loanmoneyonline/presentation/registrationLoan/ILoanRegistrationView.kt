package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan

interface ILoanRegistrationView {
    fun navigateToExplanationAfterRegisterLoanFragment()
    fun showToast(message: String)
    fun showImmutableConditions(percent: Double, period: Int)
    fun setMaxInSeekBar(maxValue: Int)
}