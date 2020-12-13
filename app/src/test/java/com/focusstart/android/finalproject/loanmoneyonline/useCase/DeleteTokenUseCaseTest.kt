package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ITokenRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.DeleteTokenUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class DeleteTokenUseCaseTest {
    private val tokenRepository: ITokenRepository = mock()
    private val useCase = DeleteTokenUseCase(tokenRepository)

    @Test
    fun `on invoke EXPECT delete token in token repository`() {
        useCase.invoke()

        verify(tokenRepository).deleteToken()
    }
}