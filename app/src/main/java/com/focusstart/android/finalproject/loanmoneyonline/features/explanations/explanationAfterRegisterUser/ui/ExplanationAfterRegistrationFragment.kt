package com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterUser.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterUser.presentation.IExplanationAfterRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterUser.presentation.IExplanationAfterRegistrationView
import javax.inject.Inject

class ExplanationAfterRegistrationFragment : Fragment(), IExplanationAfterRegistrationView {
    @Inject
    lateinit var presenter: IExplanationAfterRegistrationPresenter

    private lateinit var btnGetStartedInApp: Button

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout =
                inflater.inflate(R.layout.fragment_explanation_after_registration, container, false)
        initView(fragmentLayout)
        return fragmentLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    private fun initView(fragmentLayout: View) {
        btnGetStartedInApp = fragmentLayout.findViewById(R.id.btn_get_started_in_app)
        btnGetStartedInApp.setOnClickListener { presenter.onGetStartedInAppButtonClicked() }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    private fun initPresenter() {
        activity?.application?.let { getPresentersComponent(it).inject(this) }
        presenter.attachView(this)
    }

    override fun navigateToLoanRegistrationFragment() {
        navigateToDestinationScreen(R.id.action_explanationAfterRegistrationFragment_to_loanRegistrationFragment, this)
    }

}