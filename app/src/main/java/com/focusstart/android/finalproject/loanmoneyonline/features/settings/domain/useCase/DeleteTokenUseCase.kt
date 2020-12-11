package com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ITokenRepository

class DeleteTokenUseCase(private val tokenRepository: ITokenRepository) {
    operator fun invoke() = tokenRepository.deleteToken()
}