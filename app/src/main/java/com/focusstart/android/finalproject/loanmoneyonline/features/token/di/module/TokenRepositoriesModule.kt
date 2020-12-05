package com.focusstart.android.finalproject.loanmoneyonline.features.token.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.scope.TokenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.datasource.TokenDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.repository.TokenRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [TokenSourcesModule::class])
class TokenRepositoriesModule {
    @Provides
    @TokenScope
    fun provideTokenRepository(tokenDataSourceImpl: TokenDataSourceImpl): TokenRepositoryImpl =
            TokenRepositoryImpl(tokenDataSourceImpl)
}