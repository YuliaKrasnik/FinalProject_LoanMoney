package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan

import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBasePresenter

interface ILoanRegistrationPresenter : IBasePresenter {
    fun attachView(view: ILoanRegistrationView)

    fun detachView()

    fun clear()

    fun onResume()

    fun onRegistrationLoanButtonClicked(firstName: String, secondName: String, phoneNumber: String, amount: String, period: String, percent: String)

    fun getTransformedProgressValueInSeekBar(progress: Int): Int
}