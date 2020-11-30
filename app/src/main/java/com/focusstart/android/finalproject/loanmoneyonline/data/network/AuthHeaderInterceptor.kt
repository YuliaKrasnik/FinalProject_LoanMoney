package com.focusstart.android.finalproject.loanmoneyonline.data.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthHeaderInterceptor(private val tokenProvider: ITokenProvider) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest: Request = chain.request()

        val builder: Request.Builder = originRequest.newBuilder()

        tokenProvider.getBearerToken()?.let {
            builder.addHeader("Authorization", it)
        }

        return chain.proceed(builder.build())

    }
}