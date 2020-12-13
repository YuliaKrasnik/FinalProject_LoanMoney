package com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository

class SaveLoanToDbUseCase(private val loanRepository: ILoanRepository) {
    operator fun invoke(loan: Loan) =
            loanRepository.saveLoanInDb(loan)
}