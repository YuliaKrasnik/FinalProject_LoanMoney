package com.focusstart.android.finalproject.loanmoneyonline.di

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.LoanRegistrationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan.ILoanRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan.LoanRegistrationPresenterImpl

object LoanRegistrationPresenterFactory {
    fun create(): ILoanRegistrationPresenter {
        val loanDataSource = LoanDataSourceImpl()
        val loanRepository = LoanRepositoryImpl(loanDataSource)
        val loanRegistrationUseCase = LoanRegistrationUseCase(loanRepository)

        return LoanRegistrationPresenterImpl(loanRegistrationUseCase)
    }
}