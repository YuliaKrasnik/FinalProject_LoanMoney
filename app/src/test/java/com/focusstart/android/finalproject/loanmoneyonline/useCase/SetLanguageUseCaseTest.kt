package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ISettingsRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.SetLanguageUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class SetLanguageUseCaseTest {
    private val settingsRepository: ISettingsRepository = mock()
    private val useCase = SetLanguageUseCase(settingsRepository)
    private val locale = "ru"

    @Test
    fun `on invoke EXPECT set language in settings repository`() {
        useCase.invoke(locale)

        verify(settingsRepository).setLanguage(locale)
    }
}