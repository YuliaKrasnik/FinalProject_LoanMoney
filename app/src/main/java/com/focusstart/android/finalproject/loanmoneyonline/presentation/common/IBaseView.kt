package com.focusstart.android.finalproject.loanmoneyonline.presentation.common

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.focusstart.android.finalproject.loanmoneyonline.App
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.*

interface IBaseView {
    fun getPresentersComponent(app: Application): PresentersComponent {
        return (app as App).getApplicationComponent().newPresenterComponent(
            PresentersModule()
        )
    }

    fun navigateToDestinationScreen(idWay: Int, fragment: Fragment, bundle: Bundle? = null) {
        val navController = NavHostFragment.findNavController(fragment)
        bundle?.let { navController.navigate(idWay, bundle) } ?: navController.navigate(idWay)
    }
}