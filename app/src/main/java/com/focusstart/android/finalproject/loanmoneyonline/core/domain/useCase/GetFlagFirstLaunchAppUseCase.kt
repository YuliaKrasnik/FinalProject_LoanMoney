package com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ISettingsRepository

class GetFlagFirstLaunchAppUseCase(private val settingsRepository: ISettingsRepository) {
    operator fun invoke(): Boolean = settingsRepository.getFlagFirstLaunchApp()
}