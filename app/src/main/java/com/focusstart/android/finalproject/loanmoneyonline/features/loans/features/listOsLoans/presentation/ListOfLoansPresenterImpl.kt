package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.presentation

import android.os.Bundle
import android.util.Log
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
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.domain.usecase.GetListOfLoansUseCase
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

    override fun getNavigationBundle(loan: Loan): Bundle {
        val bundle = Bundle()
        bundle.putInt(BUNDLE_KEY_AMOUNT, loan.amount)
        bundle.putString(BUNDLE_KEY_DATE, loan.date)
        bundle.putString(BUNDLE_KEY_FIRST_NAME, loan.firstName)
        bundle.putInt(BUNDLE_KEY_ID, loan.id)
        bundle.putString(BUNDLE_KEY_LAST_NAME, loan.lastName)
        bundle.putDouble(BUNDLE_KEY_PERCENT, loan.percent)
        bundle.putInt(BUNDLE_KEY_PERIOD, loan.period)
        bundle.putString(BUNDLE_KEY_PHONE_NUMBER, loan.phoneNumber)
        bundle.putString(BUNDLE_KEY_STATE, loan.state)
        return bundle
    }

    override fun <T> attachView(view: T) {
        this.view = view as IListOfLoansView
    }

}