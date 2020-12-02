package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.presentation

import android.content.res.Resources
import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common.IBasePresenter

interface IListOfLoansPresenter : IBasePresenter {
    fun onResume()

    fun clear()

    fun onCreateNewLoanButtonClicked()

    fun getNavigationBundle(loan: Loan, resources: Resources): Bundle

    fun determineColorState(state: String, resources: Resources): Int

    fun transformNameState(state: String, resources: Resources): String

    fun transformDate(date: String, resources: Resources): String
}