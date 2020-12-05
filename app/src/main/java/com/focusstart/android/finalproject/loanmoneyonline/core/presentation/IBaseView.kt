package com.focusstart.android.finalproject.loanmoneyonline.core.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

interface IBaseView {

    fun navigateToDestinationScreen(idWay: Int, fragment: Fragment, bundle: Bundle? = null) {
        val navController = NavHostFragment.findNavController(fragment)
        bundle?.let { navController.navigate(idWay, bundle) } ?: navController.navigate(idWay)
    }
}