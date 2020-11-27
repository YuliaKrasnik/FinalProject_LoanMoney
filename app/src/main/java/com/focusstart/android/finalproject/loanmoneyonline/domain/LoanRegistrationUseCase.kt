package com.focusstart.android.finalproject.loanmoneyonline.domain

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.data.model.LoanRequest
import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ILoanRepository
import io.reactivex.Single
import retrofit2.Response

class LoanRegistrationUseCase (private val loanRepository: ILoanRepository) {
    operator fun invoke(loanRequest: LoanRequest): Single<Response<Loan>> =
            loanRepository.registerLoan(loanRequest)
}