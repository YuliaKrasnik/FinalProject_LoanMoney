package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.network.api

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.AuthNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.UserEntityNetwork
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IAuthApi {
    @POST("login")
    fun authenticationIntoApp(
            @Body bodyRequest: AuthNetwork
    ): Single<Response<ResponseBody>>

    @POST("registration")
    fun registrationInApp(
            @Body bodyRequest: AuthNetwork
    ): Single<Response<UserEntityNetwork>>
}