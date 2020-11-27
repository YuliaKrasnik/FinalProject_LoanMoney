package com.focusstart.android.finalproject.loanmoneyonline.presentation.loanProfile

import android.os.Bundle

interface ILoanProfilePresenter {
    fun onResume(arguments: Bundle?)

    fun attachView(view: ILoanProfileView)

    fun detachView()

}