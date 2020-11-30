package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegisterLoan.IExplanationAfterRegisterLoanPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegisterLoan.IExplanationAfterRegisterLoanView
import javax.inject.Inject

class ExplanationAfterRegisterLoanFragment : Fragment(), IExplanationAfterRegisterLoanView {
    @Inject
    lateinit var presenter: IExplanationAfterRegisterLoanPresenter
    private lateinit var btnNavigateToListOfLoans: Button

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout =
                inflater.inflate(R.layout.fragment_explanation_after_register_loan, container, false)
        initView(fragmentLayout)
        return fragmentLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    private fun initView(fragmentLayout: View) {
        btnNavigateToListOfLoans = fragmentLayout.findViewById(R.id.btn_navigate_in_loans_list)
        btnNavigateToListOfLoans.setOnClickListener { presenter.onNavigateToListOfLoansButtonClicked() }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    private fun initPresenter() {
        activity?.application?.let { getPresentersComponent(it).inject(this) }
        presenter.attachView(this)
    }

    override fun navigateToListOfLoansFragment() {
        navigateToDestinationScreen(R.id.action_explanationAfterRegisterLoanFragment_to_listOfLoansFragment, this)
    }

}