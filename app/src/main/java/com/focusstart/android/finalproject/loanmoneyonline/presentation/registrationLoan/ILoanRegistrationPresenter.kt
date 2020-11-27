package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan

interface ILoanRegistrationPresenter {
    fun attachView(view: ILoanRegistrationView)

    fun detachView()

    fun clear()

    fun onResume()

    fun onRegistrationLoanButtonClicked(firstName: String, secondName: String, phoneNumber: String, amount: String, period: String, percent: String)
}