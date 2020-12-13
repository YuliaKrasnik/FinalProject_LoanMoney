package com.focusstart.android.finalproject.loanmoneyonline.core.di.app.module

import com.focusstart.android.finalproject.loanmoneyonline.core.di.app.scope.ApplicationScope
import com.focusstart.android.finalproject.loanmoneyonline.core.data.datasource.TokenDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.core.data.provider.TokenProviderImpl
import com.focusstart.android.finalproject.loanmoneyonline.core.data.repository.TokenRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class TokenModule {
    @Provides
    @ApplicationScope
    fun provideTokenRepository(tokenDataSourceImpl: TokenDataSourceImpl): TokenRepositoryImpl =
            TokenRepositoryImpl(tokenDataSourceImpl)

    @Provides
    @ApplicationScope
    fun provideTokenSource(tokenProvider: TokenProviderImpl): TokenDataSourceImpl =
            TokenDataSourceImpl(tokenProvider)
}