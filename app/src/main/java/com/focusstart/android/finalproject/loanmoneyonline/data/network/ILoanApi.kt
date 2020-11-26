package com.focusstart.android.finalproject.loanmoneyonline.data.network

import com.focusstart.android.finalproject.loanmoneyonline.data.model.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ILoanApi {
    @POST("login")
    fun loginIntoApp(
        @Body bodyRequest: Auth
    ): Call<ResponseBody>

    @POST("registration")
    fun registrationInApp(
        @Body bodyRequest: Auth
    ): Call<UserEntity>

    @GET("loans/")
    fun getLoansList(
        @Header("Authorization") authHeader: String
    ): Call<List<Loan>>

    @POST("loans/")
    fun createNewLoan(
        @Body bodyRequest: LoanRequest,
        @Header("Authorization") authHeader: String
    ): Call<Loan>

    @GET("loans/{id}")
    fun getLoanData(
        @Header("Authorization") authHeader: String
      //id
    ): Call<Loan>

    @GET("loans/conditions")
    fun getLoanConditions(
        @Header("Authorization") authHeader: String
    ): Call<LoanConditions>
    
}