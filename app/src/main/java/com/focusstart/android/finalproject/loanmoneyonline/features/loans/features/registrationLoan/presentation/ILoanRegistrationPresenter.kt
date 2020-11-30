package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.registrationLoan.presentation

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common.IBasePresenter

interface ILoanRegistrationPresenter : IBasePresenter {
    fun clear()

    fun onResume()

    fun onRegistrationLoanButtonClicked(
        firstName: String,
        secondName: String,
        phoneNumber: String,
        amount: String,
        period: String,
        percent: String
    )

    fun getTransformedProgressValueInSeekBar(progress: Int): Int

    fun onSaveInstanceState(outState: Bundle)

    fun onRestoreInstanceState(savedInstanceState: Bundle)
}