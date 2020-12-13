package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ITokenRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.SaveBearerTokenUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class SaveBearerTokenUseCaseTest {
    private val tokenRepository: ITokenRepository = mock()
    private val useCase = SaveBearerTokenUseCase(tokenRepository)

    @Test
    fun `on invoke EXPECT save bearer token in token repository`() {
        val bearerToken = "Bearer token"

        useCase.invoke(bearerToken)

        verify(tokenRepository).saveBearerToken(bearerToken)
    }

}