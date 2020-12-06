package com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.data.repository.SettingsRepositoryImpl

class SetFlagFirstLaunchAppUseCase(private val settingsRepository: SettingsRepositoryImpl) {
    operator fun invoke(flag: Boolean) = settingsRepository.setFlagFirstLaunchApp(flag)
}
