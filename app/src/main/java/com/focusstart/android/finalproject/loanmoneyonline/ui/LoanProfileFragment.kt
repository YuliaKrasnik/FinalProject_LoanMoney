package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.di.LoanProfilePresenterFactory
import com.focusstart.android.finalproject.loanmoneyonline.presentation.loanProfile.ILoanProfilePresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.loanProfile.ILoanProfileView

class LoanProfileFragment : Fragment(), ILoanProfileView {
    private var presenter: ILoanProfilePresenter? = null

    private lateinit var tvFirstName: TextView
    private lateinit var tvLastName: TextView
    private lateinit var tvPhoneNumber: TextView
    private lateinit var tvDate: TextView
    private lateinit var tvAmount: TextView
    private lateinit var tvPeriod: TextView
    private lateinit var tvPercent: TextView
    private lateinit var tvState: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_loan_profile, container, false)
        initPresenter()
        initView(fragmentLayout)
        return fragmentLayout
    }

    private fun initView(fragmentLayout: View) {
        tvFirstName = fragmentLayout.findViewById(R.id.tv_profile_value_first_name)
        tvLastName = fragmentLayout.findViewById(R.id.tv_profile_value_last_name)
        tvPhoneNumber = fragmentLayout.findViewById(R.id.tv_profile_value_phone_number)
        tvDate = fragmentLayout.findViewById(R.id.tv_profile_value_date)
        tvAmount = fragmentLayout.findViewById(R.id.tv_profile_value_amount)
        tvPeriod = fragmentLayout.findViewById(R.id.tv_profile_value_period)
        tvPercent = fragmentLayout.findViewById(R.id.tv_profile_value_percent)
        tvState = fragmentLayout.findViewById(R.id.tv_profile_value_state)
    }

    override fun onDestroy() {
        presenter?.detachView()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume(arguments)
    }

    private fun initPresenter() {
        presenter = LoanProfilePresenterFactory.create()
        presenter?.attachView(this)
    }

    override fun showLoanProfile(loan: Loan) {
        tvFirstName.text = loan.firstName
        tvLastName.text = loan.lastName
        tvPhoneNumber.text = loan.phoneNumber
        tvDate.text = loan.date
        tvAmount.text = loan.amount.toString()
        tvPeriod.text = loan.period.toString()
        tvPercent.text = loan.percent.toString()
        tvState.text = loan.state
    }

}