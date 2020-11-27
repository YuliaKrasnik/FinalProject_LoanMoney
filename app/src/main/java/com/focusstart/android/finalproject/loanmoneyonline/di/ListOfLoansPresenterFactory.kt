package com.focusstart.android.finalproject.loanmoneyonline.di

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SharedPreferenceSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.GetListOfLoansUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans.IListOfLoansPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans.ListOfLoansPresenterImpl

object ListOfLoansPresenterFactory {
    fun create(preferences: SharedPreferences): IListOfLoansPresenter {
        val loanDataSource = LoanDataSourceImpl()
        val sharedPreferenceSource = SharedPreferenceSourceImpl(preferences)

        val loanRepository = LoanRepositoryImpl(loanDataSource, sharedPreferenceSource)
        val getListOfLoansUseCase = GetListOfLoansUseCase(loanRepository)

        return ListOfLoansPresenterImpl(getListOfLoansUseCase)
    }
}