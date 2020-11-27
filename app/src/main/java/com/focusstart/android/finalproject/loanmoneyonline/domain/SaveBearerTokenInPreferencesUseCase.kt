package com.focusstart.android.finalproject.loanmoneyonline.domain

import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ISharedPreferenceRepository

class SaveBearerTokenInPreferencesUseCase(private val sharedPreferencesRepository: ISharedPreferenceRepository) {
    operator fun invoke(token: String) = sharedPreferencesRepository.saveBearerToken(token)
}