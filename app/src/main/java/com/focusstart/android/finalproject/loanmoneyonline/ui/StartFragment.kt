package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.presentation.startWindow.IStartWindowPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.startWindow.IStartWindowView
import javax.inject.Inject

class StartFragment : Fragment(), IStartWindowView {
    @Inject
    lateinit var presenter: IStartWindowPresenter

    private lateinit var btnOpenRegistrationWindow: Button
    private lateinit var btnOpenAuthenticationWindow: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_start, container, false)
        initPresenter()
        initView(fragmentLayout)
        return fragmentLayout
    }

    private fun initView(fragmentLayout: View) {
        btnOpenRegistrationWindow = fragmentLayout.findViewById(R.id.btn_open_registration_window)
        btnOpenRegistrationWindow.setOnClickListener { presenter.onRegistrationButtonClicked() }

        btnOpenAuthenticationWindow = fragmentLayout.findViewById(R.id.btn_open_login_window)
        btnOpenAuthenticationWindow.setOnClickListener { presenter.onAuthenticationButtonClicked() }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    private fun initPresenter() {
        activity?.application?.let { getPresentersComponent(it).inject(this) }
        presenter.attachView(this)
    }

    override fun navigateToAuthenticationFragment() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_startFragment_to_authenticationFragment)
    }

    override fun navigateToRegistrationFragment() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_startFragment_to_registrationFragment)
    }


}