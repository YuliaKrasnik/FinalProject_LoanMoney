package com.focusstart.android.finalproject.loanmoneyonline.di

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.GetListOfLoansUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans.IListOfLoansPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans.ListOfLoansPresenterImpl

object ListOfLoansPresenterFactory {
    fun create(): IListOfLoansPresenter {
        val loanDataSource = LoanDataSourceImpl()
        val loanRepository = LoanRepositoryImpl(loanDataSource)
        val getListOfLoansUseCase = GetListOfLoansUseCase(loanRepository)

        return ListOfLoansPresenterImpl(getListOfLoansUseCase)
    }
}