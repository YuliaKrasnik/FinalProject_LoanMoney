package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.SaveListOfLoansToDbUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class SaveListOfLoansToDbUseCaseTest {
    private val loanRepository: ILoanRepository = mock()
    private val useCase = SaveListOfLoansToDbUseCase(loanRepository)
    private val listLoans = mutableListOf<Loan>()

    @Test
    fun `on invoke EXPECT save loans list in db in loan repository`() {
        useCase(listLoans)

        verify(loanRepository).saveLoansListInDb(listLoans)
    }
}