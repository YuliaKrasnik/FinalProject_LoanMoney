package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.presentation.IListOfLoansPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.presentation.IListOfLoansView
import javax.inject.Inject

class ListOfLoansFragment : Fragment(), IListOfLoansView {
    @Inject
    lateinit var presenter: IListOfLoansPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var btnCreateNewLoan: ImageButton

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
        activity?.application?.let { getPresentersComponent(it).inject(this) }
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
        val bundle = presenter.
        getNavigationBundle(loan, resources)
        navigateToDestinationScreen(R.id.action_listOfLoansFragment_to_loanProfileFragment, this, bundle)
    }

    override fun navigateToLoanRegistrationFragment() {
        navigateToDestinationScreen(R.id.action_listOfLoansFragment_to_loanRegistrationFragment, this)
    }

}