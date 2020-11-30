package com.focusstart.android.finalproject.loanmoneyonline.di.presenters.module

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.dataSource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.datasource.TokenDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.provider.TokenProviderImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.network.api.IAuthApi
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.scope.PresentersScope
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.network.api.ILoanApi
import dagger.Module
import dagger.Provides

@Module
class SourcesModule {
    @Provides
    @PresentersScope
    fun provideLoginSource(apiService: IAuthApi): LoginDataSourceImpl =
            LoginDataSourceImpl(apiService)

    @Provides
    @PresentersScope
    fun provideLoanSource(apiService: ILoanApi): LoanDataSourceImpl =
            LoanDataSourceImpl(apiService)

    @Provides
    @PresentersScope
    fun provideSettingsSource(tokenProvider: TokenProviderImpl): TokenDataSourceImpl =
            TokenDataSourceImpl(tokenProvider)

}