package com.focusstart.android.finalproject.loanmoneyonline.ui.listOfLoans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_AMOUNT
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_DATE
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_FIRST_NAME
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_ID
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_LAST_NAME
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_PERCENT
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_PERIOD
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_PHONE_NUMBER
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BUNDLE_KEY_STATE
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
        presenter = ListOfLoansPresenterFactory.create()
        presenter?.attachView(this)
    }

    override fun onDestroy() {
        presenter?.detachView()
        presenter?.clear()
        super.onDestroy()
    }

    override fun showLoans(listOfLoans: List<Loan>) {
        val listAdapter = ListAdapter() { loan ->
            val bundle = Bundle()
            bundle.putInt(BUNDLE_KEY_AMOUNT, loan.amount)
            bundle.putString(BUNDLE_KEY_DATE, loan.date)
            bundle.putString(BUNDLE_KEY_FIRST_NAME, loan.firstName)
            bundle.putInt(BUNDLE_KEY_ID, loan.id)
            bundle.putString(BUNDLE_KEY_LAST_NAME, loan.lastName)
            bundle.putDouble(BUNDLE_KEY_PERCENT, loan.percent)
            bundle.putInt(BUNDLE_KEY_PERIOD, loan.period)
            bundle.putString(BUNDLE_KEY_PHONE_NUMBER, loan.phoneNumber)
            bundle.putString(BUNDLE_KEY_STATE, loan.state)

            val navController = NavHostFragment.findNavController(this)
            navController.navigate(R.id.action_listOfLoansFragment_to_loanProfileFragment, bundle)
        }
        recyclerView.adapter = listAdapter
        listAdapter.updateItems(listOfLoans)
    }

    override fun navigateToLoanRegistrationFragment() {
        val navController = NavHostFragment.findNavController(this)
        navController.navigate(R.id.action_listOfLoansFragment_to_loanRegistrationFragment)
    }

}