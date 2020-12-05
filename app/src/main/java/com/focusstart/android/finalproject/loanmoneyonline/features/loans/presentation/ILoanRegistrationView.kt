package com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation

import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBaseView

interface ILoanRegistrationView : IBaseView {
    fun navigateToExplanationAfterRegisterLoanFragment()

    fun showToast(message: String)

    fun showImmutableConditions(percent: Double, period: Int)

    fun setMaxInSeekBar(maxValue: Int)

    fun setProgressInSeekBar(progress: Int)
}