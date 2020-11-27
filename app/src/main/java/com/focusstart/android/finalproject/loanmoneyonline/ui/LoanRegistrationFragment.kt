package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.focusstart.android.finalproject.loanmoneyonline.Constants
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.di.LoanRegistrationPresenterFactory
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan.ILoanRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan.ILoanRegistrationView

class LoanRegistrationFragment : Fragment(), ILoanRegistrationView {
    private var presenter: ILoanRegistrationPresenter? = null

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etPhoneNumber: EditText
    private lateinit var sbAmount: SeekBar
    private lateinit var tvValueAmountSeekBar: TextView
    private lateinit var tvValuePeriod: TextView
    private lateinit var tvValuePercent: TextView
    private lateinit var btnRegistrationLoan: Button

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_loan_registration, container, false)
        initPresenter()
        initView(fragmentLayout)
        return fragmentLayout
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    private fun initView(fragmentLayout: View) {
        etFirstName = fragmentLayout.findViewById(R.id.et_first_name)
        etLastName = fragmentLayout.findViewById(R.id.et_last_name)
        etPhoneNumber = fragmentLayout.findViewById(R.id.et_phone_number)

        sbAmount = fragmentLayout.findViewById(R.id.sb_amount)
        setChangeListenerOnAmount()
        tvValueAmountSeekBar = fragmentLayout.findViewById(R.id.tv_value_amount_seekBar)

        tvValuePercent = fragmentLayout.findViewById(R.id.tv_value_percent)
        tvValuePeriod = fragmentLayout.findViewById(R.id.tv_value_period)

        btnRegistrationLoan = fragmentLayout.findViewById(R.id.btn_registration_loan)
        btnRegistrationLoan.setOnClickListener {
            presenter?.onRegistrationLoanButtonClicked(
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etPhoneNumber.text.toString(),
                    tvValueAmountSeekBar.text.toString(),
                    tvValuePeriod.text.toString(),
                    tvValuePercent.text.toString())
        }
    }


    private fun setChangeListenerOnAmount() {
        sbAmount.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                val transformedProgress = progress / 1000 * 1000
                tvValueAmountSeekBar.text = (transformedProgress).toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //       TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //    TODO("Not yet implemented")
            }

        })
    }


    private fun initPresenter() {
        val sharedPreferences = context?.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE)
        sharedPreferences?.let {
            presenter = LoanRegistrationPresenterFactory.create(it)
            presenter?.attachView(this)
        }
    }

    override fun onDestroy() {
        presenter?.detachView()
        presenter?.clear()
        super.onDestroy()
    }

    override fun navigateToExplanationAfterRegisterLoanFragment() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_loanRegistrationFragment_to_explanationAfterRegisterLoanFragment)
    }

    override fun showToast(message: String) = Toast.makeText(context, message, Toast.LENGTH_LONG).show()

    override fun showConditions(percent: Double, period: Int, maxAmount: Int) {
        tvValuePeriod.text = period.toString()
        tvValuePercent.text = percent.toString()
        sbAmount.max = maxAmount
    }

}