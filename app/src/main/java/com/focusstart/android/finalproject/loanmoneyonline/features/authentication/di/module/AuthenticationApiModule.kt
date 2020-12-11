package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.network.api.IAuthApi
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.scope.AuthenticationScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthenticationApiModule {
    @Provides
    @AuthenticationScope
    fun provideAuthApiClass(retrofit: Retrofit): IAuthApi = retrofit.create(IAuthApi::class.java)
}