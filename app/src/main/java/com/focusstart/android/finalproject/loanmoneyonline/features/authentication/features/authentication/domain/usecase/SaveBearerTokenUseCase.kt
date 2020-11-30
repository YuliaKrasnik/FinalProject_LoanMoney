package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.authentication.domain.usecase

import com.focusstart.android.finalproject.loanmoneyonline.features.token.domain.repository.ITokenRepository

class SaveBearerTokenUseCase(private val tokenRepository: ITokenRepository) {
    operator fun invoke(token: String) = tokenRepository.saveBearerToken(token)
}