package com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.scope.LoansScope
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.*
import dagger.Module
import dagger.Provides

@Module
class LoanUseCasesModule {
    @Provides
    @LoansScope
    fun provideLoanRegistrationUseCase(
            loanRepositoryImpl: LoanRepositoryImpl
    ): LoanRegistrationUseCase = LoanRegistrationUseCase(
            loanRepositoryImpl
    )

    @Provides
    @LoansScope
    fun provideGetConditionsLoanUseCase(loanRepositoryImpl: LoanRepositoryImpl): GetConditionsLoanUseCase =
            GetConditionsLoanUseCase(loanRepositoryImpl)

    @Provides
    @LoansScope
    fun provideGetListOfLoansFromDbUseCase(loanRepositoryImpl: LoanRepositoryImpl): GetListOfLoansFromDbUseCase =
            GetListOfLoansFromDbUseCase(loanRepositoryImpl)

    @Provides
    @LoansScope
    fun provideSaveListOfLoansToDbUseCase(loanRepositoryImpl: LoanRepositoryImpl): SaveListOfLoansToDbUseCase =
            SaveListOfLoansToDbUseCase(loanRepositoryImpl)

    @Provides
    @LoansScope
    fun provideSaveLoanToDbUseCase(loanRepositoryImpl: LoanRepositoryImpl): SaveLoanToDbUseCase =
            SaveLoanToDbUseCase(loanRepositoryImpl)

}