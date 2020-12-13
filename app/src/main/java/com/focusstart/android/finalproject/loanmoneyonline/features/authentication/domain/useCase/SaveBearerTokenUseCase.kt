package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ITokenRepository

class SaveBearerTokenUseCase(private val tokenRepository: ITokenRepository) {
    operator fun invoke(token: String) = tokenRepository.saveBearerToken(token)
}