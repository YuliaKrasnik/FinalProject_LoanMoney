package com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.db.LoansDao
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.network.api.ILoanApi
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.scope.LoansScope
import dagger.Module
import dagger.Provides

@Module(includes = [LoanApiModule::class])
class LoanSourcesModule {
    @Provides
    @LoansScope
    fun provideLoanSource(apiService: ILoanApi, dao: LoansDao): LoanDataSourceImpl =
            LoanDataSourceImpl(apiService, dao)
}