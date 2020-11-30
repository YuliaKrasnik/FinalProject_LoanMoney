package com.focusstart.android.finalproject.loanmoneyonline.di.application

import com.focusstart.android.finalproject.loanmoneyonline.data.network.AuthHeaderInterceptor
import com.focusstart.android.finalproject.loanmoneyonline.data.network.TokenProviderImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.network.api.IAuthApi
import com.focusstart.android.finalproject.loanmoneyonline.data.network.api.ILoanApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule(private val url: String) {

    @Provides
    @ApplicationScope
    fun provideAuthApiClass(retrofit: Retrofit): IAuthApi = retrofit.create(IAuthApi::class.java)

    @Provides
    @ApplicationScope
    fun provideLoanApiClass(retrofit: Retrofit): ILoanApi = retrofit.create(ILoanApi::class.java)

    @Provides
    @ApplicationScope
    fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory, rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit =
            Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(url)
                    .addCallAdapterFactory(rxJava2CallAdapterFactory)
                    .addConverterFactory(gsonConverterFactory)
                    .build()

    @Provides
    @ApplicationScope
    fun provideRxCallAdapterFactory(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @ApplicationScope
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(interceptor: AuthHeaderInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

    @Provides
    @ApplicationScope
    fun provideInterceptor(tokenProviderImpl: TokenProviderImpl): AuthHeaderInterceptor = AuthHeaderInterceptor(tokenProviderImpl)
}