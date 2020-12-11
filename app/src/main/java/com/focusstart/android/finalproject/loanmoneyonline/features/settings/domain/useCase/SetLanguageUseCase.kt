package com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ISettingsRepository

class SetLanguageUseCase(private val settingsRepository: ISettingsRepository) {
    operator fun invoke(locale: String) = settingsRepository.setLanguage(locale)
}