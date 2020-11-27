package com.focusstart.android.finalproject.loanmoneyonline.domain

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.data.model.LoanRequest
import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ILoanRepository
import io.reactivex.Single
import retrofit2.Response

class LoanRegistrationUseCase (private val loanRepository: ILoanRepository) {
    operator fun invoke(firstName: String, secondName: String, phoneNumber: String, amount: String, period: String, percent: String): Single<Response<Loan>> =
            loanRepository.registerLoan(firstName, secondName, phoneNumber, amount, period, percent)
}