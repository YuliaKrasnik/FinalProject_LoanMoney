package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetListOfLoansFromNetworkUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test
import retrofit2.Response

class GetListOfLoansFromNetworkUseCaseTest {
    private val loanRepository: ILoanRepository = mock()
    private val useCase = GetListOfLoansFromNetworkUseCase(loanRepository)
    private val listLoans = listOf<Loan>()
    private val response: Response<List<Loan>> = Response.success(listLoans)

    @Test
    fun `on invoke EXPECT get loans list from network in loan repository`() {
        useCase()

        verify(loanRepository).getLoansListFromNetwork()
    }

    @Test
    fun `on invoke EXPECT complete`() {
        whenever(loanRepository.getLoansListFromNetwork()).thenReturn(Single.just(response))

        useCase()
                .test()
                .assertComplete()
    }

    @Test
    fun `on invoke EXPECT response list of loans`() {
        whenever(loanRepository.getLoansListFromNetwork()).thenReturn(Single.just(response))

        useCase()
                .test()
                .assertValue(response)
    }

    @Test
    fun `on invoke EXPECT error`() {
        val response = Throwable("error")
        whenever(loanRepository.getLoansListFromNetwork()).thenReturn(Single.error(response))

        useCase()
                .test()
                .assertError(response)
    }

}