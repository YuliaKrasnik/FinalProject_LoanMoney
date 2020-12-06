package com.focusstart.android.finalproject.loanmoneyonline.features.loans.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.focusstart.android.finalproject.loanmoneyonline.App
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.module.LoanPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation.IListOfLoansPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation.IListOfLoansView
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants
import javax.inject.Inject

class ListOfLoansFragment : Fragment(), IListOfLoansView {

    @Inject
    lateinit var presenter: IListOfLoansPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var btnCreateNewLoan: ImageButton
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_list_of_loans, container, false)
        initView(fragmentLayout)
        return fragmentLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    private fun initView(fragmentLayout: View) {
        swipeRefreshLayout = fragmentLayout.findViewById(R.id.swipe_refresh)
        swipeRefreshLayout.setOnRefreshListener { presenter.onRefresh() }

        recyclerView = fragmentLayout.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        btnCreateNewLoan = fragmentLayout.findViewById(R.id.btn_create_new_loan)
        btnCreateNewLoan.setOnClickListener { presenter.onCreateNewLoanButtonClicked() }
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    private fun initPresenter() {
        (activity?.application as App)
                .getApplicationComponent()
                .newLoansComponent(LoanPresentersModule())
                .inject(this)
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        presenter.clear()
        super.onDestroy()
    }

    override fun showLoans(listOfLoans: List<Loan>) {
        val listAdapter = ListAdapter(
                { state, resources -> presenter.determineColorState(state, resources) },
                { state, resources -> presenter.transformNameState(state, resources) },
                { date, resources -> presenter.transformDate(date, resources) },
                { loan -> onClickItemFunction(loan) }
        )
        recyclerView.adapter = listAdapter
        listAdapter.updateItems(listOfLoans)
    }

    private fun onClickItemFunction(loan: Loan) {
        val bundle = presenter.getNavigationBundle(loan, resources)
        navigateToDestinationScreen(R.id.action_listOfLoansFragment_to_loanProfileFragment, this, bundle)
    }

    override fun navigateToLoanRegistrationFragment() {
        navigateToDestinationScreen(R.id.action_listOfLoansFragment_to_loanRegistrationFragment, this)
    }

    override fun setRefreshing(flag: Boolean) {
        swipeRefreshLayout.isRefreshing = flag
    }

}