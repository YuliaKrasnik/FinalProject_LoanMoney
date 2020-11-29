package com.focusstart.android.finalproject.loanmoneyonline.di

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SettingsSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.GetListOfLoansUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans.IListOfLoansPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans.ListOfLoansPresenterImpl

object ListOfLoansPresenterFactory {
    fun create(preferences: SharedPreferences): IListOfLoansPresenter {
        val loanDataSource = LoanDataSourceImpl()
        val settingsSource = SettingsSourceImpl(preferences)

        val loanRepository = LoanRepositoryImpl(loanDataSource, settingsSource)
        val getListOfLoansUseCase = GetListOfLoansUseCase(loanRepository)

        return ListOfLoansPresenterImpl(getListOfLoansUseCase)
    }
}