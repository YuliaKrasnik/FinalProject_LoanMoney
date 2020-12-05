package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.scope.TokenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.dataSource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.repository.LoginRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [AuthenticationSourcesModule::class])
class AuthenticationRepositoriesModule {
    @Provides
    @TokenScope
    fun provideLoginRepository(loginDataSource: LoginDataSourceImpl): LoginRepositoryImpl =
            LoginRepositoryImpl(loginDataSource)
}