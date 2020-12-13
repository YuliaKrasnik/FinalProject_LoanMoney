package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.DeleteCachedLoansUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class DeleteCachedLoansUseCaseTest {
    private val loanRepository: ILoanRepository = mock()
    private val useCase = DeleteCachedLoansUseCase(loanRepository)

    @Test
    fun `on invoke EXPECT delete cached loans in loan repository`() {
        useCase.invoke()

        verify(loanRepository).deleteCachedLoans()
    }
}