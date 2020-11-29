package com.focusstart.android.finalproject.loanmoneyonline.domain.usecase

import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ISettingsRepository

class SaveBearerTokenUseCase(private val settingsRepository: ISettingsRepository) {
    operator fun invoke(token: String) = settingsRepository.saveBearerToken(token)
}