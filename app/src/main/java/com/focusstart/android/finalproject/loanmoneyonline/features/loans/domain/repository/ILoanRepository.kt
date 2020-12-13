package com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.LoanConditions
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.LoanRequest
import io.reactivex.Single
import retrofit2.Response

interface ILoanRepository {
    fun getLoansListFromNetwork(): Single<Response<List<Loan>>>
    fun registerLoan(loanRequest: LoanRequest): Single<Response<Loan>>
    fun getLoanConditions(): Single<Response<LoanConditions>>
    fun getLoansListFromDb(): Single<List<Loan>>
    fun saveLoansListInDb(listOfLoans: List<Loan>)
    fun saveLoanInDb(loan: Loan)
    fun deleteCachedLoans()
}