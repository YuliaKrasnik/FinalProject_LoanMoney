package com.focusstart.android.finalproject.loanmoneyonline.features.settings.presentation

import android.util.Log
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.SetFlagFirstLaunchAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.DeleteCachedLoansUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.DeleteTokenUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.SetLanguageUseCase
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class SettingsPresenterImpl(
        private val setLanguageUseCase: SetLanguageUseCase,
        private val deleteTokenUseCase: DeleteTokenUseCase,
        private val deleteCachedLoansUseCase: DeleteCachedLoansUseCase,
        private val setFlagFirstLaunchAppUseCase: SetFlagFirstLaunchAppUseCase
) : ISettingsPresenter {
    companion object {
        private const val RUSSIAN_LANGUAGE = "ru"
        private const val ENGLISH_LANGUAGE = "en"
    }

    private var view: ISettingsView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun onLogoutButtonClicked() {
        clearData()
    }

    private fun clearData() {
        deleteToken()
        resetFlagFirstLaunchApp()
        deleteCachedLoans()
        view?.logout()
    }

    private fun resetFlagFirstLaunchApp() = setFlagFirstLaunchAppUseCase(true)

    private fun deleteCachedLoans() {
        Completable.fromAction { deleteCachedLoansUseCase() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {
                    Log.e(Constants.TAG_ERROR, "delete cached loans from database: ${it.message}")
                })
                .addTo(compositeDisposable)
    }

    private fun deleteToken() {
        deleteTokenUseCase()
    }

    override fun onRussianLanguageClicked() {
        setLanguage(RUSSIAN_LANGUAGE)
        comeBack()
    }

    override fun onEnglishLanguageClicked() {
        setLanguage(ENGLISH_LANGUAGE)
        comeBack()
    }

    private fun comeBack() {
        view?.comeBack()
    }

    private fun setLanguage(locale: String) {
        setLanguageUseCase(locale)
    }

    override fun <T> attachView(view: T) {
        this.view = view as ISettingsView
    }

    override fun detachView() {
        this.view = null
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}