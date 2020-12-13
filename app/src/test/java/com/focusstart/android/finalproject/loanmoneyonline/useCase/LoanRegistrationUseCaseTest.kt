package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.LoanRequest
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.LoanRegistrationUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test
import retrofit2.Response

class LoanRegistrationUseCaseTest {
    private val loanRepository: ILoanRepository = mock()
    private val useCase = LoanRegistrationUseCase(loanRepository)
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
    private val loanRequest = LoanRequest(
            0,
            "firstName",
            "lastName",
            0.1,
            0,
            "phone"
    )

    @Test
    fun `on invoke EXPECT register loan in loan repository`() {
        useCase(loanRequest)

        verify(loanRepository).registerLoan(loanRequest)
    }

    @Test
    fun `on invoke EXPECT complete`() {
        val response: Response<Loan> = Response.success(loan)
        whenever(loanRepository.registerLoan(loanRequest)).thenReturn(Single.just(response))

        useCase(loanRequest)
                .test()
                .assertComplete()
    }

    @Test
    fun `on invoke EXPECT get response loan`() {
        val response: Response<Loan> = Response.success(loan)
        whenever(loanRepository.registerLoan(loanRequest)).thenReturn(Single.just(response))

        useCase(loanRequest)
                .test()
                .assertValue(response)
    }

    @Test
    fun `on invoke EXPECT error`() {
        val response = Throwable("error")
        whenever(loanRepository.registerLoan(loanRequest)).thenReturn(Single.error(response))

        useCase(loanRequest)
                .test()
                .assertError(response)
    }

}