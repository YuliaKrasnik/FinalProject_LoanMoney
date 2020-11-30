package com.focusstart.android.finalproject.loanmoneyonline.data.network.api

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.data.model.LoanConditions
import com.focusstart.android.finalproject.loanmoneyonline.data.model.LoanRequest
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ILoanApi {
    @GET("loans/all")
    fun getLoansList(
    ): Single<Response<List<Loan>>>

    @POST("loans/")
    fun createNewLoan(
            @Body bodyRequest: LoanRequest,
    ): Single<Response<Loan>>

    @GET("loans/{id}")
    fun getLoanData(
            @Path("id") idLoan: Int,
    ): Single<Response<Loan>>

    @GET("loans/conditions")
    fun getLoanConditions(
    ): Single<Response<LoanConditions>>

}