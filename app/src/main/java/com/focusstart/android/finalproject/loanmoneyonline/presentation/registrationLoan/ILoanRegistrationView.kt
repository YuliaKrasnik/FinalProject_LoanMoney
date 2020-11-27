package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan

interface ILoanRegistrationView {
    fun navigateToExplanationAfterRegisterLoanFragment()
    fun showToast(message: String)
    fun showConditions(percent: Double, period: Int, maxAmount: Int)
}