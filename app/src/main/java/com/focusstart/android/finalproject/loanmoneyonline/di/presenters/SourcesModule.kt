package com.focusstart.android.finalproject.loanmoneyonline.di.presenters

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.TokenDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.network.TokenProviderImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.network.api.IAuthApi
import com.focusstart.android.finalproject.loanmoneyonline.data.network.api.ILoanApi
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