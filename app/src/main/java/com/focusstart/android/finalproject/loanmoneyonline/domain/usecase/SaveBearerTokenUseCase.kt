package com.focusstart.android.finalproject.loanmoneyonline.domain.usecase

import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ITokenRepository

class SaveBearerTokenUseCase(private val tokenRepository: ITokenRepository) {
    operator fun invoke(token: String) = tokenRepository.saveBearerToken(token)
}