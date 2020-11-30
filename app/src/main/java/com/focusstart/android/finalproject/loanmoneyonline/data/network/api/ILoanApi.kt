package com.focusstart.android.finalproject.loanmoneyonline.data.network.api

import com.focusstart.android.finalproject.loanmoneyonline.data.model.*
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ILoanApi {
    @GET("loans/all")
    fun getLoansList(
            @Header("Authorization") authHeader: String
    ): Single<Response<List<Loan>>>

    @POST("loans/")
    fun createNewLoan(
            @Body bodyRequest: LoanRequest,
            @Header("Authorization") authHeader: String
    ): Single<Response<Loan>>

    @GET("loans/{id}")
    fun getLoanData(
            @Path("id") idLoan: Int,
            @Header("Authorization") authHeader: String
    ): Single<Response<Loan>>

    @GET("loans/conditions")
    fun getLoanConditions(
            @Header("Authorization") authHeader: String
    ): Single<Response<LoanConditions>>

}