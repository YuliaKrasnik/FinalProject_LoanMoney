package com.focusstart.android.finalproject.loanmoneyonline.features.token.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.scope.TokenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.datasource.TokenDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.provider.TokenProviderImpl
import dagger.Module
import dagger.Provides

@Module
class TokenSourcesModule {
    @Provides
    @TokenScope
    fun provideTokenSource(tokenProvider: TokenProviderImpl): TokenDataSourceImpl =
            TokenDataSourceImpl(tokenProvider)
}