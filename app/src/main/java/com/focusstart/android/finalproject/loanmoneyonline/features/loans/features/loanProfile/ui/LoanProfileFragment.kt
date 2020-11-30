package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.loanProfile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.loanProfile.presentation.ILoanProfilePresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.loanProfile.presentation.ILoanProfileView
import javax.inject.Inject

class LoanProfileFragment : Fragment(), ILoanProfileView {
    @Inject
    lateinit var presenter: ILoanProfilePresenter

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
        initView(fragmentLayout)
        return fragmentLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
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
        presenter.detachView()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume(arguments)
    }

    private fun initPresenter() {
        activity?.application?.let { getPresentersComponent(it).inject(this) }
        presenter.attachView(this)
    }

    override fun showLoanProfile(
            firstName: String,
            lastName: String,
            phoneNumber: String,
            date: String,
            amount: String,
            period: String,
            percent: String,
            state: String
    ) {
        tvFirstName.text = firstName
        tvLastName.text = lastName
        tvPhoneNumber.text = phoneNumber
        tvDate.text = date
        tvAmount.text = amount
        tvPeriod.text = period
        tvPercent.text = percent
        tvState.text = state
    }


}