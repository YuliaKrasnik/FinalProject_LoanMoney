package com.focusstart.android.finalproject.loanmoneyonline.domain.repository

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.data.model.LoanConditions
import io.reactivex.Single
import retrofit2.Response

interface ILoanRepository {
    fun getLoansList(): Single<Response<List<Loan>>>
    fun registerLoan(firstName: String, secondName: String, phoneNumber: String, amount: String, period: String, percent: String): Single<Response<Loan>>
    fun getLoanConditions(): Single<Response<LoanConditions>>
}