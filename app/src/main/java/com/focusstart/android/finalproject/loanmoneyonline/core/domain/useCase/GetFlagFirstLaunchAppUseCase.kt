package com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.data.repository.SettingsRepositoryImpl

class GetFlagFirstLaunchAppUseCase(private val settingsRepository: SettingsRepositoryImpl) {
    operator fun invoke(): Boolean = settingsRepository.getFlagFirstLaunchApp()
}