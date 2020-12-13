package com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBasePresenter

interface ILoanProfilePresenter : IBasePresenter {
    fun onResume(arguments: Bundle?)
}