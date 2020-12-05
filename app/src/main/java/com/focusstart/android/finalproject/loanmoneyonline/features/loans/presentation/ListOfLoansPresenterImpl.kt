package com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_AMOUNT
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_DATE
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_FIRST_NAME
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_ID
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_LAST_NAME
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_PERCENT
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_PERIOD
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_PHONE_NUMBER
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_STATE
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetListOfLoansUseCase
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import retrofit2.Response

class ListOfLoansPresenterImpl(private val getListOfLoansUseCase: GetListOfLoansUseCase) :
        IListOfLoansPresenter {
    private var view: IListOfLoansView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun onResume() {
        getListOfLoans()
    }

    private fun getListOfLoans() {
        getListOfLoansUseCase()
                .compose(applySchedulers())
                .subscribe(object : SingleObserver<Response<List<Loan>>> {
                    override fun onSubscribe(disposable: Disposable) {
                        compositeDisposable.add(disposable)
                    }

                    override fun onSuccess(response: Response<List<Loan>>) {
                        processingResponseGetListOfLoans(response)
                    }

                    override fun onError(e: Throwable) {
                        Log.e(Constants.TAG_ERROR, "get list of loan: ${e.message}")
                    }
                })
    }

    private fun processingResponseGetListOfLoans(response: Response<List<Loan>>) {
        if (response.isSuccessful) {
            val listOfLoans = response.body()
            listOfLoans?.let { view?.showLoans(it) }
        }
    }

    override fun detachView() {
        this.view = null
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun onCreateNewLoanButtonClicked() {
        view?.navigateToLoanRegistrationFragment()
    }

    override fun getNavigationBundle(loan: Loan, resources: Resources): Bundle {
        val bundle = Bundle()
        bundle.putInt(BUNDLE_KEY_AMOUNT, loan.amount)
        bundle.putString(BUNDLE_KEY_DATE, getConvertedDate(loan.date))
        bundle.putString(BUNDLE_KEY_FIRST_NAME, loan.firstName)
        bundle.putInt(BUNDLE_KEY_ID, loan.id)
        bundle.putString(BUNDLE_KEY_LAST_NAME, loan.lastName)
        bundle.putDouble(BUNDLE_KEY_PERCENT, loan.percent)
        bundle.putInt(BUNDLE_KEY_PERIOD, loan.period)
        bundle.putString(BUNDLE_KEY_PHONE_NUMBER, loan.phoneNumber)
        bundle.putString(BUNDLE_KEY_STATE, transformNameState(loan.state, resources))
        return bundle
    }

    override fun determineColorState(state: String, resources: Resources): Int {
        return when (state) {
            "APPROVED" -> ResourcesCompat.getColor(resources, R.color.loan_state_approved, null)
            "REGISTERED" -> ResourcesCompat.getColor(resources, R.color.loan_state_registered, null)
            "REJECTED" -> ResourcesCompat.getColor(resources, R.color.loan_state_rejected, null)
            else -> ResourcesCompat.getColor(resources, R.color.black, null)
        }
    }

    override fun transformNameState(state: String, resources: Resources): String {
        return when (state) {
            "APPROVED" -> resources.getString(R.string.name_loan_state_approved)
            "REGISTERED" -> resources.getString(R.string.name_loan_state_registered)
            "REJECTED" -> resources.getString(R.string.name_loan_state_rejected)
            else -> resources.getString(R.string.name_loan_state_default)
        }
    }

    private fun getConvertedDate(date: String): String {
        val dateWithoutTime = date.split("T")
        val dateComponent = dateWithoutTime[0].split("-")
        return "${dateComponent[2]}.${dateComponent[1]}.${dateComponent[0]}"
    }

    override fun transformDate(date: String, resources: Resources): String {
        val startDateString = resources.getString(R.string.start_date_string_in_list)
        return "$startDateString ${getConvertedDate(date)}"
    }

    override fun <T> attachView(view: T) {
        this.view = view as IListOfLoansView
    }

}