package com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository

class DeleteCachedLoansUseCase(private val loanRepository: ILoanRepository) {
    operator fun invoke() = loanRepository.deleteCachedLoans()
}