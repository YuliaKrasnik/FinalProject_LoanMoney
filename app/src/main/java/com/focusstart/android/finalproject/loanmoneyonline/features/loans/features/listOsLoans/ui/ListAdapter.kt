package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.ui

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan

class ListAdapter(
        private val determineColorState: (String, Resources) -> Int,
        private val transformNameState: (String, Resources) -> String,
        private val transformDate: (String, Resources) -> String,
        private val clickFunction: (Loan) -> Unit) : RecyclerView.Adapter<ItemViewHolder>() {

    private val itemsList = mutableListOf<Loan>()

    fun updateItems(newItems: List<Loan>) {
        itemsList.clear()
        itemsList.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(view, determineColorState, transformNameState, transformDate, clickFunction)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemsList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = itemsList.size

}