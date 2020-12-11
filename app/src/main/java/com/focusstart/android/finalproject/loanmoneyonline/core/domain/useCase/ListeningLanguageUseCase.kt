package com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.data.repository.SettingsRepositoryImpl
import io.reactivex.Flowable

class ListeningLanguageUseCase (private val settingsRepository: SettingsRepositoryImpl) {
    operator fun invoke(): Flowable<String> = settingsRepository.listeningLanguageUpdate()
}