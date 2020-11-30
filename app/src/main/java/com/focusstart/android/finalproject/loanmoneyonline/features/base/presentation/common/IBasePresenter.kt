package com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common

import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface IBasePresenter {
    fun <T> attachView(view: T)

    fun detachView()

    fun <T> applySchedulers(): SingleTransformer<T, T> {
        return SingleTransformer<T, T> { upstream ->
            upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

}