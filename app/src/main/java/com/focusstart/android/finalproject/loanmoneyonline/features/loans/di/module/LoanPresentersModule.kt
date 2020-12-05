package com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.scope.LoansScope
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetConditionsLoanUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetListOfLoansUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.LoanRegistrationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation.*
import dagger.Module
import dagger.Provides

@Module(includes = [LoanUseCasesModule::class])
class LoanPresentersModule{

    @Provides
    @LoansScope
    fun provideListOfLoansPresenter(
            getListOfLoansUseCase: GetListOfLoansUseCase
    ): IListOfLoansPresenter = ListOfLoansPresenterImpl(
            getListOfLoansUseCase
    )

    @Provides
    @LoansScope
    fun provideLoanProfilePresenter(): ILoanProfilePresenter = LoanProfilePresenterImpl()

    @Provides
    @LoansScope
    fun provideLoanRegistrationPresenter(
            loanRegistrationUseCase: LoanRegistrationUseCase,
            getConditionsLoanUseCase: GetConditionsLoanUseCase
    ): ILoanRegistrationPresenter = LoanRegistrationPresenterImpl(
            loanRegistrationUseCase,
            getConditionsLoanUseCase
    )



}