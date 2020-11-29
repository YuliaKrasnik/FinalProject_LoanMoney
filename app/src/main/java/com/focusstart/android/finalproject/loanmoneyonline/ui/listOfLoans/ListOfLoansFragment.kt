package com.focusstart.android.finalproject.loanmoneyonline.ui.listOfLoans

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.focusstart.android.finalproject.loanmoneyonline.Constants
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.di.ListOfLoansPresenterFactory
import com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans.IListOfLoansPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans.IListOfLoansView

class ListOfLoansFragment : Fragment(), IListOfLoansView {
    private var presenter: IListOfLoansPresenter? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var btnCreateNewLoan: Button

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_list_of_loans, container, false)
        initPresenter()
        initView(fragmentLayout)
        return fragmentLayout
    }

    private fun initView(fragmentLayout: View) {
        recyclerView = fragmentLayout.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        btnCreateNewLoan = fragmentLayout.findViewById(R.id.btn_create_new_loan)
        btnCreateNewLoan.setOnClickListener { presenter?.onCreateNewLoanButtonClicked() }
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    private fun initPresenter() {
        val sharedPreferences = context?.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE)
        sharedPreferences?.let {
            presenter = ListOfLoansPresenterFactory.create(it)
            presenter?.attachView(this)
        }
    }

    override fun onDestroy() {
        presenter?.detachView()
        presenter?.clear()
        super.onDestroy()
    }

    override fun showLoans(listOfLoans: List<Loan>) {
        val listAdapter = ListAdapter { loan ->
            onClickItemFunction(loan)
        }
        recyclerView.adapter = listAdapter
        listAdapter.updateItems(listOfLoans)
    }

    private fun onClickItemFunction(loan: Loan) {
        val bundle = presenter?.getNavigationBundle(loan)
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_listOfLoansFragment_to_loanProfileFragment, bundle)
    }

    override fun navigateToLoanRegistrationFragment() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_listOfLoansFragment_to_loanRegistrationFragment)
    }

}