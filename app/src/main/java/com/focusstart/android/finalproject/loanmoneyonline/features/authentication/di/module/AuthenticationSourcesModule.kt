package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.scope.TokenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.dataSource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.network.api.IAuthApi
import dagger.Module
import dagger.Provides

@Module(includes = [AuthenticationApiModule::class])
class AuthenticationSourcesModule {
    @Provides
    @TokenScope
    fun provideLoginSource(apiService: IAuthApi): LoginDataSourceImpl =
            LoginDataSourceImpl(apiService)
}