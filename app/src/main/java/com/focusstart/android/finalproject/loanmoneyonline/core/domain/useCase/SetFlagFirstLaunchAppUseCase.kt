package com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ISettingsRepository

class SetFlagFirstLaunchAppUseCase(private val settingsRepository: ISettingsRepository) {
    operator fun invoke(flag: Boolean) = settingsRepository.setFlagFirstLaunchApp(flag)
}
