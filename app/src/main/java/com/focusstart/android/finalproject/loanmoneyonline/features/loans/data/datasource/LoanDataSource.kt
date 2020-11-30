package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.datasource

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.LoanConditions
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.LoanRequest
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.network.api.ILoanApi
import io.reactivex.Single
import retrofit2.Response

interface LoanDataSource {
    fun getLoansList(): Single<Response<List<Loan>>>
    fun registerLoan(loanRequest: LoanRequest): Single<Response<Loan>>
    fun getLoanConditions(): Single<Response<LoanConditions>>
}

class LoanDataSourceImpl(private val apiService: ILoanApi) : LoanDataSource {
    override fun getLoansList(): Single<Response<List<Loan>>> {
        return apiService.getLoansList()
    }

    override fun registerLoan(loanRequest: LoanRequest): Single<Response<Loan>> {
        return apiService.createNewLoan(loanRequest)
    }

    override fun getLoanConditions(): Single<Response<LoanConditions>> {
        return apiService.getLoanConditions()
    }

}