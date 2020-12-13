package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ITokenRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.domain.useCase.CheckingBearerTokenAvailabilityUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert
import org.junit.Test

class CheckingBearerTokenAvailabilityUseCaseTest {
    private val tokenRepository: ITokenRepository = mock()
    private val useCase = CheckingBearerTokenAvailabilityUseCase(tokenRepository)

    @Test
    fun `on invoke EXPECT checking bearer token availability in token repository`() {
        useCase.invoke()

        verify(tokenRepository).checkingBearerTokenAvailability()
    }

    @Test
    fun `on invoke EXPECT return value from token repository`() {
        whenever(tokenRepository.checkingBearerTokenAvailability()).thenReturn(true)

        val actual = useCase.invoke()

        val expected = true
        Assert.assertEquals(expected, actual)
    }

}