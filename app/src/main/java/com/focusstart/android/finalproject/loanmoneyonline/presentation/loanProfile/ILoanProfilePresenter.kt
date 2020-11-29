package com.focusstart.android.finalproject.loanmoneyonline.presentation.loanProfile

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBasePresenter

interface ILoanProfilePresenter : IBasePresenter {
    fun onResume(arguments: Bundle?)

    fun attachView(view: ILoanProfileView)

    fun detachView()

}