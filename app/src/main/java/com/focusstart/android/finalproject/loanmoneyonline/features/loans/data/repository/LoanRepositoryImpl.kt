package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.repository

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.datasource.LoanDataSource
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.LoanConditions
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.LoanRequest
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import io.reactivex.Single
import retrofit2.Response

class LoanRepositoryImpl(
        private val dataSource: LoanDataSource
) : ILoanRepository {
    override fun getLoansList(): Single<Response<List<Loan>>> =
            dataSource.getLoansList()

    override fun registerLoan(
            firstName: String,
            secondName: String,
            phoneNumber: String,
            amount: String,
            period: String,
            percent: String
    ): Single<Response<Loan>> {
        val loanRequest = LoanRequest(
                amount.toInt(),
                firstName,
                secondName,
                percent.toDouble(),
                period.toInt(),
                phoneNumber
        )
        return dataSource.registerLoan(loanRequest)
    }

    override fun getLoanConditions(): Single<Response<LoanConditions>> =
            dataSource.getLoanConditions()

}