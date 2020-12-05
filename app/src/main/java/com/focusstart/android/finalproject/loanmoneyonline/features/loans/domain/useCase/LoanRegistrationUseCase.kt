package com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.LoanRequest
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import io.reactivex.Single
import retrofit2.Response

class LoanRegistrationUseCase(private val loanRepository: ILoanRepository) {
    operator fun invoke(loanRequest: LoanRequest): Single<Response<Loan>> =
            loanRepository.registerLoan(loanRequest)
}