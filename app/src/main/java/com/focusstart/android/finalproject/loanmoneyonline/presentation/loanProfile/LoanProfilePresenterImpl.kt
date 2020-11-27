package com.focusstart.android.finalproject.loanmoneyonline.presentation.loanProfile

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_AMOUNT
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_DATE
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_FIRST_NAME
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_ID
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_LAST_NAME
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_PERCENT
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_PERIOD
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_PHONE_NUMBER
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_STATE
import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan

class LoanProfilePresenterImpl : ILoanProfilePresenter {
    private var view: ILoanProfileView? = null
    override fun onResume(arguments: Bundle?) {
        getProfileInformation(arguments)
    }

    private fun getProfileInformation(arguments: Bundle?) {
        arguments?.let {
            val amount = it.getInt(BUNDLE_KEY_AMOUNT)
            val date = it.getString(BUNDLE_KEY_DATE).toString()
            val firstName = it.getString(BUNDLE_KEY_FIRST_NAME).toString()
            val id = it.getInt(BUNDLE_KEY_ID)
            val lastName = it.getString(BUNDLE_KEY_LAST_NAME).toString()
            val percent = it.getDouble(BUNDLE_KEY_PERCENT)
            val period = it.getInt(BUNDLE_KEY_PERIOD)
            val phoneNumber = it.getString(BUNDLE_KEY_PHONE_NUMBER).toString()
            val state = it.getString(BUNDLE_KEY_STATE).toString()

            val loan = Loan(amount, date, firstName, id, lastName, percent, period, phoneNumber, state)
            view?.showLoanProfile(loan)
        }
    }

    override fun attachView(view: ILoanProfileView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}