package com.focusstart.android.finalproject.loanmoneyonline.domain.usecase

import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ITokenRepository

class CheckingBearerTokenAvailabilityUseCase(private val tokenRepository: ITokenRepository) {
    operator fun invoke(): Boolean = tokenRepository.checkingBearerTokenAvailability()
}