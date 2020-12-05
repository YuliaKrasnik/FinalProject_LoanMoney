package com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.network.api.ILoanApi
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.scope.LoansScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class LoanApiModule {
    @Provides
    @LoansScope
    fun provideLoanApiClass(retrofit: Retrofit): ILoanApi = retrofit.create(ILoanApi::class.java)
}