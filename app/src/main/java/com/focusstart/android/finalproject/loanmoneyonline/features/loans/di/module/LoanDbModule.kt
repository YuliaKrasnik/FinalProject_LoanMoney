package com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.db.AppDatabase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.scope.LoansScope
import dagger.Module
import dagger.Provides

@Module
class LoanDbModule {
    @Provides
    @LoansScope
    fun provideLoansDao(appDatabase: AppDatabase) = appDatabase.loansDao()
}