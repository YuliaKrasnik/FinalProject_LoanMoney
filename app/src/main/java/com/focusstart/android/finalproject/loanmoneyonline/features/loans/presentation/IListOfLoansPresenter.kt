package com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation

import android.content.res.Resources
import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBasePresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan

interface IListOfLoansPresenter : IBasePresenter {
    fun onResume()

    fun clear()

    fun onCreateNewLoanButtonClicked()

    fun getNavigationBundle(loan: Loan, resources: Resources): Bundle

    fun determineColorState(state: String, resources: Resources): Int

    fun transformNameState(state: String, resources: Resources): String

    fun transformDate(date: String, resources: Resources): String
}