package com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.module

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.GetFlagFirstLaunchAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.SetFlagFirstLaunchAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.scope.LoansScope
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.*
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation.*
import dagger.Module
import dagger.Provides

@Module(includes = [LoanUseCasesModule::class])
class LoanPresentersModule {

    @Provides
    @LoansScope
    fun provideListOfLoansPresenter(
            getListOfLoansFromNetworkUseCase: GetListOfLoansFromNetworkUseCase,
            getListOfLoansFromDbUseCase: GetListOfLoansFromDbUseCase,
            saveListOfLoansToDbUseCase: SaveListOfLoansToDbUseCase,
            getFlagFirstLaunchAppUseCase: GetFlagFirstLaunchAppUseCase,
            setFlagFirstLaunchAppUseCase: SetFlagFirstLaunchAppUseCase
    ): IListOfLoansPresenter = ListOfLoansPresenterImpl(
            getListOfLoansFromNetworkUseCase,
            getListOfLoansFromDbUseCase,
            saveListOfLoansToDbUseCase,
            getFlagFirstLaunchAppUseCase,
            setFlagFirstLaunchAppUseCase
    )

    @Provides
    @LoansScope
    fun provideLoanProfilePresenter(): ILoanProfilePresenter = LoanProfilePresenterImpl()

    @Provides
    @LoansScope
    fun provideLoanRegistrationPresenter(
            loanRegistrationUseCase: LoanRegistrationUseCase,
            getConditionsLoanUseCase: GetConditionsLoanUseCase,
            saveLoanToDbUseCase: SaveLoanToDbUseCase
    ): ILoanRegistrationPresenter = LoanRegistrationPresenterImpl(
            loanRegistrationUseCase,
            getConditionsLoanUseCase,
            saveLoanToDbUseCase
    )

}