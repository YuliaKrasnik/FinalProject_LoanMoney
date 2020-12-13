package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetListOfLoansFromDbUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test

class GetListOfLoansFromDbUseCaseTest {
    private val loanRepository: ILoanRepository = mock()
    private val useCase = GetListOfLoansFromDbUseCase(loanRepository)
    private val listLoans = listOf<Loan>()

    @Test
    fun `on invoke EXPECT get loans list from db in loan repository`() {
        useCase()

        verify(loanRepository).getLoansListFromDb()
    }

    @Test
    fun `on invoke EXPECT complete`() {
        whenever(loanRepository.getLoansListFromDb()).thenReturn(Single.just(listLoans))

        useCase()
                .test()
                .assertComplete()
    }

    @Test
    fun `on invoke EXPECT response list of loans`() {
        whenever(loanRepository.getLoansListFromDb()).thenReturn(Single.just(listLoans))

        useCase()
                .test()
                .assertValue(listLoans)
    }

    @Test
    fun `on invoke EXPECT error`() {
        val response = Throwable("error")
        whenever(loanRepository.getLoansListFromDb()).thenReturn(Single.error(response))

        useCase()
                .test()
                .assertError(response)
    }
}