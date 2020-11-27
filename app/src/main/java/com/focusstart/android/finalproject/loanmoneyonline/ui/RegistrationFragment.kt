package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.focusstart.android.finalproject.loanmoneyonline.Constants
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.di.RegistrationPresenterFactory
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser.IRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser.IRegistrationView

class RegistrationFragment : Fragment(), IRegistrationView {
    private var presenter: IRegistrationPresenter? = null

    private lateinit var etNameUser: EditText
    private lateinit var etPasswordUser: EditText
    private lateinit var btnRegistration: Button

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_registration, container, false)
        initPresenter()
        initView(fragmentLayout)
        return fragmentLayout
    }

    private fun initPresenter() {
        presenter = RegistrationPresenterFactory.create()
        presenter?.attachView(this)
    }

    override fun onDestroy() {
        presenter?.detachView()
        presenter?.clear()
        super.onDestroy()
    }

    private fun initView(fragmentLayout: View) {
        etNameUser = fragmentLayout.findViewById(R.id.et_name_user)
        etPasswordUser = fragmentLayout.findViewById(R.id.et_password_user)
        btnRegistration = fragmentLayout.findViewById(R.id.btn_registration)
        btnRegistration.setOnClickListener {
            presenter?.onRegistrationButtonClicked(
                    etNameUser.text.toString(),
                    etPasswordUser.text.toString()
            )
        }
    }

    override fun saveBearerToken(token: String) {
        val settings =
                context?.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE)
        val editor = settings?.edit()
        editor?.putString(Constants.APP_PREFERENCES_TOKEN, token)
        editor?.apply()
    }

    override fun navigateToExplanationAfterRegistrationFragment() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_registrationFragment_to_explanationAfterRegistrationFragment)
    }

}