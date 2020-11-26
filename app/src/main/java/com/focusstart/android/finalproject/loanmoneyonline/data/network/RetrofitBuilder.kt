package com.focusstart.android.finalproject.loanmoneyonline.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private var retrofit: Retrofit? = null
    private const val BASE_URL =
        "http://focusapp-env.eba-xm2atk2z.eu-central-1.elasticbeanstalk.com/"

    private fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun <T> buildService(service: Class<T>): T {
        return getRetrofit().create(service)
    }
}

