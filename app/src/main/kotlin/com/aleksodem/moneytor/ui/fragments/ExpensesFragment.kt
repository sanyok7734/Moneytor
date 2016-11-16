package com.aleksodem.moneytor.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aleksodem.moneytor.R
import com.aleksodem.moneytor.mvp.models.Cost
import com.aleksodem.moneytor.mvp.presenters.ExpensesPresenter
import com.aleksodem.moneytor.mvp.views.ExpensesView
import com.aleksodem.moneytor.ui.adapters.ExpensesAdapter
import com.arellomobile.mvp.MvpFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.expenses_fragment.*

class ExpensesFragment : MvpFragment(), ExpensesView {

    @InjectPresenter
    lateinit var presenter: ExpensesPresenter
    lateinit var expensesAdapter: ExpensesAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.expenses_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        recyclerListExpenses.layoutManager = LinearLayoutManager(activity)
        presenter.onExpensesLoad()
    }

    override fun onExpensesLoad(expenses: List<Cost>) {
        expensesAdapter = ExpensesAdapter(expenses)
        recyclerListExpenses.adapter = expensesAdapter;
    }
}