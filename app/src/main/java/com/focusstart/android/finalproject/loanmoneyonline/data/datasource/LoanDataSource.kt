package com.focusstart.android.finalproject.loanmoneyonline.data.datasource

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.data.model.LoanRequest
import com.focusstart.android.finalproject.loanmoneyonline.data.network.ILoanApi
import com.focusstart.android.finalproject.loanmoneyonline.data.network.RetrofitBuilder
import io.reactivex.Single
import retrofit2.Response

interface LoanDataSource {
    fun getLoansList(bearerToken: String): Single<Response<List<Loan>>>
    fun registerLoan(loanRequest: LoanRequest, bearerToken: String): Single<Response<Loan>>
}

class LoanDataSourceImpl : LoanDataSource {
    private val apiService by lazy { RetrofitBuilder.buildService(ILoanApi::class.java) }

    override fun getLoansList(bearerToken: String): Single<Response<List<Loan>>> {
        return apiService.getLoansList(bearerToken)
    }

    override fun registerLoan(loanRequest: LoanRequest, bearerToken: String): Single<Response<Loan>> {
        return apiService.createNewLoan(loanRequest, bearerToken)
    }

}