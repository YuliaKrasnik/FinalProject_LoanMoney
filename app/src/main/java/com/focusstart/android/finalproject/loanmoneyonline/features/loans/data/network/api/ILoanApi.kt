package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.network.api

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanConditionsNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanRequestNetwork
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ILoanApi {
    @GET("loans/all")
    fun getLoansList(
    ): Single<Response<List<LoanNetwork>>>

    @POST("loans/")
    fun createNewLoan(
        @Body bodyRequest: LoanRequestNetwork,
    ): Single<Response<LoanNetwork>>

    @GET("loans/{id}")
    fun getLoanData(
            @Path("id") idLoan: Int,
    ): Single<Response<LoanNetwork>>

    @GET("loans/conditions")
    fun getLoanConditions(
    ): Single<Response<LoanConditionsNetwork>>

}