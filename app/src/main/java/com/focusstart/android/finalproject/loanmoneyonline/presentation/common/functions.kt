package com.focusstart.android.finalproject.loanmoneyonline.presentation.common

import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> applySchedulers(): SingleTransformer<T, T> {
    return SingleTransformer<T, T> { upstream ->
        upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
