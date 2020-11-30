package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.network.api

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.Auth
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.UserEntity
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IAuthApi {
    @POST("login")
    fun authenticationIntoApp(
            @Body bodyRequest: Auth
    ): Single<Response<ResponseBody>>

    @POST("registration")
    fun registrationInApp(
            @Body bodyRequest: Auth
    ): Single<Response<UserEntity>>
}