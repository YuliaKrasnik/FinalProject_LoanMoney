package com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.token.domain.repository.ITokenRepository

class CheckingBearerTokenAvailabilityUseCase(private val tokenRepository: ITokenRepository) {
    operator fun invoke(): Boolean = tokenRepository.checkingBearerTokenAvailability()
}