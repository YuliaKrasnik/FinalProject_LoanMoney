package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.SaveLoanToDbUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class SaveLoanToDbUseCaseTest {
    private val loanRepository: ILoanRepository = mock()
    private val useCase = SaveLoanToDbUseCase(loanRepository)
    private val loan = Loan(
            10000,
            "2020-12-04T18:52:05.052Z",
            "firstName",
            0,
            "lastName",
            0.1,
            0,
            "phoneNumber",
            "APPROVED"
    )

    @Test
    fun `on invoke EXPECT save loan in db in loan repository`() {
        useCase(loan)

        verify(loanRepository).saveLoanInDb(loan)
    }
}