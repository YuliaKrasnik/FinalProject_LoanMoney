package com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.GetFlagFirstLaunchAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.SetFlagFirstLaunchAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetListOfLoansFromDbUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetListOfLoansFromNetworkUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.SaveListOfLoansToDbUseCase
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
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class ListOfLoansPresenterImpl(
        private val getListOfLoansFromNetworkUseCase: GetListOfLoansFromNetworkUseCase,
        private val getListOfLoansFromDbUseCase: GetListOfLoansFromDbUseCase,
        private val saveListOfLoansToDbUseCase: SaveListOfLoansToDbUseCase,
        private val getFlagFirstLaunchAppUseCase: GetFlagFirstLaunchAppUseCase,
        private val setFlagFirstLaunchAppUseCase: SetFlagFirstLaunchAppUseCase)
    : IListOfLoansPresenter {

    private var view: IListOfLoansView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun onResume() {
        if (isAppLaunchedFirstTime()) {
            getListOfLoansFromNetwork()
            setFlagFirstLaunchApp()
        } else {
            getListOfLoansFromDb()
        }
    }

    private fun setFlagFirstLaunchApp() = setFlagFirstLaunchAppUseCase(false)

    private fun isAppLaunchedFirstTime() = getFlagFirstLaunchAppUseCase()

    private fun getListOfLoansFromDb() {
        getListOfLoansFromDbUseCase()
                .compose(applySchedulers())
                .subscribe({
                    view?.showLoans(it)
                }, {
                    Log.e(Constants.TAG_ERROR, "get list of loan from db: ${it.message}")
                })
                .addTo(compositeDisposable)
    }

    private fun getListOfLoansFromNetwork() {
        getListOfLoansFromNetworkUseCase()
                .compose(applySchedulers())
                .subscribe({
                    processingResponseGetListOfLoans(it)
                }, {
                    Log.e(Constants.TAG_ERROR, "get list of loan from network: ${it.message}")
                })
                .addTo(compositeDisposable)
    }

    private fun processingResponseGetListOfLoans(response: Response<List<Loan>>) {
        view?.setRefreshing(false)
        if (response.isSuccessful) {
            val listOfLoans = response.body()
            listOfLoans?.let {
                view?.showLoans(it)
                saveListOfLoansInDb(it)
            }
        }
    }

    private fun saveListOfLoansInDb(listOfLoans: List<Loan>) {
        Completable.fromAction { saveListOfLoansToDbUseCase(listOfLoans) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {
                    Log.e(Constants.TAG_ERROR, "save list of loans in database: ${it.message}")
                })
                .addTo(compositeDisposable)
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

    override fun onRefresh() {
        getListOfLoansFromNetwork()
    }

    override fun <T> attachView(view: T) {
        this.view = view as IListOfLoansView
    }

}