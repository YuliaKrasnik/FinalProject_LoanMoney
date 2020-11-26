package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.NavHostFragment
import com.focusstart.android.finalproject.loanmoneyonline.Constants
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.di.AuthenticationPresenterFactory
import com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication.IAuthenticationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication.IAuthenticationView

class AuthenticationFragment : Fragment(), IAuthenticationView {
    private var presenter: IAuthenticationPresenter? = null

    private lateinit var etNameUser: EditText
    private lateinit var etPasswordUser: EditText
    private lateinit var btnAuthentication: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_authentication, container, false)
        initPresenter()
        initView(fragmentLayout)
        return fragmentLayout
    }

    private fun initPresenter() {
        presenter = AuthenticationPresenterFactory.create()
        presenter?.attachView(this)
    }

    override fun onDestroy() {
        presenter?.detachView()
        presenter?.clear()
        super.onDestroy()
    }

    private fun initView(fragmentLayout: View) {
        etNameUser = fragmentLayout.findViewById(R.id.et_name_user_in_auth)
        etPasswordUser = fragmentLayout.findViewById(R.id.et_password_user_in_auth)
        btnAuthentication = fragmentLayout.findViewById(R.id.btn_authentication)
        btnAuthentication.setOnClickListener {
            presenter?.onAuthenticationButtonClicked(
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

    override fun navigateToListOfLoansFragment() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_authenticationFragment_to_listOfLoansFragment)
    }

}