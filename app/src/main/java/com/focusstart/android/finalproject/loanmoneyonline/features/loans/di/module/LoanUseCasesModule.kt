package com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.scope.LoansScope
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetConditionsLoanUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetListOfLoansUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.LoanRegistrationUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [LoanRepositoriesModule::class])
class LoanUseCasesModule {
    @Provides
    @LoansScope
    fun provideGetListOfLoansUseCase(loanRepositoryImpl: LoanRepositoryImpl): GetListOfLoansUseCase =
            GetListOfLoansUseCase(loanRepositoryImpl)

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

}