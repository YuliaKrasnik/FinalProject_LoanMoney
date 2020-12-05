package com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.scope.LoansScope
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.repository.LoanRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [LoanSourcesModule::class])
class LoanRepositoriesModule {
    @Provides
    @LoansScope
    fun provideLoanRepository(
            loanDataSourceImpl: LoanDataSourceImpl,
    ): LoanRepositoryImpl =
            LoanRepositoryImpl(loanDataSourceImpl)
}