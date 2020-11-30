package com.focusstart.android.finalproject.loanmoneyonline.di.presenters.module

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.dataSource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.datasource.TokenDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.scope.PresentersScope
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.repository.TokenRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [SourcesModule::class])
class RepositoriesModule {
    @Provides
    @PresentersScope
    fun provideLoginRepository(loginDataSource: LoginDataSourceImpl): LoginRepositoryImpl =
        LoginRepositoryImpl(loginDataSource)

    @Provides
    @PresentersScope
    fun provideLoanRepository(
            loanDataSourceImpl: LoanDataSourceImpl,
    ): LoanRepositoryImpl =
        LoanRepositoryImpl(loanDataSourceImpl)

    @Provides
    @PresentersScope
    fun provideSettingsRepository(tokenDataSourceImpl: TokenDataSourceImpl): TokenRepositoryImpl =
        TokenRepositoryImpl(tokenDataSourceImpl)

}