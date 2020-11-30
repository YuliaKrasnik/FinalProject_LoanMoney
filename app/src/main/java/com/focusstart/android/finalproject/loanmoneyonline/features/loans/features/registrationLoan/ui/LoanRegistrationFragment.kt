package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.registrationLoan.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.registrationLoan.presentation.ILoanRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.registrationLoan.presentation.ILoanRegistrationView
import javax.inject.Inject

class LoanRegistrationFragment : Fragment(), ILoanRegistrationView {
    @Inject
    lateinit var presenter: ILoanRegistrationPresenter

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
        initView(fragmentLayout)
        savedInstanceState?.let { presenter.onRestoreInstanceState(savedInstanceState) }
        return fragmentLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
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
            presenter.onRegistrationLoanButtonClicked(
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etPhoneNumber.text.toString(),
                    tvValueAmountSeekBar.text.toString(),
                    tvValuePeriod.text.toString(),
                    tvValuePercent.text.toString()
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    private fun setChangeListenerOnAmount() {
        sbAmount.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                val transformedProgress = presenter.getTransformedProgressValueInSeekBar(progress)
                transformedProgress.let {
                    tvValueAmountSeekBar.text = (transformedProgress).toString()
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }


    private fun initPresenter() {
        activity?.application?.let { getPresentersComponent(it).inject(this) }
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        presenter.clear()
        super.onDestroy()
    }

    override fun navigateToExplanationAfterRegisterLoanFragment() {
        navigateToDestinationScreen(R.id.action_loanRegistrationFragment_to_explanationAfterRegisterLoanFragment, this)
    }

    override fun showToast(message: String) =
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()

    override fun showImmutableConditions(percent: Double, period: Int) {
        tvValuePeriod.text = period.toString()
        tvValuePercent.text = percent.toString()
    }

    override fun setMaxInSeekBar(maxValue: Int) {
        sbAmount.max = maxValue
    }

    override fun setProgressInSeekBar(progress: Int) {
        sbAmount.progress = progress
    }

}