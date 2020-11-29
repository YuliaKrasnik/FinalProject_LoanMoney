package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegistration.IExplanationAfterRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegistration.IExplanationAfterRegistrationView
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
        initPresenter()
        initView(fragmentLayout)
        return fragmentLayout
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
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_explanationAfterRegistrationFragment_to_loanRegistrationFragment)
    }

}