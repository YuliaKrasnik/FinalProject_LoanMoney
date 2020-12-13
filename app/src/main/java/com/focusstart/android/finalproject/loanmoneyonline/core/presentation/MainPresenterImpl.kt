package com.focusstart.android.finalproject.loanmoneyonline.core.presentation

import android.util.Log
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.ListeningLanguageUseCase
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.TAG_DEBUG
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.TAG_ERROR
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MainPresenterImpl(private val listeningLanguageUseCase: ListeningLanguageUseCase) : IMainPresenter {
    private var view: IMainView? = null
    private val compositeDisposable = CompositeDisposable()

    private fun subscribeUpdateLanguage() {
        listeningLanguageUseCase()
                .compose(applyFlowableSchedulers())
                .subscribe({
                    Log.d(TAG_DEBUG, "locale $it")
                    view?.restartView()
                }, {
                    Log.e(TAG_ERROR, "subscribe update language: ${it.message}")
                })
                .addTo(compositeDisposable)
    }

    override fun <T> attachView(view: T) {
        this.view = view as IMainView
        subscribeUpdateLanguage()
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun detachView() {
        view = null
    }

}
