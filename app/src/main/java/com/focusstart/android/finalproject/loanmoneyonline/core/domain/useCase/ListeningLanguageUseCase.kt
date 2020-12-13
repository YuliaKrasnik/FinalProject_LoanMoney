package com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.data.repository.SettingsRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ISettingsRepository
import io.reactivex.Flowable

class ListeningLanguageUseCase (private val settingsRepository: ISettingsRepository) {
    operator fun invoke(): Flowable<String> = settingsRepository.listeningLanguageUpdate()
}