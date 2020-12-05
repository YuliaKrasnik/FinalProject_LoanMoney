package com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_AMOUNT
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_DATE
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_FIRST_NAME
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_LAST_NAME
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_PERCENT
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_PERIOD
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_PHONE_NUMBER
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_STATE

class LoanProfilePresenterImpl : ILoanProfilePresenter {
    private var view: ILoanProfileView? = null
    override fun onResume(arguments: Bundle?) {
        getProfileInformation(arguments)
    }

    override fun <T> attachView(view: T) {
        this.view = view as ILoanProfileView
    }

    private fun getProfileInformation(arguments: Bundle?) {
        arguments?.let {
            val amount = it.getInt(BUNDLE_KEY_AMOUNT).toString()
            val date = it.getString(BUNDLE_KEY_DATE).toString()
            val firstName = it.getString(BUNDLE_KEY_FIRST_NAME).toString()
            val lastName = it.getString(BUNDLE_KEY_LAST_NAME).toString()
            val percent = it.getDouble(BUNDLE_KEY_PERCENT).toString()
            val period = it.getInt(BUNDLE_KEY_PERIOD).toString()
            val phoneNumber = it.getString(BUNDLE_KEY_PHONE_NUMBER).toString()
            val state = it.getString(BUNDLE_KEY_STATE).toString()

            view?.showLoanProfile(
                firstName,
                lastName,
                phoneNumber,
                date,
                amount,
                period,
                percent,
                state
            )
        }
    }

    override fun detachView() {
        this.view = null
    }
}