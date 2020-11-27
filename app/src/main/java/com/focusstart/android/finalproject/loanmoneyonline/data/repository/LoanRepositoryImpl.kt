package com.focusstart.android.finalproject.loanmoneyonline.data.repository

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoanDataSource
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SharedPreferenceSource
import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.data.model.LoanRequest
import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ILoanRepository
import io.reactivex.Single
import retrofit2.Response

class LoanRepositoryImpl(private val dataSource: LoanDataSource, private val sharedPreferenceSource: SharedPreferenceSource) : ILoanRepository {
    override fun getLoansList(): Single<Response<List<Loan>>> =
            dataSource.getLoansList(getBearerToken())

    override fun registerLoan(firstName: String, secondName: String, phoneNumber: String, amount: String, period: String, percent: String): Single<Response<Loan>> {
        val loanRequest = LoanRequest(amount.toInt(), firstName, secondName, percent.toDouble(), period.toInt(), phoneNumber)
        return dataSource.registerLoan(loanRequest, getBearerToken())
    }


    private fun getBearerToken(): String = sharedPreferenceSource.getBearerToken()

}