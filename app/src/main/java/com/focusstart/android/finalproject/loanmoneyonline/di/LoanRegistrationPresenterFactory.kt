package com.focusstart.android.finalproject.loanmoneyonline.di

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SettingsSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.GetConditionsLoanUseCase
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.LoanRegistrationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan.ILoanRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan.LoanRegistrationPresenterImpl

object LoanRegistrationPresenterFactory {
    fun create(preferences: SharedPreferences): ILoanRegistrationPresenter {
        val loanDataSource = LoanDataSourceImpl()
        val settingsSource = SettingsSourceImpl(preferences)
        val loanRepository = LoanRepositoryImpl(loanDataSource, settingsSource)

        val loanRegistrationUseCase = LoanRegistrationUseCase(loanRepository)
        val getConditionsLoanUseCase = GetConditionsLoanUseCase(loanRepository)

        return LoanRegistrationPresenterImpl(loanRegistrationUseCase, getConditionsLoanUseCase)
    }
}