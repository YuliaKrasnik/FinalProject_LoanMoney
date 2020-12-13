package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.LoanConditions
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetConditionsLoanUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test
import retrofit2.Response

class GetConditionsLoanUseCaseTest {
    private val loanRepository: ILoanRepository = mock()
    private val useCase = GetConditionsLoanUseCase(loanRepository)

    @Test
    fun `on invoke EXPECT get loan conditions in loan repository`() {
        useCase()

        verify(loanRepository).getLoanConditions()
    }

    @Test
    fun `on invoke EXPECT complete`() {
        val loanConditions = LoanConditions(10000, 9.2, 30)
        val response: Response<LoanConditions> = Response.success(loanConditions)
        whenever(loanRepository.getLoanConditions()).thenReturn(Single.just(response))

        useCase()
                .test()
                .assertComplete()
    }

    @Test
    fun `on invoke EXPECT get response loan conditions`() {
        val loanConditions = LoanConditions(10000, 9.2, 30)
        val response: Response<LoanConditions> = Response.success(loanConditions)
        whenever(loanRepository.getLoanConditions()).thenReturn(Single.just(response))

        useCase()
                .test()
                .assertValue(response)
    }

    @Test
    fun `on invoke EXPECT error`() {
        val response = Throwable("error")
        whenever(loanRepository.getLoanConditions()).thenReturn(Single.error(response))

        useCase()
                .test()
                .assertError(response)
    }

}