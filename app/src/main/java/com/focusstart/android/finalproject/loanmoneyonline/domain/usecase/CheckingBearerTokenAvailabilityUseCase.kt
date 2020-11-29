package com.focusstart.android.finalproject.loanmoneyonline.domain.usecase

import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ISettingsRepository

class CheckingBearerTokenAvailabilityUseCase(private val settingsRepository: ISettingsRepository) {
    operator fun invoke(): Boolean = settingsRepository.checkingBearerTokenAvailability()
}