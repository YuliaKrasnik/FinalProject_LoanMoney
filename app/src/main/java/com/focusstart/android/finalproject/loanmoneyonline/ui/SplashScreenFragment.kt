package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.presentation.splashScreen.ISplashScreenPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.splashScreen.ISplashScreenView
import javax.inject.Inject

class SplashScreenFragment : Fragment(), ISplashScreenView {
    @Inject
    lateinit var presenter: ISplashScreenPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_splash_screen, container, false)
        initPresenter()
        return fragmentLayout
    }

    override fun onDestroy() {
        presenter.detachView()
        presenter.clear()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    private fun initPresenter() {
        activity?.application?.let { getPresentersComponent(it).inject(this) }
        presenter.attachView(this)
    }

    override fun navigateToStartFragment() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_splashScreenFragment_to_startFragment)
    }

    override fun navigateToListOfLoansFragment() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_splashScreenFragment_to_listOfLoansFragment)
    }

}