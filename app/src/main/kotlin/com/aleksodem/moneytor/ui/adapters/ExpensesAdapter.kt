package com.aleksodem.moneytor.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aleksodem.moneytor.R
import com.aleksodem.moneytor.mvp.models.Cost
import kotlinx.android.synthetic.main.item_expense.view.*

class ExpensesAdapter(var expenses : List<Cost>) : RecyclerView.Adapter<ExpensesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_expense, parent, false)
        return ExpensesAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.dataBind(expenses[position])
    }

    override fun getItemCount(): Int = expenses.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun dataBind(cost: Cost) {
            itemView.titleCategory.text = cost.category.title
            itemView.note.text = cost.note
            itemView.price.text = cost.value.toString()
            itemView.iconCategory.setImageResource(cost.category.icon)
        }
    }
}